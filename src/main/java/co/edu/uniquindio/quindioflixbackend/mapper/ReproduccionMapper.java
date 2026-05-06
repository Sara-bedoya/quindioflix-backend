package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReproduccionDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReproduccionDTO;
import co.edu.uniquindio.quindioflixbackend.model.Reproduccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReproduccionMapper {

    @Mapping(target = "idReproduccion", ignore = true)
    @Mapping(target = "fechaInicio", ignore = true)
    Reproduccion toEntity(RequestReproduccionDTO dto);

    ResponseReproduccionDTO toDTO(Reproduccion reproduccion);
}
