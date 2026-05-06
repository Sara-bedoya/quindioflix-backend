package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCiudadDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCiudadDTO;

import java.util.List;

public interface CiudadService {

    ResponseCiudadDTO crearCiudad(RequestCiudadDTO dto);

    ResponseCiudadDTO obtenerCiudad(Long idCiudad);

    List<ResponseCiudadDTO> listarCiudades();

    ResponseCiudadDTO actualizarCiudad(Long idCiudad, RequestCiudadDTO dto);

    void eliminarCiudad(Long idCiudad);
}
