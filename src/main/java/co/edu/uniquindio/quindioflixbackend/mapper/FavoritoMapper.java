package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestFavoritoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseFavoritoDTO;
import co.edu.uniquindio.quindioflixbackend.model.Favorito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FavoritoMapper {

    @Mapping(target = "idFavorito", ignore = true)
    @Mapping(target = "fechaAgregado", ignore = true)
    Favorito toEntity(RequestFavoritoDTO dto);

    ResponseFavoritoDTO toDTO(Favorito favorito);
}
