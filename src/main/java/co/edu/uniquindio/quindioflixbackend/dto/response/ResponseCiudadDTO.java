package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCiudadDTO {

    private Long idCiudad;
    private String nombreCiudad;
}
