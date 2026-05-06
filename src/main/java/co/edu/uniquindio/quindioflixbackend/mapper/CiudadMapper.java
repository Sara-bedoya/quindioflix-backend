package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCiudadDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCiudadDTO;
import co.edu.uniquindio.quindioflixbackend.model.Ciudad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CiudadMapper {

    Ciudad toEntity(RequestCiudadDTO dto);

    ResponseCiudadDTO toDTO(Ciudad ciudad);
}
