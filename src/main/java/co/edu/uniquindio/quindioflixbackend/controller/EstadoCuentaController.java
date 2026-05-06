package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEstadoCuentaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEstadoCuentaDTO;
import co.edu.uniquindio.quindioflixbackend.service.EstadoCuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados-cuenta")
public class EstadoCuentaController {

    private final EstadoCuentaService estadoCuentaService;

    public EstadoCuentaController(EstadoCuentaService estadoCuentaService) {
        this.estadoCuentaService = estadoCuentaService;
    }

    @PostMapping
    public ResponseEntity<ResponseEstadoCuentaDTO> crear(@RequestBody RequestEstadoCuentaDTO dto) {
        return ResponseEntity.ok(estadoCuentaService.crearEstadoCuenta(dto));
    }

    @GetMapping
    public List<ResponseEstadoCuentaDTO> listar() {
        return estadoCuentaService.listarEstadosCuenta();
    }

    @GetMapping("/{idEstado}")
    public ResponseEntity<ResponseEstadoCuentaDTO> obtener(@PathVariable Long idEstado) {
        return ResponseEntity.ok(estadoCuentaService.obtenerEstadoCuenta(idEstado));
    }

    @PutMapping("/{idEstado}")
    public ResponseEntity<ResponseEstadoCuentaDTO> actualizar(@PathVariable Long idEstado,
                                                              @RequestBody RequestEstadoCuentaDTO dto) {
        return ResponseEntity.ok(estadoCuentaService.actualizarEstadoCuenta(idEstado, dto));
    }

    @DeleteMapping("/{idEstado}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idEstado) {
        estadoCuentaService.eliminarEstadoCuenta(idEstado);
        return ResponseEntity.noContent().build();
    }
}
