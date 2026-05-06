package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestGeneroDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseGeneroDTO;
import co.edu.uniquindio.quindioflixbackend.model.Genero;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneroMapper {

    Genero toEntity(RequestGeneroDTO dto);

    ResponseGeneroDTO toDTO(Genero genero);
}