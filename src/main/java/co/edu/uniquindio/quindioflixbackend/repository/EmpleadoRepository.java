package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findByEmail(String email);

    List<Empleado> findByIdDepartamento(Long idDepartamento);

    List<Empleado> findByIdSupervisor(Long idSupervisor);

    boolean existsByIdDepartamento(Long idDepartamento);

    boolean existsByIdSupervisor(Long idSupervisor);
}
