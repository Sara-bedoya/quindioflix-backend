package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCiudadDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCiudadDTO;
import co.edu.uniquindio.quindioflixbackend.service.CiudadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PostMapping
    public ResponseEntity<ResponseCiudadDTO> crear(@RequestBody RequestCiudadDTO dto) {
        return ResponseEntity.ok(ciudadService.crearCiudad(dto));
    }

    @GetMapping
    public List<ResponseCiudadDTO> listar() {
        return ciudadService.listarCiudades();
    }

    @GetMapping("/{idCiudad}")
    public ResponseEntity<ResponseCiudadDTO> obtener(@PathVariable Long idCiudad) {
        return ResponseEntity.ok(ciudadService.obtenerCiudad(idCiudad));
    }

    @PutMapping("/{idCiudad}")
    public ResponseEntity<ResponseCiudadDTO> actualizar(@PathVariable Long idCiudad,
                                                        @RequestBody RequestCiudadDTO dto) {
        return ResponseEntity.ok(ciudadService.actualizarCiudad(idCiudad, dto));
    }

    @DeleteMapping("/{idCiudad}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idCiudad) {
        ciudadService.eliminarCiudad(idCiudad);
        return ResponseEntity.noContent().build();
    }
}
