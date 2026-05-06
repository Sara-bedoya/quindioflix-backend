package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReproduccionDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReproduccionDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.ReproduccionMapper;
import co.edu.uniquindio.quindioflixbackend.model.Reproduccion;
import co.edu.uniquindio.quindioflixbackend.repository.ReproduccionRepository;
import co.edu.uniquindio.quindioflixbackend.service.ReproduccionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReproduccionServiceImpl implements ReproduccionService {

    private final ReproduccionRepository reproduccionRepository;
    private final ReproduccionMapper reproduccionMapper;

    public ReproduccionServiceImpl(ReproduccionRepository reproduccionRepository,
                                   ReproduccionMapper reproduccionMapper) {
        this.reproduccionRepository = reproduccionRepository;
        this.reproduccionMapper = reproduccionMapper;
    }

    @Override
    public ResponseReproduccionDTO crearReproduccion(RequestReproduccionDTO dto) {
        Reproduccion reproduccion = reproduccionRepository.save(reproduccionMapper.toEntity(dto));
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
