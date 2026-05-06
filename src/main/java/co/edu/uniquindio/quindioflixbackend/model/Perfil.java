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

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
