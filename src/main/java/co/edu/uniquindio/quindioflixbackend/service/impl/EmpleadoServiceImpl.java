package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEmpleadoJerarquiaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.EmpleadoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Departamento;
import co.edu.uniquindio.quindioflixbackend.model.Empleado;
import co.edu.uniquindio.quindioflixbackend.repository.DepartamentoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.EmpleadoRepository;
import co.edu.uniquindio.quindioflixbackend.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;
    private final EmpleadoMapper empleadoMapper;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository,
                               DepartamentoRepository departamentoRepository,
                               EmpleadoMapper empleadoMapper) {
        this.empleadoRepository = empleadoRepository;
        this.departamentoRepository = departamentoRepository;
        this.empleadoMapper = empleadoMapper;
    }

    @Override
    public ResponseEmpleadoDTO crearEmpleado(RequestEmpleadoDTO dto) {
        validarDepartamento(dto.getIdDepartamento());
        validarSupervisor(null, dto.getIdDepartamento(), dto.getIdSupervisor());

        Empleado empleado = empleadoRepository.save(empleadoMapper.toEntity(dto));
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
        empleado.setTelefono(dto.getTelefono());
        empleado.setIdDepartamento(dto.getIdDepartamento());
        empleado.setIdSupervisor(dto.getIdSupervisor());
        empleado.setCargo(dto.getCargo());
        return empleadoMapper.toDTO(empleadoRepository.save(empleado));
    }

    @Override
    public void eliminarEmpleado(Long idEmpleado) {
        Empleado empleado = buscarEmpleado(idEmpleado);

        if (empleadoRepository.existsByIdSupervisor(idEmpleado)) {
            throw new RuntimeException("No se puede eliminar un empleado que supervisa a otros empleados");
        }

        boolean esJefe = departamentoRepository.findAll()
                .stream()
                .anyMatch(departamento -> idEmpleado.equals(departamento.getIdJefe()));

        if (esJefe) {
            throw new RuntimeException("No se puede eliminar un empleado asignado como jefe de departamento");
        }

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
