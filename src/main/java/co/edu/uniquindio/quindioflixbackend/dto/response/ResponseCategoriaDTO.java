package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCategoriaDTO {

    private Long idCategoria;
    private String nombreCategoria;
}
