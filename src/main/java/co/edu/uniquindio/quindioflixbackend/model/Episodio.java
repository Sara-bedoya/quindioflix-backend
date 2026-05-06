package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EPISODIOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EPISODIO")
    private Long idEpisodio;

    @ManyToOne
    @JoinColumn(name = "ID_TEMPORADA")
    private Temporada temporada;

    @Column(name = "NUMERO_EPISODIO")
    private Integer numeroEpisodio;

    @Column(name = "TITULO_EPISODIO")
    private String tituloEpisodio;

    @Column(name = "DURACION_MINUTOS")
    private Integer duracionMinutos;

    @Column(name = "SINOPSIS")
    private String sinopsis;
}
