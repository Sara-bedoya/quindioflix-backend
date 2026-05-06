package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseContenidoDTO {

    private Long idContenido;
    private String titulo;
    private Integer anioLanzamiento;
    private Integer duracionMinutos;
    private String sinopsis;
    private String clasificacionEdad;
    private Date fechaAgregado;
    private Long idCategoria;
    private String esOriginal;
    private List<ResponseGeneroDTO> generos;
}
