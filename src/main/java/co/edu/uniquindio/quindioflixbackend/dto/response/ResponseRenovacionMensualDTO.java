package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseRenovacionMensualDTO {

    private Long idUsuario;
    private Long idPlan;
    private BigDecimal valorBase;
    private BigDecimal descuentoAntiguedad;
    private BigDecimal descuentoReferido;
    private BigDecimal montoFinal;
    private ResponsePagoDTO pago;
}
