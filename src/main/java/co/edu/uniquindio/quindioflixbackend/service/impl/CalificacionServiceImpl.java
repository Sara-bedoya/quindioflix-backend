package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCalificacionDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCalificacionDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.CalificacionMapper;
import co.edu.uniquindio.quindioflixbackend.model.Calificacion;
import co.edu.uniquindio.quindioflixbackend.model.Reproduccion;
import co.edu.uniquindio.quindioflixbackend.repository.CalificacionRepository;
import co.edu.uniquindio.quindioflixbackend.repository.ReproduccionRepository;
import co.edu.uniquindio.quindioflixbackend.service.CalificacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    private final CalificacionRepository calificacionRepository;
    private final CalificacionMapper calificacionMapper;
    private final ReproduccionRepository reproduccionRepository;

    public CalificacionServiceImpl(CalificacionRepository calificacionRepository,
                                   CalificacionMapper calificacionMapper, ReproduccionRepository reproduccionRepository) {
        this.calificacionRepository = calificacionRepository;
        this.calificacionMapper = calificacionMapper;
        this.reproduccionRepository = reproduccionRepository;
    }
    @Override
    public ResponseCalificacionDTO crearCalificacion(RequestCalificacionDTO dto) {

        List<Reproduccion> reproducciones =
                reproduccionRepository
                        .findByIdPerfilAndIdContenidoOrderByFechaInicioDesc(
                                dto.getIdPerfil(),
                                dto.getIdContenido()
                        );

        if (reproducciones.isEmpty()) {
            throw new RuntimeException(
                    "El perfil no ha reproducido este contenido"
            );
        }

        Reproduccion reproduccion = reproducciones.get(0);

        if (reproduccion.getPorcentajeVisto().doubleValue() < 50) {

            throw new RuntimeException(
                    "Debe ver al menos el 50% del contenido para calificar"
            );
        }

        Calificacion calificacion =
                calificacionMapper.toEntity(dto);


        calificacion =
                calificacionRepository.save(calificacion);

        return calificacionMapper.toDTO(calificacion);
    }

    @Override
    public ResponseCalificacionDTO obtenerCalificacion(Long idCalificacion) {
        return calificacionMapper.toDTO(buscarCalificacion(idCalificacion));
    }

    @Override
    public List<ResponseCalificacionDTO> listarCalificaciones() {
        return convertirLista(calificacionRepository.findAll());
    }

    @Override
    public List<ResponseCalificacionDTO> listarPorPerfil(Long idPerfil) {
        return convertirLista(calificacionRepository.findByIdPerfil(idPerfil));
    }

    @Override
    public List<ResponseCalificacionDTO> listarPorContenido(Long idContenido) {
        return convertirLista(calificacionRepository.findByIdContenido(idContenido));
    }

    @Override
    public ResponseCalificacionDTO actualizarCalificacion(Long idCalificacion, RequestCalificacionDTO dto) {
        Calificacion calificacion = buscarCalificacion(idCalificacion);
        calificacion.setIdPerfil(dto.getIdPerfil());
        calificacion.setIdContenido(dto.getIdContenido());
        calificacion.setEstrellas(dto.getEstrellas());
        calificacion.setComentario(dto.getComentario());
        return calificacionMapper.toDTO(calificacionRepository.save(calificacion));
    }

    @Override
    public void eliminarCalificacion(Long idCalificacion) {
        calificacionRepository.delete(buscarCalificacion(idCalificacion));
    }

    private Calificacion buscarCalificacion(Long idCalificacion) {
        return calificacionRepository.findById(idCalificacion)
                .orElseThrow(() -> new RuntimeException("No existe calificacion con id " + idCalificacion));
    }

    private List<ResponseCalificacionDTO> convertirLista(List<Calificacion> calificaciones) {
        return calificaciones.stream().map(calificacionMapper::toDTO).collect(Collectors.toList());
    }
}
