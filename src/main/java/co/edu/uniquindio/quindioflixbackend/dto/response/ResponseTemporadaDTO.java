package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseTemporadaDTO {

    private Long idTemporada;
    private Long idContenido;
    private String tituloContenido;
    private Integer numeroTemporada;
    private String tituloTemporada;
}
