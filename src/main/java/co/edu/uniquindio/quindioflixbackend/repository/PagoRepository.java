package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    List<Pago> findByIdUsuario(Long idUsuario);

    List<Pago> findByIdPlan(Long idPlan);

    List<Pago> findByEstadoPago(String estadoPago);

    @Query(value = """
            SELECT c.nombre_ciudad, COUNT(r.id_reproduccion)
            FROM reproducciones r
            JOIN perfiles p ON p.id_perfil = r.id_perfil
            JOIN usuarios u ON u.id_usuario = p.id_usuario
            JOIN ciudades c ON c.id_ciudad = u.id_ciudad
            GROUP BY c.nombre_ciudad
            ORDER BY COUNT(r.id_reproduccion) DESC
            """, nativeQuery = true)
    List<Object[]> reporteConsumoPorCiudad();

    @Query(value = """
            SELECT cat.nombre_categoria, COUNT(r.id_reproduccion)
            FROM reproducciones r
            JOIN contenido c ON c.id_contenido = r.id_contenido
            JOIN categorias cat ON cat.id_categoria = c.id_categoria
            GROUP BY cat.nombre_categoria
            ORDER BY COUNT(r.id_reproduccion) DESC
            """, nativeQuery = true)
    List<Object[]> reporteConsumoPorCategoria();

    @Query(value = """
            SELECT g.nombre_genero, COUNT(r.id_reproduccion)
            FROM reproducciones r
            JOIN contenido_genero cg ON cg.id_contenido = r.id_contenido
            JOIN generos g ON g.id_genero = cg.id_genero
            GROUP BY g.nombre_genero
            ORDER BY COUNT(r.id_reproduccion) DESC
            """, nativeQuery = true)
    List<Object[]> reporteConsumoPorGenero();

    @Query(value = """
            SELECT r.dispositivo, COUNT(r.id_reproduccion)
            FROM reproducciones r
            GROUP BY r.dispositivo
            ORDER BY COUNT(r.id_reproduccion) DESC
            """, nativeQuery = true)
    List<Object[]> reporteConsumoPorDispositivo();

    @Query(value = """
            SELECT c.nombre_ciudad, SUM(p.monto)
            FROM pagos p
            JOIN usuarios u ON u.id_usuario = p.id_usuario
            JOIN ciudades c ON c.id_ciudad = u.id_ciudad
            WHERE UPPER(p.estado_pago) = 'EXITOSO'
            GROUP BY c.nombre_ciudad
            ORDER BY SUM(p.monto) DESC
            """, nativeQuery = true)
    List<Object[]> reporteIngresosPorCiudad();

    @Query(value = """
            SELECT pl.nombre, SUM(p.monto)
            FROM pagos p
            JOIN planes pl ON pl.id_plan = p.id_plan
            WHERE UPPER(p.estado_pago) = 'EXITOSO'
            GROUP BY pl.nombre
            ORDER BY SUM(p.monto) DESC
            """, nativeQuery = true)
    List<Object[]> reporteIngresosPorPlan();

    @Query(value = """
            SELECT c.titulo, COUNT(r.id_reproduccion), AVG(cal.estrellas)
            FROM contenido c
            LEFT JOIN reproducciones r ON r.id_contenido = c.id_contenido
            LEFT JOIN calificaciones cal ON cal.id_contenido = c.id_contenido
            GROUP BY c.titulo
            ORDER BY COUNT(r.id_reproduccion) DESC
            """, nativeQuery = true)
    List<Object[]> rankingContenido();
}
