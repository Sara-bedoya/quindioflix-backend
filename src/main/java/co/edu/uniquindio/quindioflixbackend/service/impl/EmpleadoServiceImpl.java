package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEmpleadoJerarquiaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.EmpleadoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Departamento;
import co.edu.uniquindio.quindioflixbackend.model.Empleado;
import co.edu.uniquindio.quindioflixbackend.repository.DepartamentoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.EmpleadoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.ContenidoRepository;
import co.edu.uniquindio.quindioflixbackend.service.EmpleadoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;
    private final ContenidoRepository contenidoRepository;
    private final EmpleadoMapper empleadoMapper;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository,
                               DepartamentoRepository departamentoRepository,
                               ContenidoRepository contenidoRepository,
                               EmpleadoMapper empleadoMapper) {
        this.empleadoRepository = empleadoRepository;
        this.departamentoRepository = departamentoRepository;
        this.contenidoRepository = contenidoRepository;
        this.empleadoMapper = empleadoMapper;
    }

    @Override
    public ResponseEmpleadoDTO crearEmpleado(RequestEmpleadoDTO dto) {
        validarDepartamento(dto.getIdDepartamento());
        validarSupervisor(null, dto.getIdDepartamento(), dto.getIdSupervisor());
        validarPassword(dto.getPassword());

        Empleado empleado = empleadoMapper.toEntity(dto);
        empleado.setPassword(dto.getPassword());
        empleado = empleadoRepository.save(empleado);
        return empleadoMapper.toDTO(empleado);
    }

    @Override
    public ResponseEmpleadoDTO obtenerEmpleado(Long idEmpleado) {
        return empleadoMapper.toDTO(buscarEmpleado(idEmpleado));
    }

    @Override
    public List<ResponseEmpleadoDTO> listarEmpleados() {
        return convertirLista(empleadoRepository.findAll());
    }

    @Override
    public List<ResponseEmpleadoDTO> listarPorDepartamento(Long idDepartamento) {
        validarDepartamento(idDepartamento);
        return convertirLista(empleadoRepository.findByIdDepartamento(idDepartamento));
    }

    @Override
    public List<ResponseEmpleadoDTO> listarPorSupervisor(Long idSupervisor) {
        buscarEmpleado(idSupervisor);
        return convertirLista(empleadoRepository.findByIdSupervisor(idSupervisor));
    }

    @Override
    public List<ResponseEmpleadoDTO> listarPorNombreDepartamento(String nombreDepartamento) {
        Departamento departamento = departamentoRepository.findByNombreDepartamentoIgnoreCase(nombreDepartamento)
                .orElseThrow(() -> new RuntimeException("No existe departamento con nombre " + nombreDepartamento));

        return convertirLista(empleadoRepository.findByIdDepartamento(departamento.getIdDepartamento()));
    }

    @Override
    public ResponseEmpleadoJerarquiaDTO obtenerJerarquiaDepartamento(Long idDepartamento) {
        Departamento departamento = validarDepartamento(idDepartamento);

        if (departamento.getIdJefe() == null) {
            throw new RuntimeException("El departamento no tiene jefe asignado");
        }

        Empleado jefe = buscarEmpleado(departamento.getIdJefe());
        validarEmpleadoPerteneceDepartamento(jefe, idDepartamento, "El jefe no pertenece al departamento");

        return construirJerarquia(jefe);
    }

    @Override
    public ResponseEmpleadoDTO actualizarEmpleado(Long idEmpleado, RequestEmpleadoDTO dto) {
        Empleado empleado = buscarEmpleado(idEmpleado);
        validarDepartamento(dto.getIdDepartamento());
        validarSupervisor(idEmpleado, dto.getIdDepartamento(), dto.getIdSupervisor());

        empleado.setNombreCompleto(dto.getNombreCompleto());
        empleado.setEmail(dto.getEmail());
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            empleado.setPassword(dto.getPassword());
        }
        empleado.setTelefono(dto.getTelefono());
        empleado.setIdDepartamento(dto.getIdDepartamento());
        empleado.setIdSupervisor(dto.getIdSupervisor());
        empleado.setCargo(dto.getCargo());
        return empleadoMapper.toDTO(empleadoRepository.save(empleado));
    }

    @Override
    @Transactional
    public void eliminarEmpleado(Long idEmpleado) {
        Empleado empleado = buscarEmpleado(idEmpleado);

        empleadoRepository.findByIdSupervisor(idEmpleado).forEach(supervisado -> {
            supervisado.setIdSupervisor(null);
            empleadoRepository.save(supervisado);
        });

        departamentoRepository.findAll().forEach(departamento -> {
            if (idEmpleado.equals(departamento.getIdJefe())) {
                departamento.setIdJefe(null);
                departamentoRepository.save(departamento);
            }
        });

        contenidoRepository.findByIdEmpleadoResponsable(idEmpleado).forEach(contenido -> {
            contenido.setIdEmpleadoResponsable(null);
            contenidoRepository.save(contenido);
        });

        empleadoRepository.delete(empleado);
    }

    private Empleado buscarEmpleado(Long idEmpleado) {
        return empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new RuntimeException("No existe empleado con id " + idEmpleado));
    }

    private List<ResponseEmpleadoDTO> convertirLista(List<Empleado> empleados) {
        return empleados.stream().map(empleadoMapper::toDTO).collect(Collectors.toList());
    }

    private Departamento validarDepartamento(Long idDepartamento) {
        if (idDepartamento == null) {
            throw new RuntimeException("El departamento es obligatorio");
        }

        return departamentoRepository.findById(idDepartamento)
                .orElseThrow(() -> new RuntimeException("No existe departamento con id " + idDepartamento));
    }

    private void validarSupervisor(Long idEmpleado, Long idDepartamento, Long idSupervisor) {
        if (idSupervisor == null) {
            return;
        }

        if (idSupervisor.equals(idEmpleado)) {
            throw new RuntimeException("Un empleado no puede supervisarse a si mismo");
        }

        Empleado supervisor = buscarEmpleado(idSupervisor);
        validarEmpleadoPerteneceDepartamento(
                supervisor,
                idDepartamento,
                "El supervisor debe pertenecer al mismo departamento del empleado"
        );
    }

    private void validarPassword(String password) {
        if (password == null || password.isBlank()) {
            throw new RuntimeException("La contraseña del empleado es obligatoria");
        }
    }

    private void validarEmpleadoPerteneceDepartamento(Empleado empleado, Long idDepartamento, String mensaje) {
        if (!idDepartamento.equals(empleado.getIdDepartamento())) {
            throw new RuntimeException(mensaje);
        }
    }

    private ResponseEmpleadoJerarquiaDTO construirJerarquia(Empleado empleado) {
        List<ResponseEmpleadoJerarquiaDTO> supervisados = empleadoRepository.findByIdSupervisor(empleado.getIdEmpleado())
                .stream()
                .map(this::construirJerarquia)
                .collect(Collectors.toList());

        return ResponseEmpleadoJerarquiaDTO.builder()
                .idEmpleado(empleado.getIdEmpleado())
                .nombreCompleto(empleado.getNombreCompleto())
                .email(empleado.getEmail())
                .cargo(empleado.getCargo())
                .idDepartamento(empleado.getIdDepartamento())
                .supervisados(supervisados)
                .build();
    }
}
