package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenidoRepository extends JpaRepository<Contenido, Long> {

    List<Contenido> findByIdCategoria(Long idCategoria);

    List<Contenido> findByClasificacionEdadIn(List<String> clasificacionesEdad);

    List<Contenido> findByGenerosIdGenero(Long idGenero);

    List<Contenido> findByIdEmpleadoResponsable(Long idEmpleadoResponsable);
}
