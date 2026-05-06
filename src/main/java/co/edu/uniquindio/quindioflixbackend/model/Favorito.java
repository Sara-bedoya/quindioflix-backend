package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "FAVORITOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FAVORITO")
    private Long idFavorito;

    @Column(name = "ID_PERFIL")
    private Long idPerfil;

    @Column(name = "ID_CONTENIDO")
    private Long idContenido;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_AGREGADO", insertable = false, updatable = false)
    private Date fechaAgregado;
}
