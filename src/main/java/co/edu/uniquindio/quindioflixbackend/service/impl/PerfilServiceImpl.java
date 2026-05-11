package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPerfilDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePerfilDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.PerfilMapper;
import co.edu.uniquindio.quindioflixbackend.model.Perfil;
import co.edu.uniquindio.quindioflixbackend.model.Plan;
import co.edu.uniquindio.quindioflixbackend.model.Usuario;
import co.edu.uniquindio.quindioflixbackend.repository.PerfilRepository;
import co.edu.uniquindio.quindioflixbackend.repository.PlanRepository;
import co.edu.uniquindio.quindioflixbackend.repository.UsuarioRepository;
import co.edu.uniquindio.quindioflixbackend.service.PerfilService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilServiceImpl implements PerfilService {


    private final PerfilRepository perfilRepository;
    private final PlanRepository planRepository;
    private final UsuarioRepository usuarioRepository;
    private final PerfilMapper perfilMapper;

    public PerfilServiceImpl(PerfilRepository perfilRepository, PlanRepository planRepository,
                             UsuarioRepository usuarioRepository,
                             PerfilMapper perfilMapper) {
        this.perfilRepository = perfilRepository;
        this.planRepository = planRepository;
        this.usuarioRepository = usuarioRepository;
        this.perfilMapper = perfilMapper;
    }

    @Override
    public ResponsePerfilDTO crearPerfil(RequestPerfilDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Plan plan = planRepository.findById(usuario.getIdPlan())
                .orElseThrow(() ->
                        new RuntimeException("Plan no encontrado"));

        long perfilesActuales =
                perfilRepository.countByUsuarioIdUsuario(usuario.getIdUsuario());

        if (perfilesActuales >= plan.getMaxPerfiles()) {

            throw new RuntimeException(
                    "El plan " + plan.getNombre()
                            + " solo permite "
                            + plan.getMaxPerfiles()
                            + " perfiles"
            );
        }

        Perfil perfil = perfilMapper.toEntity(dto);
        perfil.setUsuario(usuario);
        perfil = perfilRepository.save(perfil);

        return perfilMapper.toDTO(perfil);
    }

    @Override
    public List<ResponsePerfilDTO> listar() {
        return perfilRepository.findAll()
                .stream()
                .map(perfilMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPerfil(Long idPerfil) {
        Perfil perfil = perfilRepository.findById(idPerfil)
                .orElseThrow(() -> new RuntimeException("No existe perfil con id " + idPerfil));
        perfilRepository.delete(perfil);
    }
}
