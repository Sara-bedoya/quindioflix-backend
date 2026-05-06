package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseUsuarioDTO;

import java.util.List;

public interface UsuarioService {

    ResponseUsuarioDTO crearUsuario(RequestUsuarioDTO dto);

    List<ResponseUsuarioDTO> listar();

    void eliminarUsuario(Long idUsuario);
}
