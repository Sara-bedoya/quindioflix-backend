package co.edu.uniquindio.quindioflixbackend.repository;

import co.edu.uniquindio.quindioflixbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
