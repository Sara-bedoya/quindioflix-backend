package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseReproduccionDTO {

    private Long idReproduccion;
    private Long idPerfil;
    private Long idContenido;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private BigDecimal porcentajeVisto;
    private String dispositivo;
    private Long idEpisodio;
}
