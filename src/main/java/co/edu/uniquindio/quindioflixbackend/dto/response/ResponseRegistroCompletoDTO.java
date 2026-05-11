package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseRegistroCompletoDTO {

    private ResponseUsuarioDTO usuario;
    private ResponsePerfilDTO perfil;
    private ResponsePagoDTO pago;
}
