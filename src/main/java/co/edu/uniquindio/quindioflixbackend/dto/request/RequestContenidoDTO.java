package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestContenidoDTO {

    private String titulo;
    private Integer anioLanzamiento;
    private Integer duracionMinutos;
    private String sinopsis;
    private String clasificacionEdad;
    private Long idCategoria;
    private String esOriginal;
    private Long idEmpleadoResponsable;
    private List<Long> idsGeneros;
}
