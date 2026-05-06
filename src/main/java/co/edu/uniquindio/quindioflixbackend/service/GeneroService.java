package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestGeneroDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseGeneroDTO;

import java.util.List;

public interface GeneroService {

    ResponseGeneroDTO crearGenero(RequestGeneroDTO dto);

    List<ResponseGeneroDTO> listarGeneros();
}