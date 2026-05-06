package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CIUDADES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CIUDAD")
    private Long idCiudad;

    @Column(name = "NOMBRE_CIUDAD")
    private String nombreCiudad;
}
