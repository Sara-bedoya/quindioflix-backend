package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.UsuarioMapper;
import co.edu.uniquindio.quindioflixbackend.model.Usuario;
import co.edu.uniquindio.quindioflixbackend.repository.UsuarioRepository;
import co.edu.uniquindio.quindioflixbackend.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public ResponseUsuarioDTO crearUsuario(RequestUsuarioDTO dto) {

        Usuario usuario = usuarioMapper.toEntity(dto);

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
}