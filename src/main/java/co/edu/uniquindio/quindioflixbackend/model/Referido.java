package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "REFERIDOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Referido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REFERIDO")
    private Long idReferido;

    @Column(name = "ID_USUARIO_REFERIDOR")
    private Long idUsuarioReferidor;

    @Column(name = "ID_USUARIO_REFERIDO")
    private Long idUsuarioReferido;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_REFERIDO", insertable = false, updatable = false)
    private Date fechaReferido;

    @Column(name = "ESTADO")
    private String estado;
}
