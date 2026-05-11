package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReproduccionDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReproduccionDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.ReproduccionMapper;
import co.edu.uniquindio.quindioflixbackend.model.Contenido;
import co.edu.uniquindio.quindioflixbackend.model.Episodio;
import co.edu.uniquindio.quindioflixbackend.model.Perfil;
import co.edu.uniquindio.quindioflixbackend.model.Reproduccion;
import co.edu.uniquindio.quindioflixbackend.repository.ContenidoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.EpisodioRepository;
import co.edu.uniquindio.quindioflixbackend.repository.PerfilRepository;
import co.edu.uniquindio.quindioflixbackend.repository.ReproduccionRepository;
import co.edu.uniquindio.quindioflixbackend.service.ReproduccionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReproduccionServiceImpl implements ReproduccionService {

    private final PerfilRepository perfilRepository;
    private final ContenidoRepository contenidoRepository;
    private final ReproduccionRepository reproduccionRepository;
    private final ReproduccionMapper reproduccionMapper;
    private final EpisodioRepository episodioRepository;

    public ReproduccionServiceImpl(PerfilRepository perfilRepository, ContenidoRepository contenidoRepository, ReproduccionRepository reproduccionRepository,
                                   ReproduccionMapper reproduccionMapper, EpisodioRepository episodioRepository) {
        this.perfilRepository = perfilRepository;
        this.contenidoRepository = contenidoRepository;
        this.reproduccionRepository = reproduccionRepository;
        this.reproduccionMapper = reproduccionMapper;
        this.episodioRepository = episodioRepository;
    }

    @Override
    public ResponseReproduccionDTO crearReproduccion(RequestReproduccionDTO dto) {
        Perfil perfil = perfilRepository.findById(dto.getIdPerfil())
                .orElseThrow(() ->
                        new RuntimeException("Perfil no encontrado"));
        Contenido contenido = contenidoRepository.findById(dto.getIdContenido())
                .orElseThrow(() ->
                        new RuntimeException("Contenido no encontrado"));
        if (perfil.getTipo().equalsIgnoreCase("INFANTIL")) {
            String clasificacion = contenido.getClasificacionEdad();
            boolean permitido =
                    clasificacion.equals("TP") ||
                            clasificacion.equals("+7") ||
                            clasificacion.equals("+13");
            if (!permitido) {
                throw new RuntimeException(
                        "El perfil infantil no puede reproducir contenido " + clasificacion
                );
            }
        }
        Reproduccion reproduccion = reproduccionMapper.toEntity(dto);
        if (dto.getIdEpisodio() != null) {

            Episodio episodio = episodioRepository
                    .findById(dto.getIdEpisodio())
                    .orElseThrow(() ->
                            new RuntimeException("Episodio no encontrado"));

            reproduccion.setEpisodio(episodio);
        }
        reproduccion = reproduccionRepository.save(reproduccion);
        return reproduccionMapper.toDTO(reproduccion);
    }
    @Override
    public ResponseReproduccionDTO obtenerReproduccion(Long idReproduccion) {
        return reproduccionMapper.toDTO(buscarReproduccion(idReproduccion));
    }

    @Override
    public List<ResponseReproduccionDTO> listarReproducciones() {
        return convertirLista(reproduccionRepository.findAll());
    }

    @Override
    public List<ResponseReproduccionDTO> listarPorPerfil(Long idPerfil) {
        return convertirLista(reproduccionRepository.findByIdPerfil(idPerfil));
    }

    @Override
    public List<ResponseReproduccionDTO> listarPorContenido(Long idContenido) {
        return convertirLista(reproduccionRepository.findByIdContenido(idContenido));
    }

    @Override
    public List<ResponseReproduccionDTO> listarPorPerfilYContenido(Long idPerfil, Long idContenido) {
        return convertirLista(reproduccionRepository.findByIdPerfilAndIdContenido(idPerfil, idContenido));
    }

    @Override
    public ResponseReproduccionDTO actualizarReproduccion(Long idReproduccion, RequestReproduccionDTO dto) {
        Reproduccion reproduccion = buscarReproduccion(idReproduccion);
        reproduccion.setIdPerfil(dto.getIdPerfil());
        reproduccion.setIdContenido(dto.getIdContenido());
        reproduccion.setFechaFin(dto.getFechaFin());
        reproduccion.setPorcentajeVisto(dto.getPorcentajeVisto());
        reproduccion.setDispositivo(dto.getDispositivo());

        if (dto.getIdEpisodio() != null) {
            Episodio episodio = episodioRepository.findById(dto.getIdEpisodio())
                    .orElseThrow(() -> new RuntimeException("Episodio no encontrado"));
            reproduccion.setEpisodio(episodio);
        } else {
            reproduccion.setEpisodio(null);
        }

        return reproduccionMapper.toDTO(reproduccionRepository.save(reproduccion));
    }

    @Override
    public void eliminarReproduccion(Long idReproduccion) {
        reproduccionRepository.delete(buscarReproduccion(idReproduccion));
    }

    private Reproduccion buscarReproduccion(Long idReproduccion) {
        return reproduccionRepository.findById(idReproduccion)
                .orElseThrow(() -> new RuntimeException("No existe reproduccion con id " + idReproduccion));
    }

    private List<ResponseReproduccionDTO> convertirLista(List<Reproduccion> reproducciones) {
        return reproducciones.stream().map(reproduccionMapper::toDTO).collect(Collectors.toList());
    }
}
