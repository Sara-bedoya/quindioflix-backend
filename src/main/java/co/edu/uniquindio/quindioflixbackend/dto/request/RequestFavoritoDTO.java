package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestFavoritoDTO {

    private Long idPerfil;
    private Long idContenido;
}
