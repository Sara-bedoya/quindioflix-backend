package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCalificacionDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCalificacionDTO;

import java.util.List;

public interface CalificacionService {

    ResponseCalificacionDTO crearCalificacion(RequestCalificacionDTO dto);

    ResponseCalificacionDTO obtenerCalificacion(Long idCalificacion);

    List<ResponseCalificacionDTO> listarCalificaciones();

    List<ResponseCalificacionDTO> listarPorPerfil(Long idPerfil);

    List<ResponseCalificacionDTO> listarPorContenido(Long idContenido);

    ResponseCalificacionDTO actualizarCalificacion(Long idCalificacion, RequestCalificacionDTO dto);

    void eliminarCalificacion(Long idCalificacion);
}
