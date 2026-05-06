package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "REPORTES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REPORTE")
    private Long idReporte;

    @Column(name = "ID_PERFIL_REPORTANTE")
    private Long idPerfilReportante;

    @Column(name = "ID_CONTENIDO")
    private Long idContenido;

    @Column(name = "DESCRIPCION_REPORTE")
    private String descripcionReporte;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_REPORTE", insertable = false, updatable = false)
    private Date fechaReporte;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "ID_MODERADOR")
    private Long idModerador;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_RESOLUCION")
    private Date fechaResolucion;

    @Column(name = "COMENTARIO_RESOLUCION")
    private String comentarioResolucion;
}
