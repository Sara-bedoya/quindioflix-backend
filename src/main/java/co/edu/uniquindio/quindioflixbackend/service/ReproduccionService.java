package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReproduccionDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReproduccionDTO;

import java.util.List;

public interface ReproduccionService {

    ResponseReproduccionDTO crearReproduccion(RequestReproduccionDTO dto);

    ResponseReproduccionDTO obtenerReproduccion(Long idReproduccion);

    List<ResponseReproduccionDTO> listarReproducciones();

    List<ResponseReproduccionDTO> listarPorPerfil(Long idPerfil);

    List<ResponseReproduccionDTO> listarPorContenido(Long idContenido);

    List<ResponseReproduccionDTO> listarPorPerfilYContenido(Long idPerfil, Long idContenido);

    ResponseReproduccionDTO actualizarReproduccion(Long idReproduccion, RequestReproduccionDTO dto);

    void eliminarReproduccion(Long idReproduccion);
}
