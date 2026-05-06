package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContenidoRelacionadoId implements Serializable {

    @Column(name = "ID_CONTENIDO_ORIGEN")
    private Long idContenidoOrigen;

    @Column(name = "ID_CONTENIDO_DESTINO")
    private Long idContenidoDestino;
}
