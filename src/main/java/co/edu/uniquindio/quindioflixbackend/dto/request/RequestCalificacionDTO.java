package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCalificacionDTO {

    private Long idPerfil;
    private Long idContenido;
    private Integer estrellas;
    private String comentario;
}
