package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Reproduccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReproduccionRepository extends JpaRepository<Reproduccion, Long> {

    List<Reproduccion> findByIdPerfil(Long idPerfil);

    List<Reproduccion> findByIdContenido(Long idContenido);

    List<Reproduccion> findByIdPerfilAndIdContenido(Long idPerfil, Long idContenido);
}
