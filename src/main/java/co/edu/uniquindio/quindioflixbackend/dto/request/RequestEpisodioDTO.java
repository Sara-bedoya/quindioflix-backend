package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestEpisodioDTO {

    private Long idTemporada;
    private Integer numeroEpisodio;
    private String tituloEpisodio;
    private Integer duracionMinutos;
    private String sinopsis;
}
