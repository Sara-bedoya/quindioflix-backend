package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestPlanDTO {

    private String nombre;
    private Integer maxPantallas;
    private String calidadVideo;
    private BigDecimal precioMensual;
}
