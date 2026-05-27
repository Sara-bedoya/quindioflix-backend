package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseEmpleadoDTO {

    private Long idEmpleado;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private Long idDepartamento;
    private Long idSupervisor;
    private String cargo;
    private String rol;
}
