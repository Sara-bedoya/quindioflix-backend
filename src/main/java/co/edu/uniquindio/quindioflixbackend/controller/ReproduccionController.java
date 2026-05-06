package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReproduccionDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReproduccionDTO;
import co.edu.uniquindio.quindioflixbackend.service.ReproduccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reproducciones")
public class ReproduccionController {

    private final ReproduccionService reproduccionService;

    public ReproduccionController(ReproduccionService reproduccionService) {
        this.reproduccionService = reproduccionService;
    }

    @PostMapping
    public ResponseEntity<ResponseReproduccionDTO> crear(@RequestBody RequestReproduccionDTO dto) {
        return ResponseEntity.ok(reproduccionService.crearReproduccion(dto));
    }

    @GetMapping
    public List<ResponseReproduccionDTO> listar() {
        return reproduccionService.listarReproducciones();
    }

    @GetMapping("/{idReproduccion}")
    public ResponseEntity<ResponseReproduccionDTO> obtener(@PathVariable Long idReproduccion) {
        return ResponseEntity.ok(reproduccionService.obtenerReproduccion(idReproduccion));
    }

    @GetMapping("/perfil/{idPerfil}")
    public List<ResponseReproduccionDTO> listarPorPerfil(@PathVariable Long idPerfil) {
        return reproduccionService.listarPorPerfil(idPerfil);
    }

    @GetMapping("/contenido/{idContenido}")
    public List<ResponseReproduccionDTO> listarPorContenido(@PathVariable Long idContenido) {
        return reproduccionService.listarPorContenido(idContenido);
    }

    @GetMapping("/perfil/{idPerfil}/contenido/{idContenido}")
    public List<ResponseReproduccionDTO> listarPorPerfilYContenido(@PathVariable Long idPerfil,
                                                                   @PathVariable Long idContenido) {
        return reproduccionService.listarPorPerfilYContenido(idPerfil, idContenido);
    }

    @PutMapping("/{idReproduccion}")
    public ResponseEntity<ResponseReproduccionDTO> actualizar(@PathVariable Long idReproduccion,
                                                              @RequestBody RequestReproduccionDTO dto) {
        return ResponseEntity.ok(reproduccionService.actualizarReproduccion(idReproduccion, dto));
    }

    @DeleteMapping("/{idReproduccion}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idReproduccion) {
        reproduccionService.eliminarReproduccion(idReproduccion);
        return ResponseEntity.noContent().build();
    }
}
