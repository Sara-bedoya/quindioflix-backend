package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseFavoritoDTO {

    private Long idFavorito;
    private Long idPerfil;
    private Long idContenido;
    private Date fechaAgregado;
}
