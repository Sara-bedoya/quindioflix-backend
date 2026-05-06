package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPerfilDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePerfilDTO;
import co.edu.uniquindio.quindioflixbackend.model.Perfil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PerfilMapper {

    @Mapping(source = "usuario.idUsuario", target = "idUsuario")
    ResponsePerfilDTO toDTO(Perfil perfil);

    @Mapping(target = "usuario", ignore = true)
    Perfil toEntity(RequestPerfilDTO dto);
}