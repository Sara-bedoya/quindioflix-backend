package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {

    List<Calificacion> findByIdPerfil(Long idPerfil);

    List<Calificacion> findByIdContenido(Long idContenido);
}
