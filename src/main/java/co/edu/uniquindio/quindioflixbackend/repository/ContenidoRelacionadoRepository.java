package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.ContenidoRelacionado;
import co.edu.uniquindio.quindioflixbackend.model.ContenidoRelacionadoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenidoRelacionadoRepository extends JpaRepository<ContenidoRelacionado, ContenidoRelacionadoId> {

    List<ContenidoRelacionado> findByContenidoOrigenIdContenido(Long idContenidoOrigen);

    List<ContenidoRelacionado> findByContenidoDestinoIdContenido(Long idContenidoDestino);
}
