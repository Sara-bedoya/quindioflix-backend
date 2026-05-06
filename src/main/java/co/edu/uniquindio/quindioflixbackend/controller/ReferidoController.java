package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReferidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReferidoDTO;
import co.edu.uniquindio.quindioflixbackend.service.ReferidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/referidos")
public class ReferidoController {

    private final ReferidoService referidoService;

    public ReferidoController(ReferidoService referidoService) {
        this.referidoService = referidoService;
    }

    @PostMapping
    public ResponseEntity<ResponseReferidoDTO> crear(@RequestBody RequestReferidoDTO dto) {
        return ResponseEntity.ok(referidoService.crearReferido(dto));
    }

    @GetMapping
    public List<ResponseReferidoDTO> listar() {
        return referidoService.listarReferidos();
    }

    @GetMapping("/{idReferido}")
    public ResponseEntity<ResponseReferidoDTO> obtener(@PathVariable Long idReferido) {
        return ResponseEntity.ok(referidoService.obtenerReferido(idReferido));
    }

    @GetMapping("/referidor/{idUsuarioReferidor}")
    public List<ResponseReferidoDTO> listarPorReferidor(@PathVariable Long idUsuarioReferidor) {
        return referidoService.listarPorReferidor(idUsuarioReferidor);
    }

    @GetMapping("/referido/{idUsuarioReferido}")
    public List<ResponseReferidoDTO> listarPorReferido(@PathVariable Long idUsuarioReferido) {
        return referidoService.listarPorReferido(idUsuarioReferido);
    }

    @PutMapping("/{idReferido}")
    public ResponseEntity<ResponseReferidoDTO> actualizar(@PathVariable Long idReferido,
                                                          @RequestBody RequestReferidoDTO dto) {
        return ResponseEntity.ok(referidoService.actualizarReferido(idReferido, dto));
    }

    @DeleteMapping("/{idReferido}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idReferido) {
        referidoService.eliminarReferido(idReferido);
        return ResponseEntity.noContent().build();
    }
}
