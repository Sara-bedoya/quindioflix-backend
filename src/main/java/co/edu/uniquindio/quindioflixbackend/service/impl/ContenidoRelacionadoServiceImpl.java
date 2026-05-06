package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestContenidoRelacionadoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoRelacionadoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.ContenidoRelacionadoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Contenido;
import co.edu.uniquindio.quindioflixbackend.model.ContenidoRelacionado;
import co.edu.uniquindio.quindioflixbackend.model.ContenidoRelacionadoId;
import co.edu.uniquindio.quindioflixbackend.repository.ContenidoRelacionadoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.ContenidoRepository;
import co.edu.uniquindio.quindioflixbackend.service.ContenidoRelacionadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContenidoRelacionadoServiceImpl implements ContenidoRelacionadoService {

    private final ContenidoRelacionadoRepository contenidoRelacionadoRepository;
    private final ContenidoRepository contenidoRepository;
    private final ContenidoRelacionadoMapper contenidoRelacionadoMapper;

    public ContenidoRelacionadoServiceImpl(ContenidoRelacionadoRepository contenidoRelacionadoRepository,
                                           ContenidoRepository contenidoRepository,
                                           ContenidoRelacionadoMapper contenidoRelacionadoMapper) {
        this.contenidoRelacionadoRepository = contenidoRelacionadoRepository;
        this.contenidoRepository = contenidoRepository;
        this.contenidoRelacionadoMapper = contenidoRelacionadoMapper;
    }

    @Override
    public ResponseContenidoRelacionadoDTO crearRelacion(RequestContenidoRelacionadoDTO dto) {
        Contenido contenidoOrigen = buscarContenido(dto.getIdContenidoOrigen());
        Contenido contenidoDestino = buscarContenido(dto.getIdContenidoDestino());
        ContenidoRelacionadoId id = new ContenidoRelacionadoId(
                dto.getIdContenidoOrigen(),
                dto.getIdContenidoDestino()
        );

        ContenidoRelacionado relacion = ContenidoRelacionado.builder()
                .id(id)
                .contenidoOrigen(contenidoOrigen)
                .contenidoDestino(contenidoDestino)
                .tipoRelacion(dto.getTipoRelacion())
                .build();

        relacion = contenidoRelacionadoRepository.save(relacion);
        return contenidoRelacionadoMapper.toDTO(relacion);
    }

    @Override
    public List<ResponseContenidoRelacionadoDTO> listarRelaciones() {
        return convertirLista(contenidoRelacionadoRepository.findAll());
    }

    @Override
    public List<ResponseContenidoRelacionadoDTO> listarPorContenidoOrigen(Long idContenidoOrigen) {
        return convertirLista(contenidoRelacionadoRepository.findByContenidoOrigenIdContenido(idContenidoOrigen));
    }

    @Override
    public List<ResponseContenidoRelacionadoDTO> listarPorContenidoDestino(Long idContenidoDestino) {
        return convertirLista(contenidoRelacionadoRepository.findByContenidoDestinoIdContenido(idContenidoDestino));
    }

    @Override
    public void eliminarRelacion(Long idContenidoOrigen, Long idContenidoDestino) {
        ContenidoRelacionadoId id = new ContenidoRelacionadoId(idContenidoOrigen, idContenidoDestino);
        ContenidoRelacionado relacion = contenidoRelacionadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe relacion entre los contenidos indicados"));

        contenidoRelacionadoRepository.delete(relacion);
    }

    private Contenido buscarContenido(Long idContenido) {
        return contenidoRepository.findById(idContenido)
                .orElseThrow(() -> new RuntimeException("No existe contenido con id " + idContenido));
    }

    private List<ResponseContenidoRelacionadoDTO> convertirLista(List<ContenidoRelacionado> relaciones) {
        return relaciones.stream()
                .map(contenidoRelacionadoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
