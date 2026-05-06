package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestUsuarioDTO {

    private String nombreCompleto;
    private String email;
    private String telefono;
    private Date fechaNacimiento;

    private Long idPlan;
    private Long idCiudad;
    private Long idEstado;

}
