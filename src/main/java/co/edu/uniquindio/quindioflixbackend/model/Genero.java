package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GENEROS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genero {

    @Id
    @Column(name = "ID_GENERO")
    private Long idGenero;

    @Column(name = "NOMBRE_GENERO", nullable = false, unique = true)
    private String nombreGenero;
}