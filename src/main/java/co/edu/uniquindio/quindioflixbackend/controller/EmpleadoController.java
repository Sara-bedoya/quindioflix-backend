package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public ResponseEntity<ResponseEmpleadoDTO> crear(@RequestBody RequestEmpleadoDTO dto) {
        return ResponseEntity.ok(empleadoService.crearEmpleado(dto));
    }

    @GetMapping
    public List<ResponseEmpleadoDTO> listar() {
        return empleadoService.listarEmpleados();
    }

    @GetMapping("/{idEmpleado}")
    public ResponseEntity<ResponseEmpleadoDTO> obtener(@PathVariable Long idEmpleado) {
        return ResponseEntity.ok(empleadoService.obtenerEmpleado(idEmpleado));
    }

    @GetMapping("/departamento/{idDepartamento}")
    public List<ResponseEmpleadoDTO> listarPorDepartamento(@PathVariable Long idDepartamento) {
        return empleadoService.listarPorDepartamento(idDepartamento);
    }

    @GetMapping("/supervisor/{idSupervisor}")
    public List<ResponseEmpleadoDTO> listarPorSupervisor(@PathVariable Long idSupervisor) {
        return empleadoService.listarPorSupervisor(idSupervisor);
    }

    @PutMapping("/{idEmpleado}")
    public ResponseEntity<ResponseEmpleadoDTO> actualizar(@PathVariable Long idEmpleado,
                                                          @RequestBody RequestEmpleadoDTO dto) {
        return ResponseEntity.ok(empleadoService.actualizarEmpleado(idEmpleado, dto));
    }

    @DeleteMapping("/{idEmpleado}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idEmpleado) {
        empleadoService.eliminarEmpleado(idEmpleado);
        return ResponseEntity.noContent().build();
    }
}
