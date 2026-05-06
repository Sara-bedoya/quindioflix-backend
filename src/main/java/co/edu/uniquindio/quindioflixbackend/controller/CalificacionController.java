package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCalificacionDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCalificacionDTO;
import co.edu.uniquindio.quindioflixbackend.service.CalificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    private final CalificacionService calificacionService;

    public CalificacionController(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @PostMapping
    public ResponseEntity<ResponseCalificacionDTO> crear(@RequestBody RequestCalificacionDTO dto) {
        return ResponseEntity.ok(calificacionService.crearCalificacion(dto));
    }

    @GetMapping
    public List<ResponseCalificacionDTO> listar() {
        return calificacionService.listarCalificaciones();
    }

    @GetMapping("/{idCalificacion}")
    public ResponseEntity<ResponseCalificacionDTO> obtener(@PathVariable Long idCalificacion) {
        return ResponseEntity.ok(calificacionService.obtenerCalificacion(idCalificacion));
    }

    @GetMapping("/perfil/{idPerfil}")
    public List<ResponseCalificacionDTO> listarPorPerfil(@PathVariable Long idPerfil) {
        return calificacionService.listarPorPerfil(idPerfil);
    }

    @GetMapping("/contenido/{idContenido}")
    public List<ResponseCalificacionDTO> listarPorContenido(@PathVariable Long idContenido) {
        return calificacionService.listarPorContenido(idContenido);
    }

    @PutMapping("/{idCalificacion}")
    public ResponseEntity<ResponseCalificacionDTO> actualizar(@PathVariable Long idCalificacion,
                                                              @RequestBody RequestCalificacionDTO dto) {
        return ResponseEntity.ok(calificacionService.actualizarCalificacion(idCalificacion, dto));
    }

    @DeleteMapping("/{idCalificacion}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idCalificacion) {
        calificacionService.eliminarCalificacion(idCalificacion);
        return ResponseEntity.noContent().build();
    }
}
