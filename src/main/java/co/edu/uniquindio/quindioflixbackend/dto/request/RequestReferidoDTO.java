package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestReferidoDTO {

    private Long idUsuarioReferidor;
    private Long idUsuarioReferido;
    private String estado;
}
