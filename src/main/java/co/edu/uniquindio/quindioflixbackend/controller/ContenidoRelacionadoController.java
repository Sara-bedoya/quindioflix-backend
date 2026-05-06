package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestContenidoRelacionadoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoRelacionadoDTO;
import co.edu.uniquindio.quindioflixbackend.service.ContenidoRelacionadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenidos-relacionados")
public class ContenidoRelacionadoController {

    private final ContenidoRelacionadoService contenidoRelacionadoService;

    public ContenidoRelacionadoController(ContenidoRelacionadoService contenidoRelacionadoService) {
        this.contenidoRelacionadoService = contenidoRelacionadoService;
    }

    @PostMapping
    public ResponseEntity<ResponseContenidoRelacionadoDTO> crear(@RequestBody RequestContenidoRelacionadoDTO dto) {
        return ResponseEntity.ok(contenidoRelacionadoService.crearRelacion(dto));
    }

    @GetMapping
    public List<ResponseContenidoRelacionadoDTO> listar() {
        return contenidoRelacionadoService.listarRelaciones();
    }

    @GetMapping("/origen/{idContenidoOrigen}")
    public List<ResponseContenidoRelacionadoDTO> listarPorOrigen(@PathVariable Long idContenidoOrigen) {
        return contenidoRelacionadoService.listarPorContenidoOrigen(idContenidoOrigen);
    }

    @GetMapping("/destino/{idContenidoDestino}")
    public List<ResponseContenidoRelacionadoDTO> listarPorDestino(@PathVariable Long idContenidoDestino) {
        return contenidoRelacionadoService.listarPorContenidoDestino(idContenidoDestino);
    }

    @DeleteMapping("/{idContenidoOrigen}/{idContenidoDestino}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idContenidoOrigen,
                                         @PathVariable Long idContenidoDestino) {
        contenidoRelacionadoService.eliminarRelacion(idContenidoOrigen, idContenidoDestino);
        return ResponseEntity.noContent().build();
    }
}
