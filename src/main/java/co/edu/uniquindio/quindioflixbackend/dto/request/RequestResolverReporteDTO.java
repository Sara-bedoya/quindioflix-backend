package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestResolverReporteDTO {

    private Long idModerador;
    private String estado;
    private String comentarioResolucion;
}
