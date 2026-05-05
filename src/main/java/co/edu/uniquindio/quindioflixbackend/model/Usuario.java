package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import java.util.Date;

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

    @Column(name = "ES_MODERADOR")
    private String esModerador;

    // getters y setters

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Long getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Long idPlan) {
        this.idPlan = idPlan;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEsModerador() {
        return esModerador;
    }

    public void setEsModerador(String esModerador) {
        this.esModerador = esModerador;
    }
}