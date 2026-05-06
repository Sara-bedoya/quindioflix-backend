package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TEMPORADAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TEMPORADA")
    private Long idTemporada;

    @ManyToOne
    @JoinColumn(name = "ID_CONTENIDO")
    private Contenido contenido;

    @Column(name = "NUMERO_TEMPORADA")
    private Integer numeroTemporada;

    @Column(name = "TITULO_TEMPORADA")
    private String tituloTemporada;
}
