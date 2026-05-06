package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseEpisodioDTO {

    private Long idEpisodio;
    private Long idTemporada;
    private Integer numeroTemporada;
    private Integer numeroEpisodio;
    private String tituloEpisodio;
    private Integer duracionMinutos;
    private String sinopsis;
}
