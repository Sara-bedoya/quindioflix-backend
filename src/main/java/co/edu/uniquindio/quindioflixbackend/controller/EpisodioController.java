package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEpisodioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEpisodioDTO;
import co.edu.uniquindio.quindioflixbackend.service.EpisodioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episodios")
public class EpisodioController {

    private final EpisodioService episodioService;

    public EpisodioController(EpisodioService episodioService) {
        this.episodioService = episodioService;
    }

    @PostMapping
    public ResponseEntity<ResponseEpisodioDTO> crear(@RequestBody RequestEpisodioDTO dto) {
        return ResponseEntity.ok(episodioService.crearEpisodio(dto));
    }

    @GetMapping
    public List<ResponseEpisodioDTO> listar() {
        return episodioService.listarEpisodios();
    }

    @GetMapping("/{idEpisodio}")
    public ResponseEntity<ResponseEpisodioDTO> obtener(@PathVariable Long idEpisodio) {
        return ResponseEntity.ok(episodioService.obtenerEpisodio(idEpisodio));
    }

    @GetMapping("/temporada/{idTemporada}")
    public List<ResponseEpisodioDTO> listarPorTemporada(@PathVariable Long idTemporada) {
        return episodioService.listarPorTemporada(idTemporada);
    }

    @PutMapping("/{idEpisodio}")
    public ResponseEntity<ResponseEpisodioDTO> actualizar(@PathVariable Long idEpisodio,
                                                          @RequestBody RequestEpisodioDTO dto) {
        return ResponseEntity.ok(episodioService.actualizarEpisodio(idEpisodio, dto));
    }

    @DeleteMapping("/{idEpisodio}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idEpisodio) {
        episodioService.eliminarEpisodio(idEpisodio);
        return ResponseEntity.noContent().build();
    }
}
