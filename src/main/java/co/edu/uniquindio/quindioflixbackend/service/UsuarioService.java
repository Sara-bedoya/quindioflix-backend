package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.request.RequestRegistroCompletoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseRegistroCompletoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseUsuarioDTO;

import java.util.List;

public interface UsuarioService {

    ResponseUsuarioDTO crearUsuario(RequestUsuarioDTO dto);

    ResponseRegistroCompletoDTO registrarUsuarioCompleto(RequestRegistroCompletoDTO dto);

    List<ResponseUsuarioDTO> listar();

    void eliminarUsuario(Long idUsuario);
}
