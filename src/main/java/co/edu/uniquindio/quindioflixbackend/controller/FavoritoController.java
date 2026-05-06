package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestFavoritoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseFavoritoDTO;
import co.edu.uniquindio.quindioflixbackend.service.FavoritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    private final FavoritoService favoritoService;

    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    @PostMapping
    public ResponseEntity<ResponseFavoritoDTO> crear(@RequestBody RequestFavoritoDTO dto) {
        return ResponseEntity.ok(favoritoService.crearFavorito(dto));
    }

    @GetMapping
    public List<ResponseFavoritoDTO> listar() {
        return favoritoService.listarFavoritos();
    }

    @GetMapping("/{idFavorito}")
    public ResponseEntity<ResponseFavoritoDTO> obtener(@PathVariable Long idFavorito) {
        return ResponseEntity.ok(favoritoService.obtenerFavorito(idFavorito));
    }

    @GetMapping("/perfil/{idPerfil}")
    public List<ResponseFavoritoDTO> listarPorPerfil(@PathVariable Long idPerfil) {
        return favoritoService.listarPorPerfil(idPerfil);
    }

    @GetMapping("/contenido/{idContenido}")
    public List<ResponseFavoritoDTO> listarPorContenido(@PathVariable Long idContenido) {
        return favoritoService.listarPorContenido(idContenido);
    }

    @DeleteMapping("/{idFavorito}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idFavorito) {
        favoritoService.eliminarFavorito(idFavorito);
        return ResponseEntity.noContent().build();
    }
}
