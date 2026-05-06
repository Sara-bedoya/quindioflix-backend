package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPlanDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePlanDTO;
import co.edu.uniquindio.quindioflixbackend.service.PlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<ResponsePlanDTO> crear(@RequestBody RequestPlanDTO dto) {
        return ResponseEntity.ok(planService.crearPlan(dto));
    }

    @GetMapping
    public List<ResponsePlanDTO> listar() {
        return planService.listarPlanes();
    }

    @GetMapping("/{idPlan}")
    public ResponseEntity<ResponsePlanDTO> obtener(@PathVariable Long idPlan) {
        return ResponseEntity.ok(planService.obtenerPlan(idPlan));
    }

    @PutMapping("/{idPlan}")
    public ResponseEntity<ResponsePlanDTO> actualizar(@PathVariable Long idPlan, @RequestBody RequestPlanDTO dto) {
        return ResponseEntity.ok(planService.actualizarPlan(idPlan, dto));
    }

    @DeleteMapping("/{idPlan}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idPlan) {
        planService.eliminarPlan(idPlan);
        return ResponseEntity.noContent().build();
    }
}
