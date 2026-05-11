package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCambioPlanDTO;
import co.edu.uniquindio.quindioflixbackend.dto.request.RequestRegistroCompletoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.request.RequestUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePagoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePerfilDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseRegistroCompletoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.PagoMapper;
import co.edu.uniquindio.quindioflixbackend.mapper.PerfilMapper;
import co.edu.uniquindio.quindioflixbackend.mapper.UsuarioMapper;
import co.edu.uniquindio.quindioflixbackend.model.Pago;
import co.edu.uniquindio.quindioflixbackend.model.Perfil;
import co.edu.uniquindio.quindioflixbackend.model.Plan;
import co.edu.uniquindio.quindioflixbackend.model.Usuario;
import co.edu.uniquindio.quindioflixbackend.repository.CiudadRepository;
import co.edu.uniquindio.quindioflixbackend.repository.EstadoCuentaRepository;
import co.edu.uniquindio.quindioflixbackend.repository.PagoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.PerfilRepository;
import co.edu.uniquindio.quindioflixbackend.repository.PlanRepository;
import co.edu.uniquindio.quindioflixbackend.repository.UsuarioRepository;
import co.edu.uniquindio.quindioflixbackend.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PerfilRepository perfilRepository;
    private final PerfilMapper perfilMapper;
    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;
    private final PlanRepository planRepository;
    private final CiudadRepository ciudadRepository;
    private final EstadoCuentaRepository estadoCuentaRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              UsuarioMapper usuarioMapper,
                              PerfilRepository perfilRepository,
                              PerfilMapper perfilMapper,
                              PagoRepository pagoRepository,
                              PagoMapper pagoMapper,
                              PlanRepository planRepository,
                              CiudadRepository ciudadRepository,
                              EstadoCuentaRepository estadoCuentaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.perfilRepository = perfilRepository;
        this.perfilMapper = perfilMapper;
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
        this.planRepository = planRepository;
        this.ciudadRepository = ciudadRepository;
        this.estadoCuentaRepository = estadoCuentaRepository;
    }

    @Override
    public ResponseUsuarioDTO crearUsuario(RequestUsuarioDTO dto) {

        Usuario usuario = usuarioMapper.toEntity(dto);

        usuario = usuarioRepository.save(usuario);

        return usuarioMapper.toDTO(usuario);
    }

    @Override
    @Transactional
    public ResponseRegistroCompletoDTO registrarUsuarioCompleto(RequestRegistroCompletoDTO dto) {
        validarRegistroCompleto(dto);

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setIdCiudad(dto.getIdCiudad());
        usuario.setIdPlan(dto.getIdPlan());
        usuario.setIdEstado(dto.getIdEstado());
        usuario.setEsModerador("N");

        usuario = usuarioRepository.save(usuario);

        Perfil perfil = new Perfil();
        perfil.setUsuario(usuario);
        perfil.setNombrePerfil(obtenerValorPorDefecto(dto.getNombrePerfil(), "Principal"));
        perfil.setAvatar(dto.getAvatar());
        perfil.setTipo(obtenerValorPorDefecto(dto.getTipoPerfil(), "ADULTO"));
        perfil = perfilRepository.save(perfil);

        Pago pago = Pago.builder()
                .idUsuario(usuario.getIdUsuario())
                .idPlan(dto.getIdPlan())
                .monto(dto.getMonto())
                .metodoPago(dto.getMetodoPago())
                .estadoPago(dto.getEstadoPago())
                .build();
        pago = pagoRepository.save(pago);

        ResponseUsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuario);
        ResponsePerfilDTO perfilDTO = perfilMapper.toDTO(perfil);
        ResponsePagoDTO pagoDTO = pagoMapper.toDTO(pago);

        return ResponseRegistroCompletoDTO.builder()
                .usuario(usuarioDTO)
                .perfil(perfilDTO)
                .pago(pagoDTO)
                .build();
    }

    @Override
    @Transactional
    public ResponseUsuarioDTO cambiarPlan(Long idUsuario, RequestCambioPlanDTO dto) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("No existe usuario con id " + idUsuario));

        Plan nuevoPlan = planRepository.findById(dto.getIdNuevoPlan())
                .orElseThrow(() -> new RuntimeException("No existe plan con id " + dto.getIdNuevoPlan()));

        long perfilesActuales = perfilRepository.countByUsuarioIdUsuario(idUsuario);
        if (nuevoPlan.getMaxPerfiles() != null && perfilesActuales > nuevoPlan.getMaxPerfiles()) {
            throw new RuntimeException("El usuario tiene " + perfilesActuales
                    + " perfiles y el nuevo plan solo permite " + nuevoPlan.getMaxPerfiles());
        }

        usuario.setIdPlan(nuevoPlan.getIdPlan());
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public List<ResponseUsuarioDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("No existe usuario con id " + idUsuario));
        usuarioRepository.delete(usuario);
    }

    private void validarRegistroCompleto(RequestRegistroCompletoDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Ya existe un usuario con el email " + dto.getEmail());
        }

        planRepository.findById(dto.getIdPlan())
                .orElseThrow(() -> new RuntimeException("No existe plan con id " + dto.getIdPlan()));

        ciudadRepository.findById(dto.getIdCiudad())
                .orElseThrow(() -> new RuntimeException("No existe ciudad con id " + dto.getIdCiudad()));

        estadoCuentaRepository.findById(dto.getIdEstado())
                .orElseThrow(() -> new RuntimeException("No existe estado de cuenta con id " + dto.getIdEstado()));

        if (dto.getMonto() == null) {
            throw new RuntimeException("El monto del primer pago es obligatorio");
        }

        if (dto.getMetodoPago() == null || dto.getMetodoPago().isBlank()) {
            throw new RuntimeException("El metodo de pago es obligatorio");
        }

        if (dto.getEstadoPago() == null || dto.getEstadoPago().isBlank()) {
            throw new RuntimeException("El estado del pago es obligatorio");
        }
    }

    private String obtenerValorPorDefecto(String valor, String valorPorDefecto) {
        if (valor == null || valor.isBlank()) {
            return valorPorDefecto;
        }
        return valor;
    }
}
