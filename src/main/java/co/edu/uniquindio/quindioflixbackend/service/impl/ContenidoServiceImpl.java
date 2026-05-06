package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.ContenidoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Contenido;
import co.edu.uniquindio.quindioflixbackend.model.Genero;
import co.edu.uniquindio.quindioflixbackend.repository.ContenidoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.GeneroRepository;
import co.edu.uniquindio.quindioflixbackend.service.ContenidoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContenidoServiceImpl implements ContenidoService {

    private final ContenidoRepository contenidoRepository;
    private final GeneroRepository generoRepository;
    private final ContenidoMapper contenidoMapper;

    public ContenidoServiceImpl(ContenidoRepository contenidoRepository,
                                GeneroRepository generoRepository,
                                ContenidoMapper contenidoMapper) {
        this.contenidoRepository = contenidoRepository;
        this.generoRepository = generoRepository;
        this.contenidoMapper = contenidoMapper;
    }

    @Override
    public ResponseContenidoDTO crearContenido(RequestContenidoDTO dto) {
        Contenido contenido = contenidoMapper.toEntity(dto);
        contenido.setGeneros(obtenerGeneros(dto.getIdsGeneros()));

        contenido = contenidoRepository.save(contenido);
        return contenidoMapper.toDTO(contenido);
    }

    @Override
    public ResponseContenidoDTO obtenerContenido(Long idContenido) {
        return contenidoMapper.toDTO(buscarContenido(idContenido));
    }

    @Override
    public List<ResponseContenidoDTO> listarContenidos() {
        return convertirLista(contenidoRepository.findAll());
    }

    @Override
    public List<ResponseContenidoDTO> listarPorCategoria(Long idCategoria) {
        return convertirLista(contenidoRepository.findByIdCategoria(idCategoria));
    }

    @Override
    public List<ResponseContenidoDTO> listarPorGenero(Long idGenero) {
        return convertirLista(contenidoRepository.findByGenerosIdGenero(idGenero));
    }

    @Override
    public ResponseContenidoDTO actualizarContenido(Long idContenido, RequestContenidoDTO dto) {
        Contenido contenido = buscarContenido(idContenido);

        contenido.setTitulo(dto.getTitulo());
        contenido.setAnioLanzamiento(dto.getAnioLanzamiento());
        contenido.setDuracionMinutos(dto.getDuracionMinutos());
        contenido.setSinopsis(dto.getSinopsis());
        contenido.setClasificacionEdad(dto.getClasificacionEdad());
        contenido.setIdCategoria(dto.getIdCategoria());
        contenido.setEsOriginal(dto.getEsOriginal());
        contenido.setGeneros(obtenerGeneros(dto.getIdsGeneros()));

        contenido = contenidoRepository.save(contenido);
        return contenidoMapper.toDTO(contenido);
    }

    @Override
    public void eliminarContenido(Long idContenido) {
        Contenido contenido = buscarContenido(idContenido);
        contenidoRepository.delete(contenido);
    }

    private Contenido buscarContenido(Long idContenido) {
        return contenidoRepository.findById(idContenido)
                .orElseThrow(() -> new RuntimeException("No existe contenido con id " + idContenido));
    }

    private List<Genero> obtenerGeneros(List<Long> idsGeneros) {
        if (idsGeneros == null || idsGeneros.isEmpty()) {
            return new ArrayList<>();
        }

        return idsGeneros.stream()
                .map(idGenero -> generoRepository.findById(idGenero)
                        .orElseThrow(() -> new RuntimeException("No existe genero con id " + idGenero)))
                .collect(Collectors.toList());
    }

    private List<ResponseContenidoDTO> convertirLista(List<Contenido> contenidos) {
        return contenidos.stream()
                .map(contenidoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
