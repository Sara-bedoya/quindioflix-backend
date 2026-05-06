package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseEstadoCuentaDTO {

    private Long idEstado;
    private String descripcion;
}
