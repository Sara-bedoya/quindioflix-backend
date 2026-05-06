package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CONTENIDO_RELACIONADO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContenidoRelacionado {

    @EmbeddedId
    private ContenidoRelacionadoId id;

    @ManyToOne
    @MapsId("idContenidoOrigen")
    @JoinColumn(name = "ID_CONTENIDO_ORIGEN")
    private Contenido contenidoOrigen;

    @ManyToOne
    @MapsId("idContenidoDestino")
    @JoinColumn(name = "ID_CONTENIDO_DESTINO")
    private Contenido contenidoDestino;

    @Column(name = "TIPO_RELACION")
    private String tipoRelacion;
}
