package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestFavoritoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseFavoritoDTO;

import java.util.List;

public interface FavoritoService {

    ResponseFavoritoDTO crearFavorito(RequestFavoritoDTO dto);

    ResponseFavoritoDTO obtenerFavorito(Long idFavorito);

    List<ResponseFavoritoDTO> listarFavoritos();

    List<ResponseFavoritoDTO> listarPorPerfil(Long idPerfil);

    List<ResponseFavoritoDTO> listarPorContenido(Long idContenido);

    void eliminarFavorito(Long idFavorito);
}
