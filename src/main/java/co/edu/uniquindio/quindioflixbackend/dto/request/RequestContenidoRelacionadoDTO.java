package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestContenidoRelacionadoDTO {

    private Long idContenidoOrigen;
    private Long idContenidoDestino;
    private String tipoRelacion;
}
