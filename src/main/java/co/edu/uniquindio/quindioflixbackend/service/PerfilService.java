package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPerfilDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePerfilDTO;

import java.util.List;

public interface PerfilService {

    ResponsePerfilDTO crearPerfil(RequestPerfilDTO dto);

    List<ResponsePerfilDTO> listar();
}