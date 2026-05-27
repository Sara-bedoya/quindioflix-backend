package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT COUNT(1) FROM USUARIOS WHERE LOWER(EMAIL) = LOWER(:email)", nativeQuery = true)
    long countByEmailNative(@Param("email") String email);

    Optional<Usuario> findByEmail(String email);
}
