package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestPagoDTO {

    private Long idUsuario;
    private Long idPlan;
    private BigDecimal monto;
    private String metodoPago;
    private String estadoPago;
}
