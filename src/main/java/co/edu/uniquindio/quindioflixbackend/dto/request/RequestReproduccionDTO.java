package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestReproduccionDTO {

    private Long idPerfil;
    private Long idContenido;
    private LocalDateTime fechaFin;
    private BigDecimal porcentajeVisto;
}
