package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoDTO;

import java.util.List;

public interface ContenidoService {

    ResponseContenidoDTO crearContenido(RequestContenidoDTO dto);

    ResponseContenidoDTO obtenerContenido(Long idContenido);

    List<ResponseContenidoDTO> listarContenidos();

    List<ResponseContenidoDTO> listarPorCategoria(Long idCategoria);

    List<ResponseContenidoDTO> listarPorGenero(Long idGenero);

    ResponseContenidoDTO actualizarContenido(Long idContenido, RequestContenidoDTO dto);

    void eliminarContenido(Long idContenido);
}
