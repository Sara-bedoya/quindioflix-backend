package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestReporteDTO {

    private Long idPerfilReportante;
    private Long idContenido;
    private String descripcionReporte;
}
