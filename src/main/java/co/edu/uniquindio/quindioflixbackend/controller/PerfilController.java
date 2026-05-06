package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPerfilDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePerfilDTO;
import co.edu.uniquindio.quindioflixbackend.service.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    private PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @PostMapping
    public ResponseEntity<ResponsePerfilDTO> crear(@RequestBody RequestPerfilDTO perfilDTO) {
        return ResponseEntity.ok(perfilService.crearPerfil(perfilDTO));
    }

    @GetMapping
    public List<ResponsePerfilDTO> listar() {
        return perfilService.listar();
    }

    @DeleteMapping("/{idPerfil}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idPerfil) {
        perfilService.eliminarPerfil(idPerfil);
        return ResponseEntity.noContent().build();
    }
}
