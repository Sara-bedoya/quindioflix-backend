package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPagoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePagoDTO;
import co.edu.uniquindio.quindioflixbackend.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<ResponsePagoDTO> crear(@RequestBody RequestPagoDTO dto) {
        return ResponseEntity.ok(pagoService.crearPago(dto));
    }

    @GetMapping
    public List<ResponsePagoDTO> listar() {
        return pagoService.listarPagos();
    }

    @GetMapping("/{idPago}")
    public ResponseEntity<ResponsePagoDTO> obtener(@PathVariable Long idPago) {
        return ResponseEntity.ok(pagoService.obtenerPago(idPago));
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<ResponsePagoDTO> listarPorUsuario(@PathVariable Long idUsuario) {
        return pagoService.listarPorUsuario(idUsuario);
    }

    @GetMapping("/plan/{idPlan}")
    public List<ResponsePagoDTO> listarPorPlan(@PathVariable Long idPlan) {
        return pagoService.listarPorPlan(idPlan);
    }

    @GetMapping("/estado/{estadoPago}")
    public List<ResponsePagoDTO> listarPorEstado(@PathVariable String estadoPago) {
        return pagoService.listarPorEstado(estadoPago);
    }

    @PutMapping("/{idPago}")
    public ResponseEntity<ResponsePagoDTO> actualizar(@PathVariable Long idPago, @RequestBody RequestPagoDTO dto) {
        return ResponseEntity.ok(pagoService.actualizarPago(idPago, dto));
    }

    @DeleteMapping("/{idPago}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idPago) {
        pagoService.eliminarPago(idPago);
        return ResponseEntity.noContent().build();
    }
}
