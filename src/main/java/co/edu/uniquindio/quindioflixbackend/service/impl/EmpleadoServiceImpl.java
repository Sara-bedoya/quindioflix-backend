package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.EmpleadoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Empleado;
import co.edu.uniquindio.quindioflixbackend.repository.EmpleadoRepository;
import co.edu.uniquindio.quindioflixbackend.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, EmpleadoMapper empleadoMapper) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoMapper = empleadoMapper;
    }

    @Override
    public ResponseEmpleadoDTO crearEmpleado(RequestEmpleadoDTO dto) {
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
        return convertirLista(empleadoRepository.findByIdDepartamento(idDepartamento));
    }

    @Override
    public List<ResponseEmpleadoDTO> listarPorSupervisor(Long idSupervisor) {
        return convertirLista(empleadoRepository.findByIdSupervisor(idSupervisor));
    }

    @Override
    public ResponseEmpleadoDTO actualizarEmpleado(Long idEmpleado, RequestEmpleadoDTO dto) {
        Empleado empleado = buscarEmpleado(idEmpleado);
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
        empleadoRepository.delete(buscarEmpleado(idEmpleado));
    }

    private Empleado buscarEmpleado(Long idEmpleado) {
        return empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new RuntimeException("No existe empleado con id " + idEmpleado));
    }

    private List<ResponseEmpleadoDTO> convertirLista(List<Empleado> empleados) {
        return empleados.stream().map(empleadoMapper::toDTO).collect(Collectors.toList());
    }
}
