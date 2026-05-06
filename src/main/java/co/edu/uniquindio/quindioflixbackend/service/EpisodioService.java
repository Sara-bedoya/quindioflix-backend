package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEpisodioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEpisodioDTO;

import java.util.List;

public interface EpisodioService {

    ResponseEpisodioDTO crearEpisodio(RequestEpisodioDTO dto);

    ResponseEpisodioDTO obtenerEpisodio(Long idEpisodio);

    List<ResponseEpisodioDTO> listarEpisodios();

    List<ResponseEpisodioDTO> listarPorTemporada(Long idTemporada);

    ResponseEpisodioDTO actualizarEpisodio(Long idEpisodio, RequestEpisodioDTO dto);

    void eliminarEpisodio(Long idEpisodio);
}
