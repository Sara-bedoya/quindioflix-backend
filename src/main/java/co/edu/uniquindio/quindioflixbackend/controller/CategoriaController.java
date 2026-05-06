package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCategoriaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCategoriaDTO;
import co.edu.uniquindio.quindioflixbackend.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<ResponseCategoriaDTO> crear(@RequestBody RequestCategoriaDTO dto) {
        return ResponseEntity.ok(categoriaService.crearCategoria(dto));
    }

    @GetMapping
    public List<ResponseCategoriaDTO> listar() {
        return categoriaService.listarCategorias();
    }
}
