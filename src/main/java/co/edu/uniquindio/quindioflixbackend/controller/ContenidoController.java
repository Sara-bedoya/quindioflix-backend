package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.service.ContenidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

    private final ContenidoService contenidoService;

    public ContenidoController(ContenidoService contenidoService) {
        this.contenidoService = contenidoService;
    }

    @PostMapping
    public ResponseEntity<ResponseContenidoDTO> crear(@RequestBody RequestContenidoDTO dto) {
        return ResponseEntity.ok(contenidoService.crearContenido(dto));
    }

    @GetMapping
    public List<ResponseContenidoDTO> listar() {
        return contenidoService.listarContenidos();
    }

    @GetMapping("/{idContenido}")
    public ResponseEntity<ResponseContenidoDTO> obtener(@PathVariable Long idContenido) {
        return ResponseEntity.ok(contenidoService.obtenerContenido(idContenido));
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<ResponseContenidoDTO> listarPorCategoria(@PathVariable Long idCategoria) {
        return contenidoService.listarPorCategoria(idCategoria);
    }

    @GetMapping("/genero/{idGenero}")
    public List<ResponseContenidoDTO> listarPorGenero(@PathVariable Long idGenero) {
        return contenidoService.listarPorGenero(idGenero);
    }

    @PutMapping("/{idContenido}")
    public ResponseEntity<ResponseContenidoDTO> actualizar(@PathVariable Long idContenido,
                                                           @RequestBody RequestContenidoDTO dto) {
        return ResponseEntity.ok(contenidoService.actualizarContenido(idContenido, dto));
    }

    @DeleteMapping("/{idContenido}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idContenido) {
        contenidoService.eliminarContenido(idContenido);
        return ResponseEntity.noContent().build();
    }
}
