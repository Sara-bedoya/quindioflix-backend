package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEmpleadoLoginDTO {

    private Long idEmpleado;
    private String nombreCompleto;
    private String email;
    private Long idDepartamento;
    private String nombreDepartamento;
    private String cargo;
    private Long idSupervisor;
    private String rol;
    private List<String> permisos;
    private String token;
}
