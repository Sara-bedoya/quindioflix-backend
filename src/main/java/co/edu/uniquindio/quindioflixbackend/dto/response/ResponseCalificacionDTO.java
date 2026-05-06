package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCalificacionDTO {

    private Long idCalificacion;
    private Long idPerfil;
    private Long idContenido;
    private Integer estrellas;
    private String comentario;
}
