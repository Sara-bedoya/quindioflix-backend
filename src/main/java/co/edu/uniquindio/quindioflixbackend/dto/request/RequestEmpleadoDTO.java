package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestEmpleadoDTO {

    private String nombreCompleto;
    private String email;
    private String telefono;
    private Long idDepartamento;
    private Long idSupervisor;
    private String cargo;
}
