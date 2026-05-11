package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReporteAnaliticoDTO;
import co.edu.uniquindio.quindioflixbackend.service.AnaliticaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analitica")
public class AnaliticaController {

    private final AnaliticaService analiticaService;

    public AnaliticaController(AnaliticaService analiticaService) {
        this.analiticaService = analiticaService;
    }

    @GetMapping("/consumo/ciudad")
    public List<ResponseReporteAnaliticoDTO> consumoPorCiudad() {
        return analiticaService.consumoPorCiudad();
    }

    @GetMapping("/consumo/categoria")
    public List<ResponseReporteAnaliticoDTO> consumoPorCategoria() {
        return analiticaService.consumoPorCategoria();
    }

    @GetMapping("/consumo/genero")
    public List<ResponseReporteAnaliticoDTO> consumoPorGenero() {
        return analiticaService.consumoPorGenero();
    }

    @GetMapping("/consumo/dispositivo")
    public List<ResponseReporteAnaliticoDTO> consumoPorDispositivo() {
        return analiticaService.consumoPorDispositivo();
    }

    @GetMapping("/ingresos/ciudad")
    public List<ResponseReporteAnaliticoDTO> ingresosPorCiudad() {
        return analiticaService.ingresosPorCiudad();
    }

    @GetMapping("/ingresos/plan")
    public List<ResponseReporteAnaliticoDTO> ingresosPorPlan() {
        return analiticaService.ingresosPorPlan();
    }

    @GetMapping("/ranking/contenido")
    public List<ResponseReporteAnaliticoDTO> rankingContenido() {
        return analiticaService.rankingContenido();
    }
}
