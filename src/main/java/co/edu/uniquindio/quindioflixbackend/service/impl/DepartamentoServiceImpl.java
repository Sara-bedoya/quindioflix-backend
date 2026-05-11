package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestDepartamentoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseDepartamentoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.DepartamentoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Departamento;
import co.edu.uniquindio.quindioflixbackend.model.Empleado;
import co.edu.uniquindio.quindioflixbackend.repository.DepartamentoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.EmpleadoRepository;
import co.edu.uniquindio.quindioflixbackend.service.DepartamentoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoMapper departamentoMapper;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository,
                                   EmpleadoRepository empleadoRepository,
                                   DepartamentoMapper departamentoMapper) {
        this.departamentoRepository = departamentoRepository;
        this.empleadoRepository = empleadoRepository;
        this.departamentoMapper = departamentoMapper;
    }

    @Override
    public ResponseDepartamentoDTO crearDepartamento(RequestDepartamentoDTO dto) {
        Departamento departamento = departamentoMapper.toEntity(dto);
        departamento.setIdJefe(null);
        departamento = departamentoRepository.save(departamento);
        return departamentoMapper.toDTO(departamento);
    }

    @Override
    public ResponseDepartamentoDTO obtenerDepartamento(Long idDepartamento) {
        return departamentoMapper.toDTO(buscarDepartamento(idDepartamento));
    }

    @Override
    public List<ResponseDepartamentoDTO> listarDepartamentos() {
        return departamentoRepository.findAll().stream().map(departamentoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseDepartamentoDTO actualizarDepartamento(Long idDepartamento, RequestDepartamentoDTO dto) {
        Departamento departamento = buscarDepartamento(idDepartamento);
        departamento.setNombreDepartamento(dto.getNombreDepartamento());
        if (dto.getIdJefe() != null) {
            validarJefe(idDepartamento, dto.getIdJefe());
            departamento.setIdJefe(dto.getIdJefe());
        }
        return departamentoMapper.toDTO(departamentoRepository.save(departamento));
    }

    @Override
    public ResponseDepartamentoDTO asignarJefe(Long idDepartamento, Long idJefe) {
        Departamento departamento = buscarDepartamento(idDepartamento);
        validarJefe(idDepartamento, idJefe);
        departamento.setIdJefe(idJefe);
        return departamentoMapper.toDTO(departamentoRepository.save(departamento));
    }

    @Override
    public void eliminarDepartamento(Long idDepartamento) {
        if (empleadoRepository.existsByIdDepartamento(idDepartamento)) {
            throw new RuntimeException("No se puede eliminar un departamento con empleados asociados");
        }

        departamentoRepository.delete(buscarDepartamento(idDepartamento));
    }

    private Departamento buscarDepartamento(Long idDepartamento) {
        return departamentoRepository.findById(idDepartamento)
                .orElseThrow(() -> new RuntimeException("No existe departamento con id " + idDepartamento));
    }

    private void validarJefe(Long idDepartamento, Long idJefe) {
        Empleado jefe = empleadoRepository.findById(idJefe)
                .orElseThrow(() -> new RuntimeException("No existe empleado jefe con id " + idJefe));

        if (!idDepartamento.equals(jefe.getIdDepartamento())) {
            throw new RuntimeException("El jefe debe pertenecer al mismo departamento");
        }
    }
}
