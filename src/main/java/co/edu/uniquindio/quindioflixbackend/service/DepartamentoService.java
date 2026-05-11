package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestDepartamentoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseDepartamentoDTO;

import java.util.List;

public interface DepartamentoService {

    ResponseDepartamentoDTO crearDepartamento(RequestDepartamentoDTO dto);

    ResponseDepartamentoDTO obtenerDepartamento(Long idDepartamento);

    List<ResponseDepartamentoDTO> listarDepartamentos();

    ResponseDepartamentoDTO actualizarDepartamento(Long idDepartamento, RequestDepartamentoDTO dto);

    ResponseDepartamentoDTO asignarJefe(Long idDepartamento, Long idJefe);

    void eliminarDepartamento(Long idDepartamento);
}
