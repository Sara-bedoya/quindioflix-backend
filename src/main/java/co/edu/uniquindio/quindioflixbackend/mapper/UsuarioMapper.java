package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseUsuarioDTO;
import co.edu.uniquindio.quindioflixbackend.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    ResponseUsuarioDTO toDTO(Usuario usuario);

    Usuario toEntity(RequestUsuarioDTO dto);
}