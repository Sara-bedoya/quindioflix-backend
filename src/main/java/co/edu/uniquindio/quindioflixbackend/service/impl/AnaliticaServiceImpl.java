package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReporteAnaliticoDTO;
import co.edu.uniquindio.quindioflixbackend.repository.PagoRepository;
import co.edu.uniquindio.quindioflixbackend.service.AnaliticaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnaliticaServiceImpl implements AnaliticaService {

    private final PagoRepository pagoRepository;

    public AnaliticaServiceImpl(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<ResponseReporteAnaliticoDTO> consumoPorCiudad() {
        return mapearConsumo(pagoRepository.reporteConsumoPorCiudad());
    }

    @Override
    public List<ResponseReporteAnaliticoDTO> consumoPorCategoria() {
        return mapearConsumo(pagoRepository.reporteConsumoPorCategoria());
    }

    @Override
    public List<ResponseReporteAnaliticoDTO> consumoPorGenero() {
        return mapearConsumo(pagoRepository.reporteConsumoPorGenero());
    }

    @Override
    public List<ResponseReporteAnaliticoDTO> consumoPorDispositivo() {
        return mapearConsumo(pagoRepository.reporteConsumoPorDispositivo());
    }

    @Override
    public List<ResponseReporteAnaliticoDTO> ingresosPorCiudad() {
        return mapearIngresos(pagoRepository.reporteIngresosPorCiudad());
    }

    @Override
    public List<ResponseReporteAnaliticoDTO> ingresosPorPlan() {
        return mapearIngresos(pagoRepository.reporteIngresosPorPlan());
    }

    @Override
    public List<ResponseReporteAnaliticoDTO> rankingContenido() {
        return pagoRepository.rankingContenido().stream()
                .map(fila -> ResponseReporteAnaliticoDTO.builder()
                        .dimension(texto(fila[0]))
                        .totalReproducciones(largo(fila[1]))
                        .promedioCalificacion(decimal(fila[2]))
                        .build())
                .collect(Collectors.toList());
    }

    private List<ResponseReporteAnaliticoDTO> mapearConsumo(List<Object[]> filas) {
        return filas.stream()
                .map(fila -> ResponseReporteAnaliticoDTO.builder()
                        .dimension(texto(fila[0]))
                        .totalReproducciones(largo(fila[1]))
                        .build())
                .collect(Collectors.toList());
    }

    private List<ResponseReporteAnaliticoDTO> mapearIngresos(List<Object[]> filas) {
        return filas.stream()
                .map(fila -> ResponseReporteAnaliticoDTO.builder()
                        .dimension(texto(fila[0]))
                        .totalIngresos(bigDecimal(fila[1]))
                        .build())
                .collect(Collectors.toList());
    }

    private String texto(Object valor) {
        return valor == null ? "Sin dato" : valor.toString();
    }

    private Long largo(Object valor) {
        if (valor == null) {
            return 0L;
        }
        return ((Number) valor).longValue();
    }

    private BigDecimal bigDecimal(Object valor) {
        if (valor == null) {
            return BigDecimal.ZERO;
        }
        if (valor instanceof BigDecimal bigDecimal) {
            return bigDecimal;
        }
        return new BigDecimal(valor.toString());
    }

    private Double decimal(Object valor) {
        if (valor == null) {
            return null;
        }
        return ((Number) valor).doubleValue();
    }
}
