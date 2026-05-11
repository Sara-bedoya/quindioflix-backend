package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.EstadoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoCuentaRepository extends JpaRepository<EstadoCuenta, Long> {

    Optional<EstadoCuenta> findByDescripcionIgnoreCase(String descripcion);
}
