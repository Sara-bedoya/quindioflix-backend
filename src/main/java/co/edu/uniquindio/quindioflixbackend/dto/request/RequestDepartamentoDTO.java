package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDepartamentoDTO {

    private String nombreDepartamento;
    private Long idJefe;
}
