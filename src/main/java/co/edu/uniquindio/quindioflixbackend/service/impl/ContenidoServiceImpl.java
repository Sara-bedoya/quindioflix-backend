package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.ContenidoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Contenido;
import co.edu.uniquindio.quindioflixbackend.model.Departamento;
import co.edu.uniquindio.quindioflixbackend.model.Empleado;
import co.edu.uniquindio.quindioflixbackend.model.Genero;
import co.edu.uniquindio.quindioflixbackend.model.Perfil;
import co.edu.uniquindio.quindioflixbackend.model.Reproduccion;
import co.edu.uniquindio.quindioflixbackend.repository.ContenidoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.ContenidoRelacionadoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.DepartamentoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.EmpleadoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.EpisodioRepository;
import co.edu.uniquindio.quindioflixbackend.repository.FavoritoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.GeneroRepository;
import co.edu.uniquindio.quindioflixbackend.repository.PerfilRepository;
import co.edu.uniquindio.quindioflixbackend.repository.CalificacionRepository;
import co.edu.uniquindio.quindioflixbackend.repository.ReporteRepository;
import co.edu.uniquindio.quindioflixbackend.repository.ReproduccionRepository;
import co.edu.uniquindio.quindioflixbackend.repository.TemporadaRepository;
import co.edu.uniquindio.quindioflixbackend.service.ContenidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContenidoServiceImpl implements ContenidoService {

    private static final List<String> CLASIFICACIONES_INFANTILES = List.of("TP", "+7", "+13");

    private final ContenidoRepository contenidoRepository;
    private final GeneroRepository generoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;
    private final ReproduccionRepository reproduccionRepository;
    private final PerfilRepository perfilRepository;
    private final TemporadaRepository temporadaRepository;
    private final EpisodioRepository episodioRepository;
    private final ContenidoRelacionadoRepository contenidoRelacionadoRepository;
    private final CalificacionRepository calificacionRepository;
    private final FavoritoRepository favoritoRepository;
    private final ReporteRepository reporteRepository;
    private final ContenidoMapper contenidoMapper;

    public ContenidoServiceImpl(ContenidoRepository contenidoRepository,
                                GeneroRepository generoRepository,
                                EmpleadoRepository empleadoRepository,
                                DepartamentoRepository departamentoRepository,
                                ReproduccionRepository reproduccionRepository,
                                PerfilRepository perfilRepository,
                                TemporadaRepository temporadaRepository,
                                EpisodioRepository episodioRepository,
                                ContenidoRelacionadoRepository contenidoRelacionadoRepository,
                                CalificacionRepository calificacionRepository,
                                FavoritoRepository favoritoRepository,
                                ReporteRepository reporteRepository,
                                ContenidoMapper contenidoMapper) {
        this.contenidoRepository = contenidoRepository;
        this.generoRepository = generoRepository;
        this.empleadoRepository = empleadoRepository;
        this.departamentoRepository = departamentoRepository;
        this.reproduccionRepository = reproduccionRepository;
        this.perfilRepository = perfilRepository;
        this.temporadaRepository = temporadaRepository;
        this.episodioRepository = episodioRepository;
        this.contenidoRelacionadoRepository = contenidoRelacionadoRepository;
        this.calificacionRepository = calificacionRepository;
        this.favoritoRepository = favoritoRepository;
        this.reporteRepository = reporteRepository;
        this.contenidoMapper = contenidoMapper;
    }

    @Override
    public ResponseContenidoDTO crearContenido(RequestContenidoDTO dto) {
        validarEmpleadoResponsableContenido(dto.getIdEmpleadoResponsable());

        Contenido contenido = contenidoMapper.toEntity(dto);
        contenido.setGeneros(obtenerGeneros(dto.getIdsGeneros()));
        contenido.setPopularidad(0);

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
    public List<ResponseContenidoDTO> listarDisponiblesParaPerfil(Long idPerfil) {
        Perfil perfil = buscarPerfil(idPerfil);
        if (esPerfilInfantil(perfil)) {
            return convertirLista(contenidoRepository.findByClasificacionEdadIn(CLASIFICACIONES_INFANTILES));
        }
        return listarContenidos();
    }

    @Override
    public ResponseContenidoDTO obtenerContenidoParaPerfil(Long idContenido, Long idPerfil) {
        Perfil perfil = buscarPerfil(idPerfil);
        Contenido contenido = buscarContenido(idContenido);
        validarContenidoPermitido(perfil, contenido);
        return contenidoMapper.toDTO(contenido);
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
    public List<ResponseContenidoDTO> listarPorEmpleadoResponsable(Long idEmpleadoResponsable) {
        return convertirLista(contenidoRepository.findByIdEmpleadoResponsable(idEmpleadoResponsable));
    }

    @Override
    public ResponseContenidoDTO recomendarPorPerfil(Long idPerfil) {
        Perfil perfil = buscarPerfil(idPerfil);
        List<Reproduccion> reproducciones = reproduccionRepository.findByIdPerfil(idPerfil);
        if (reproducciones.isEmpty()) {
            throw new RuntimeException("El perfil no tiene reproducciones para generar recomendacion");
        }

        Map<Long, Long> reproduccionesPorGenero = new HashMap<>();
        Set<Long> contenidosVistos = new HashSet<>();

        for (Reproduccion reproduccion : reproducciones) {
            contenidoRepository.findById(reproduccion.getIdContenido()).ifPresent(contenido -> {
                contenidosVistos.add(contenido.getIdContenido());
                if (contenido.getGeneros() != null) {
                    contenido.getGeneros().forEach(genero ->
                            reproduccionesPorGenero.merge(genero.getIdGenero(), 1L, Long::sum));
                }
            });
        }

        Long generoPreferido = reproduccionesPorGenero.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("No hay generos suficientes para generar recomendacion"));

        List<Contenido> candidatos = contenidoRepository.findByGenerosIdGenero(generoPreferido);
        Contenido recomendacion = candidatos.stream()
                .filter(contenido -> contenidoPermitido(perfil, contenido))
                .filter(contenido -> !contenidosVistos.contains(contenido.getIdContenido()))
                .max(Comparator.comparingInt(this::popularidad))
                .orElseGet(() -> candidatos.stream()
                        .filter(contenido -> contenidoPermitido(perfil, contenido))
                        .max(Comparator.comparingInt(this::popularidad))
                        .orElseThrow(() -> new RuntimeException("No hay contenidos disponibles para recomendar")));

        return contenidoMapper.toDTO(recomendacion);
    }

    @Override
    public ResponseContenidoDTO actualizarContenido(Long idContenido, RequestContenidoDTO dto) {
        Contenido contenido = buscarContenido(idContenido);
        validarEmpleadoResponsableContenido(dto.getIdEmpleadoResponsable());

        contenido.setTitulo(dto.getTitulo());
        contenido.setAnioLanzamiento(dto.getAnioLanzamiento());
        contenido.setDuracionMinutos(dto.getDuracionMinutos());
        contenido.setSinopsis(dto.getSinopsis());
        contenido.setClasificacionEdad(dto.getClasificacionEdad());
        contenido.setIdCategoria(dto.getIdCategoria());
        contenido.setEsOriginal(dto.getEsOriginal());
        contenido.setIdEmpleadoResponsable(dto.getIdEmpleadoResponsable());
        contenido.setGeneros(obtenerGeneros(dto.getIdsGeneros()));

        contenido = contenidoRepository.save(contenido);
        return contenidoMapper.toDTO(contenido);
    }

    @Override
    @Transactional
    public void eliminarContenido(Long idContenido) {
        Contenido contenido = buscarContenido(idContenido);
        contenidoRelacionadoRepository.deleteAll(contenidoRelacionadoRepository.findByContenidoOrigenIdContenido(idContenido));
        contenidoRelacionadoRepository.deleteAll(contenidoRelacionadoRepository.findByContenidoDestinoIdContenido(idContenido));
        reproduccionRepository.deleteAll(reproduccionRepository.findByIdContenido(idContenido));
        calificacionRepository.deleteAll(calificacionRepository.findByIdContenido(idContenido));
        favoritoRepository.deleteAll(favoritoRepository.findByIdContenido(idContenido));
        reporteRepository.deleteAll(reporteRepository.findByIdContenido(idContenido));
        temporadaRepository.findByContenidoIdContenido(idContenido).forEach(temporada -> {
            episodioRepository.deleteAll(episodioRepository.findByTemporadaIdTemporada(temporada.getIdTemporada()));
            temporadaRepository.delete(temporada);
        });
        contenido.setGeneros(new ArrayList<>());
        contenidoRepository.save(contenido);
        contenidoRepository.delete(contenido);
    }

    private Contenido buscarContenido(Long idContenido) {
        return contenidoRepository.findById(idContenido)
                .orElseThrow(() -> new RuntimeException("No existe contenido con id " + idContenido));
    }

    private Perfil buscarPerfil(Long idPerfil) {
        return perfilRepository.findById(idPerfil)
                .orElseThrow(() -> new RuntimeException("No existe perfil con id " + idPerfil));
    }

    private boolean esPerfilInfantil(Perfil perfil) {
        return "INFANTIL".equalsIgnoreCase(perfil.getTipo());
    }

    private boolean contenidoPermitido(Perfil perfil, Contenido contenido) {
        return !esPerfilInfantil(perfil)
                || CLASIFICACIONES_INFANTILES.stream()
                .anyMatch(clasificacion -> clasificacion.equalsIgnoreCase(contenido.getClasificacionEdad()));
    }

    private void validarContenidoPermitido(Perfil perfil, Contenido contenido) {
        if (!contenidoPermitido(perfil, contenido)) {
            throw new RuntimeException("El perfil infantil solo puede ver contenido con clasificacion TP, +7 o +13");
        }
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

    private int popularidad(Contenido contenido) {
        return contenido.getPopularidad() == null ? 0 : contenido.getPopularidad();
    }

    private void validarEmpleadoResponsableContenido(Long idEmpleadoResponsable) {
        if (idEmpleadoResponsable == null) {
            throw new RuntimeException("El empleado responsable del contenido es obligatorio");
        }

        Empleado empleado = empleadoRepository.findById(idEmpleadoResponsable)
                .orElseThrow(() -> new RuntimeException("No existe empleado responsable con id " + idEmpleadoResponsable));

        Departamento departamentoContenido = departamentoRepository.findByNombreDepartamentoIgnoreCase("Contenido")
                .orElseThrow(() -> new RuntimeException("No existe el departamento Contenido"));

        if (!departamentoContenido.getIdDepartamento().equals(empleado.getIdDepartamento())) {
            throw new RuntimeException("El responsable de contenido debe pertenecer al departamento Contenido");
        }
    }
}
