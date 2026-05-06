package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestGeneroDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseGeneroDTO;
import co.edu.uniquindio.quindioflixbackend.service.GeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    public ResponseEntity<ResponseGeneroDTO> crear(@RequestBody RequestGeneroDTO dto) {
        return ResponseEntity.ok(generoService.crearGenero(dto));
    }

    @GetMapping
    public List<ResponseGeneroDTO> listar() {
        return generoService.listarGeneros();
    }
}