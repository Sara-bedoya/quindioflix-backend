package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestTemporadaDTO {

    private Long idContenido;
    private Integer numeroTemporada;
    private String tituloTemporada;
}
