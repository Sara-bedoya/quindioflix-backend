package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseReporteAnaliticoDTO {

    private String dimension;
    private Long totalReproducciones;
    private BigDecimal totalIngresos;
    private Double promedioCalificacion;
}
