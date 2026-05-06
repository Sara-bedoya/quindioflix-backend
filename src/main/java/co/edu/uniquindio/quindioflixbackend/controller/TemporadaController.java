package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestTemporadaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseTemporadaDTO;
import co.edu.uniquindio.quindioflixbackend.service.TemporadaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temporadas")
public class TemporadaController {

    private final TemporadaService temporadaService;

    public TemporadaController(TemporadaService temporadaService) {
        this.temporadaService = temporadaService;
    }

    @PostMapping
    public ResponseEntity<ResponseTemporadaDTO> crear(@RequestBody RequestTemporadaDTO dto) {
        return ResponseEntity.ok(temporadaService.crearTemporada(dto));
    }

    @GetMapping
    public List<ResponseTemporadaDTO> listar() {
        return temporadaService.listarTemporadas();
    }

    @GetMapping("/{idTemporada}")
    public ResponseEntity<ResponseTemporadaDTO> obtener(@PathVariable Long idTemporada) {
        return ResponseEntity.ok(temporadaService.obtenerTemporada(idTemporada));
    }

    @GetMapping("/contenido/{idContenido}")
    public List<ResponseTemporadaDTO> listarPorContenido(@PathVariable Long idContenido) {
        return temporadaService.listarPorContenido(idContenido);
    }

    @PutMapping("/{idTemporada}")
    public ResponseEntity<ResponseTemporadaDTO> actualizar(@PathVariable Long idTemporada,
                                                           @RequestBody RequestTemporadaDTO dto) {
        return ResponseEntity.ok(temporadaService.actualizarTemporada(idTemporada, dto));
    }

    @DeleteMapping("/{idTemporada}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idTemporada) {
        temporadaService.eliminarTemporada(idTemporada);
        return ResponseEntity.noContent().build();
    }
}
