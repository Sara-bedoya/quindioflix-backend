package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestTemporadaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseTemporadaDTO;

import java.util.List;

public interface TemporadaService {

    ResponseTemporadaDTO crearTemporada(RequestTemporadaDTO dto);

    ResponseTemporadaDTO obtenerTemporada(Long idTemporada);

    List<ResponseTemporadaDTO> listarTemporadas();

    List<ResponseTemporadaDTO> listarPorContenido(Long idContenido);

    ResponseTemporadaDTO actualizarTemporada(Long idTemporada, RequestTemporadaDTO dto);

    void eliminarTemporada(Long idTemporada);
}
