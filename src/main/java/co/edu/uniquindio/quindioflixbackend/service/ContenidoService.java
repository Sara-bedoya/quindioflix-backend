package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoDTO;

import java.util.List;

public interface ContenidoService {

    ResponseContenidoDTO crearContenido(RequestContenidoDTO dto);

    ResponseContenidoDTO obtenerContenido(Long idContenido);

    List<ResponseContenidoDTO> listarContenidos();

    List<ResponseContenidoDTO> listarDisponiblesParaPerfil(Long idPerfil);

    ResponseContenidoDTO obtenerContenidoParaPerfil(Long idContenido, Long idPerfil);

    List<ResponseContenidoDTO> listarPorCategoria(Long idCategoria);

    List<ResponseContenidoDTO> listarPorGenero(Long idGenero);

    List<ResponseContenidoDTO> listarPorEmpleadoResponsable(Long idEmpleadoResponsable);

    ResponseContenidoDTO recomendarPorPerfil(Long idPerfil);

    ResponseContenidoDTO actualizarContenido(Long idContenido, RequestContenidoDTO dto);

    void eliminarContenido(Long idContenido);
}
