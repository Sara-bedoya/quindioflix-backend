package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestRegistroCompletoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.request.RequestUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseRegistroCompletoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseUsuarioDTO;
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

    @PostMapping("/registro-completo")
    public ResponseEntity<ResponseRegistroCompletoDTO> registrarCompleto(@RequestBody RequestRegistroCompletoDTO dto) {
        return ResponseEntity.ok(usuarioService.registrarUsuarioCompleto(dto));
    }

    @GetMapping
    public List<ResponseUsuarioDTO> listar() {
        return usuarioService.listar();
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
