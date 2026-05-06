package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestPerfilDTO {

    private Long idUsuario;
    private String nombrePerfil;
    private String avatar;
    private String tipo;
}
