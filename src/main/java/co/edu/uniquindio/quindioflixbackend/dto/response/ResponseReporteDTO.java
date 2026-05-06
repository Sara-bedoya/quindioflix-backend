package co.edu.uniquindio.quindioflixbackend.dto.response;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseReporteDTO {

    private Long idReporte;
    private Long idPerfilReportante;
    private Long idContenido;
    private String descripcionReporte;
    private Date fechaReporte;
    private String estado;
    private Long idModerador;
    private Date fechaResolucion;
    private String comentarioResolucion;
}
