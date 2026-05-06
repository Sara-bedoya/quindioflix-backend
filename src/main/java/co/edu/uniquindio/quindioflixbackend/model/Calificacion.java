package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CALIFICACIONES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CALIFICACION")
    private Long idCalificacion;

    @Column(name = "ID_PERFIL")
    private Long idPerfil;

    @Column(name = "ID_CONTENIDO")
    private Long idContenido;

    @Column(name = "ESTRELLAS")
    private Integer estrellas;

    @Column(name = "COMENTARIO")
    private String comentario;
}
