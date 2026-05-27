package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EMPLEADOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPLEADO")
    private Long idEmpleado;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "ID_DEPARTAMENTO")
    private Long idDepartamento;

    @Column(name = "ID_SUPERVISOR")
    private Long idSupervisor;

    @Column(name = "CARGO")
    private String cargo;
}
