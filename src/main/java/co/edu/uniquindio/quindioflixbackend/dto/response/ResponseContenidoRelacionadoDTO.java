package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseContenidoRelacionadoDTO {

    private Long idContenidoOrigen;
    private String tituloContenidoOrigen;
    private Long idContenidoDestino;
    private String tituloContenidoDestino;
    private String tipoRelacion;
}
