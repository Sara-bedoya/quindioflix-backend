package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Referido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReferidoRepository extends JpaRepository<Referido, Long> {

    List<Referido> findByIdUsuarioReferidor(Long idUsuarioReferidor);

    List<Referido> findByIdUsuarioReferido(Long idUsuarioReferido);

    boolean existsByIdUsuarioReferidorAndEstadoIgnoreCase(Long idUsuarioReferidor, String estado);

    boolean existsByIdUsuarioReferidoAndEstadoIgnoreCase(Long idUsuarioReferido, String estado);
}
