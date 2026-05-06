package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDepartamentoDTO {

    private Long idDepartamento;
    private String nombreDepartamento;
    private Long idJefe;
}
