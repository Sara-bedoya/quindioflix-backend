package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseUsuarioDTO;
import  co.edu.uniquindio.quindioflixbackend.model.Usuario;
import co.edu.uniquindio.quindioflixbackend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<ResponseUsuarioDTO> crear(@RequestBody RequestUsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.crearUsuario(dto));
    }

    @GetMapping
    public List<ResponseUsuarioDTO> listar() {
        return usuarioService.listar();
    }
}