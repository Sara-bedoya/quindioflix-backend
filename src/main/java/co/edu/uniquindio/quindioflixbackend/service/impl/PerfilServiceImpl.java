package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPerfilDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePerfilDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.PerfilMapper;
import co.edu.uniquindio.quindioflixbackend.model.Perfil;
import co.edu.uniquindio.quindioflixbackend.model.Usuario;
import co.edu.uniquindio.quindioflixbackend.repository.PerfilRepository;
import co.edu.uniquindio.quindioflixbackend.repository.UsuarioRepository;
import co.edu.uniquindio.quindioflixbackend.service.PerfilService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;
    private final PerfilMapper perfilMapper;

    public PerfilServiceImpl(PerfilRepository perfilRepository,
                             UsuarioRepository usuarioRepository,
                             PerfilMapper perfilMapper) {
        this.perfilRepository = perfilRepository;
        this.usuarioRepository = usuarioRepository;
        this.perfilMapper = perfilMapper;
    }

    @Override
    public ResponsePerfilDTO crearPerfil(RequestPerfilDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

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
}