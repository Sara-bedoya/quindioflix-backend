package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsePerfilDTO {

    private Long idPerfil;
    private String nombrePerfil;
    private String avatar;
    private String tipo;
    private Long idUsuario;

}
