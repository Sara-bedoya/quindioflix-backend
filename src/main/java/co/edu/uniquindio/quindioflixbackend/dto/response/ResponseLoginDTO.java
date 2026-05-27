package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLoginDTO {

    private Long idUsuario;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private Long idPlan;
    private Long idCiudad;
    private Long idEstado;
    private String rol;
    private String token;

}
