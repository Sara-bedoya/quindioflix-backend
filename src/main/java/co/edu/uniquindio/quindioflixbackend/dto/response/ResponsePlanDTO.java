package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsePlanDTO {

    private Long idPlan;
    private String nombre;
    private Integer maxPantallas;
    private String calidadVideo;
    private BigDecimal precioMensual;
}
