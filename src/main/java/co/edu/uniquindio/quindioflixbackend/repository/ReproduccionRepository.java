package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Reproduccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReproduccionRepository extends JpaRepository<Reproduccion, Long> {

    List<Reproduccion> findByIdPerfil(Long idPerfil);

    List<Reproduccion> findByIdContenido(Long idContenido);

    List<Reproduccion> findByIdPerfilAndIdContenido(Long idPerfil, Long idContenido);

    //Busca la reproduccion con el idPerfil y el idContenido mas reciente
    List<Reproduccion>
    findByIdPerfilAndIdContenidoOrderByFechaInicioDesc(
            Long idPerfil,
            Long idContenido
    );
}
