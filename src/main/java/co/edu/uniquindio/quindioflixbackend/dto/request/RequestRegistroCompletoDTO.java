package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestRegistroCompletoDTO {

    private String nombreCompleto;
    private String email;
    private String telefono;
    private Date fechaNacimiento;
    private Long idCiudad;
    private Long idPlan;
    private Long idEstado;

    private String nombrePerfil;
    private String avatar;
    private String tipoPerfil;

    private BigDecimal monto;
    private String metodoPago;
    private String estadoPago;
}
