package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CONTENIDO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTENIDO")
    private Long idContenido;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "ANIO_LANZAMIENTO")
    private Integer anioLanzamiento;

    @Column(name = "DURACION_MINUTOS")
    private Integer duracionMinutos;

    @Column(name = "SINOPSIS")
    private String sinopsis;

    @Column(name = "CLASIFICACION_EDAD")
    private String clasificacionEdad;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_AGREGADO", insertable = false, updatable = false)
    private Date fechaAgregado;

    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;

    @Column(name = "ES_ORIGINAL")
    private String esOriginal;

    @ManyToMany
    @JoinTable(
            name = "CONTENIDO_GENERO",
            joinColumns = @JoinColumn(name = "ID_CONTENIDO"),
            inverseJoinColumns = @JoinColumn(name = "ID_GENERO")
    )
    private List<Genero> generos;
}
