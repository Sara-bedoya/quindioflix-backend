package co.edu.uniquindio.quindioflixbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "PERFILES")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERFIL")
    private Long idPerfil;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    @JsonBackReference
    private Usuario usuario;

    @Column(name = "NOMBRE_PERFIL")
    private String nombrePerfil;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "TIPO")
    private String tipo;

}
