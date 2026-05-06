package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestContenidoRelacionadoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoRelacionadoDTO;

import java.util.List;

public interface ContenidoRelacionadoService {

    ResponseContenidoRelacionadoDTO crearRelacion(RequestContenidoRelacionadoDTO dto);

    List<ResponseContenidoRelacionadoDTO> listarRelaciones();

    List<ResponseContenidoRelacionadoDTO> listarPorContenidoOrigen(Long idContenidoOrigen);

    List<ResponseContenidoRelacionadoDTO> listarPorContenidoDestino(Long idContenidoDestino);

    void eliminarRelacion(Long idContenidoOrigen, Long idContenidoDestino);
}
