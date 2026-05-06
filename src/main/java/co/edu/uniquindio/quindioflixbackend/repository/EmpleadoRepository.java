package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findByIdDepartamento(Long idDepartamento);

    List<Empleado> findByIdSupervisor(Long idSupervisor);
}
