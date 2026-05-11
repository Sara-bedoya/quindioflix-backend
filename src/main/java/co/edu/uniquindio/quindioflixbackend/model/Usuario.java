package co.edu.uniquindio.quindioflixbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Column(name = "ID_CIUDAD")
    private Long idCiudad;

    @Column(name = "ID_PLAN")
    private Long idPlan;

    @Column(name = "ID_ESTADO")
    private Long idEstado;

    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;

    @Column(name = "FECHA_ULTIMO_PAGO")
    private Date fechaUltimoPago;

    @Column(name = "ES_MODERADOR")
    private String esModerador;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Perfil> perfiles;

}
