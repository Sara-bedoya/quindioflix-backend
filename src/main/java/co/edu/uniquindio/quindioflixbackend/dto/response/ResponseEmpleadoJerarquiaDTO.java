package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseEmpleadoJerarquiaDTO {

    private Long idEmpleado;
    private String nombreCompleto;
    private String email;
    private String cargo;
    private Long idDepartamento;
    private List<ResponseEmpleadoJerarquiaDTO> supervisados;
}
