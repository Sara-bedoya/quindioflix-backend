package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {

    List<Reporte> findByEstado(String estado);

    List<Reporte> findByIdContenido(Long idContenido);

    List<Reporte> findByIdModerador(Long idModerador);

    List<Reporte> findByIdPerfilReportante(Long idPerfilReportante);
}
