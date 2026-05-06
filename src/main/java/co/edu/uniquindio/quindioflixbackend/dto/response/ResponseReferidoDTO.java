package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseReferidoDTO {

    private Long idReferido;
    private Long idUsuarioReferidor;
    private Long idUsuarioReferido;
    private Date fechaReferido;
    private String estado;
}
