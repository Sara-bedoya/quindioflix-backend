package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUsuarioDTO {

    private Long idUsuario;
    private String nombreCompleto;
    private String email;
    private String telefono;

    private Long idPlan;
    private Long idCiudad;
    private Long idEstado;

    private String rol;

    private List<ResponsePerfilDTO> perfiles;

}
