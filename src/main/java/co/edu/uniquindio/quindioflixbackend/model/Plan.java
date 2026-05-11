package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PLANES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLAN")
    private Long idPlan;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "MAX_PANTALLAS")
    private Integer maxPantallas;

    @Column(name = "CALIDAD_VIDEO")
    private String calidadVideo;

    @Column(name = "PRECIO_MENSUAL")
    private BigDecimal precioMensual;

    @Column(name = "MAX_PERFILES")
    private Integer maxPerfiles;
}
