package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReporteDTO;
import co.edu.uniquindio.quindioflixbackend.dto.request.RequestResolverReporteDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReporteDTO;
import co.edu.uniquindio.quindioflixbackend.service.ReporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PostMapping
    public ResponseEntity<ResponseReporteDTO> crear(@RequestBody RequestReporteDTO dto) {
        return ResponseEntity.ok(reporteService.crearReporte(dto));
    }

    @GetMapping
    public List<ResponseReporteDTO> listar() {
        return reporteService.listarReportes();
    }

    @GetMapping("/{idReporte}")
    public ResponseEntity<ResponseReporteDTO> obtener(@PathVariable Long idReporte) {
        return ResponseEntity.ok(reporteService.obtenerReporte(idReporte));
    }

    @GetMapping("/estado/{estado}")
    public List<ResponseReporteDTO> listarPorEstado(@PathVariable String estado) {
        return reporteService.listarPorEstado(estado);
    }

    @GetMapping("/contenido/{idContenido}")
    public List<ResponseReporteDTO> listarPorContenido(@PathVariable Long idContenido) {
        return reporteService.listarPorContenido(idContenido);
    }

    @GetMapping("/moderador/{idModerador}")
    public List<ResponseReporteDTO> listarPorModerador(@PathVariable Long idModerador) {
        return reporteService.listarPorModerador(idModerador);
    }

    @GetMapping("/perfil/{idPerfilReportante}")
    public List<ResponseReporteDTO> listarPorPerfilReportante(@PathVariable Long idPerfilReportante) {
        return reporteService.listarPorPerfilReportante(idPerfilReportante);
    }

    @PutMapping("/{idReporte}/resolver")
    public ResponseEntity<ResponseReporteDTO> resolver(@PathVariable Long idReporte,
                                                       @RequestBody RequestResolverReporteDTO dto) {
        return ResponseEntity.ok(reporteService.resolverReporte(idReporte, dto));
    }

    @DeleteMapping("/{idReporte}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idReporte) {
        reporteService.eliminarReporte(idReporte);
        return ResponseEntity.noContent().build();
    }
}
