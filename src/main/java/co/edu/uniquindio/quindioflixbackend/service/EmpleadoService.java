package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEmpleadoDTO;

import java.util.List;

public interface EmpleadoService {

    ResponseEmpleadoDTO crearEmpleado(RequestEmpleadoDTO dto);

    ResponseEmpleadoDTO obtenerEmpleado(Long idEmpleado);

    List<ResponseEmpleadoDTO> listarEmpleados();

    List<ResponseEmpleadoDTO> listarPorDepartamento(Long idDepartamento);

    List<ResponseEmpleadoDTO> listarPorSupervisor(Long idSupervisor);

    ResponseEmpleadoDTO actualizarEmpleado(Long idEmpleado, RequestEmpleadoDTO dto);

    void eliminarEmpleado(Long idEmpleado);
}
