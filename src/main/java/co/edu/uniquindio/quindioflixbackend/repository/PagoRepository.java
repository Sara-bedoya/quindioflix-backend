package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    List<Pago> findByIdUsuario(Long idUsuario);

    List<Pago> findByIdPlan(Long idPlan);

    List<Pago> findByEstadoPago(String estadoPago);
}
