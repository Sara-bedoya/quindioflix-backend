package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ESTADOS_CUENTA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO")
    private Long idEstado;

    @Column(name = "DESCRIPCION")
    private String descripcion;
}
