package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestDepartamentoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseDepartamentoDTO;
import co.edu.uniquindio.quindioflixbackend.service.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public ResponseEntity<ResponseDepartamentoDTO> crear(@RequestBody RequestDepartamentoDTO dto) {
        return ResponseEntity.ok(departamentoService.crearDepartamento(dto));
    }

    @GetMapping
    public List<ResponseDepartamentoDTO> listar() {
        return departamentoService.listarDepartamentos();
    }

    @GetMapping("/{idDepartamento}")
    public ResponseEntity<ResponseDepartamentoDTO> obtener(@PathVariable Long idDepartamento) {
        return ResponseEntity.ok(departamentoService.obtenerDepartamento(idDepartamento));
    }

    @PutMapping("/{idDepartamento}")
    public ResponseEntity<ResponseDepartamentoDTO> actualizar(@PathVariable Long idDepartamento,
                                                              @RequestBody RequestDepartamentoDTO dto) {
        return ResponseEntity.ok(departamentoService.actualizarDepartamento(idDepartamento, dto));
    }

    @DeleteMapping("/{idDepartamento}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idDepartamento) {
        departamentoService.eliminarDepartamento(idDepartamento);
        return ResponseEntity.noContent().build();
    }
}
