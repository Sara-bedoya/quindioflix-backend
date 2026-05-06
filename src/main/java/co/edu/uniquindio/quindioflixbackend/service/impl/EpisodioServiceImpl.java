package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEpisodioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEpisodioDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.EpisodioMapper;
import co.edu.uniquindio.quindioflixbackend.model.Episodio;
import co.edu.uniquindio.quindioflixbackend.model.Temporada;
import co.edu.uniquindio.quindioflixbackend.repository.EpisodioRepository;
import co.edu.uniquindio.quindioflixbackend.repository.TemporadaRepository;
import co.edu.uniquindio.quindioflixbackend.service.EpisodioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodioServiceImpl implements EpisodioService {

    private final EpisodioRepository episodioRepository;
    private final TemporadaRepository temporadaRepository;
    private final EpisodioMapper episodioMapper;

    public EpisodioServiceImpl(EpisodioRepository episodioRepository,
                               TemporadaRepository temporadaRepository,
                               EpisodioMapper episodioMapper) {
        this.episodioRepository = episodioRepository;
        this.temporadaRepository = temporadaRepository;
        this.episodioMapper = episodioMapper;
    }

    @Override
    public ResponseEpisodioDTO crearEpisodio(RequestEpisodioDTO dto) {
        Episodio episodio = episodioMapper.toEntity(dto);
        episodio.setTemporada(buscarTemporada(dto.getIdTemporada()));

        episodio = episodioRepository.save(episodio);
        return episodioMapper.toDTO(episodio);
    }

    @Override
    public ResponseEpisodioDTO obtenerEpisodio(Long idEpisodio) {
        return episodioMapper.toDTO(buscarEpisodio(idEpisodio));
    }

    @Override
    public List<ResponseEpisodioDTO> listarEpisodios() {
        return convertirLista(episodioRepository.findAll());
    }

    @Override
    public List<ResponseEpisodioDTO> listarPorTemporada(Long idTemporada) {
        return convertirLista(episodioRepository.findByTemporadaIdTemporada(idTemporada));
    }

    @Override
    public ResponseEpisodioDTO actualizarEpisodio(Long idEpisodio, RequestEpisodioDTO dto) {
        Episodio episodio = buscarEpisodio(idEpisodio);

        episodio.setTemporada(buscarTemporada(dto.getIdTemporada()));
        episodio.setNumeroEpisodio(dto.getNumeroEpisodio());
        episodio.setTituloEpisodio(dto.getTituloEpisodio());
        episodio.setDuracionMinutos(dto.getDuracionMinutos());
        episodio.setSinopsis(dto.getSinopsis());

        episodio = episodioRepository.save(episodio);
        return episodioMapper.toDTO(episodio);
    }

    @Override
    public void eliminarEpisodio(Long idEpisodio) {
        episodioRepository.delete(buscarEpisodio(idEpisodio));
    }

    private Episodio buscarEpisodio(Long idEpisodio) {
        return episodioRepository.findById(idEpisodio)
                .orElseThrow(() -> new RuntimeException("No existe episodio con id " + idEpisodio));
    }

    private Temporada buscarTemporada(Long idTemporada) {
        return temporadaRepository.findById(idTemporada)
                .orElseThrow(() -> new RuntimeException("No existe temporada con id " + idTemporada));
    }

    private List<ResponseEpisodioDTO> convertirLista(List<Episodio> episodios) {
        return episodios.stream()
                .map(episodioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
