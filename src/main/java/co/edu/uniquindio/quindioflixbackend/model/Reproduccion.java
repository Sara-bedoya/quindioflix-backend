package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "REPRODUCCIONES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reproduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REPRODUCCION")
    private Long idReproduccion;

    @Column(name = "ID_PERFIL")
    private Long idPerfil;

    @Column(name = "ID_CONTENIDO")
    private Long idContenido;

    @Column(name = "FECHA_INICIO", insertable = false, updatable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "FECHA_FIN")
    private LocalDateTime fechaFin;

    @Column(name = "PORCENTAJE_VISTO")
    private BigDecimal porcentajeVisto;

    @Column(name = "DISPOSITIVO")
    private String dispositivo;

    @ManyToOne
    @JoinColumn(name = "ID_EPISODIO")
    private Episodio episodio;
}
