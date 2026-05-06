package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestTemporadaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseTemporadaDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.TemporadaMapper;
import co.edu.uniquindio.quindioflixbackend.model.Contenido;
import co.edu.uniquindio.quindioflixbackend.model.Temporada;
import co.edu.uniquindio.quindioflixbackend.repository.ContenidoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.TemporadaRepository;
import co.edu.uniquindio.quindioflixbackend.service.TemporadaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemporadaServiceImpl implements TemporadaService {

    private final TemporadaRepository temporadaRepository;
    private final ContenidoRepository contenidoRepository;
    private final TemporadaMapper temporadaMapper;

    public TemporadaServiceImpl(TemporadaRepository temporadaRepository,
                                ContenidoRepository contenidoRepository,
                                TemporadaMapper temporadaMapper) {
        this.temporadaRepository = temporadaRepository;
        this.contenidoRepository = contenidoRepository;
        this.temporadaMapper = temporadaMapper;
    }

    @Override
    public ResponseTemporadaDTO crearTemporada(RequestTemporadaDTO dto) {
        Temporada temporada = temporadaMapper.toEntity(dto);
        temporada.setContenido(buscarContenido(dto.getIdContenido()));

        temporada = temporadaRepository.save(temporada);
        return temporadaMapper.toDTO(temporada);
    }

    @Override
    public ResponseTemporadaDTO obtenerTemporada(Long idTemporada) {
        return temporadaMapper.toDTO(buscarTemporada(idTemporada));
    }

    @Override
    public List<ResponseTemporadaDTO> listarTemporadas() {
        return convertirLista(temporadaRepository.findAll());
    }

    @Override
    public List<ResponseTemporadaDTO> listarPorContenido(Long idContenido) {
        return convertirLista(temporadaRepository.findByContenidoIdContenido(idContenido));
    }

    @Override
    public ResponseTemporadaDTO actualizarTemporada(Long idTemporada, RequestTemporadaDTO dto) {
        Temporada temporada = buscarTemporada(idTemporada);

        temporada.setContenido(buscarContenido(dto.getIdContenido()));
        temporada.setNumeroTemporada(dto.getNumeroTemporada());
        temporada.setTituloTemporada(dto.getTituloTemporada());

        temporada = temporadaRepository.save(temporada);
        return temporadaMapper.toDTO(temporada);
    }

    @Override
    public void eliminarTemporada(Long idTemporada) {
        temporadaRepository.delete(buscarTemporada(idTemporada));
    }

    private Temporada buscarTemporada(Long idTemporada) {
        return temporadaRepository.findById(idTemporada)
                .orElseThrow(() -> new RuntimeException("No existe temporada con id " + idTemporada));
    }

    private Contenido buscarContenido(Long idContenido) {
        return contenidoRepository.findById(idContenido)
                .orElseThrow(() -> new RuntimeException("No existe contenido con id " + idContenido));
    }

    private List<ResponseTemporadaDTO> convertirLista(List<Temporada> temporadas) {
        return temporadas.stream()
                .map(temporadaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
