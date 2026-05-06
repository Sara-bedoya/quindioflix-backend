package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DEPARTAMENTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPARTAMENTO")
    private Long idDepartamento;

    @Column(name = "NOMBRE_DEPARTAMENTO")
    private String nombreDepartamento;

    @Column(name = "ID_JEFE")
    private Long idJefe;
}
