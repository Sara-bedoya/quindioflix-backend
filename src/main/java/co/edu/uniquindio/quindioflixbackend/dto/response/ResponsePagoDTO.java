package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsePagoDTO {

    private Long idPago;
    private Long idUsuario;
    private Long idPlan;
    private Date fechaPago;
    private BigDecimal monto;
    private String metodoPago;
    private String estadoPago;
}
