package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCalificacionDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCalificacionDTO;
import co.edu.uniquindio.quindioflixbackend.model.Calificacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CalificacionMapper {

    @Mapping(target = "idCalificacion", ignore = true)
    Calificacion toEntity(RequestCalificacionDTO dto);

    ResponseCalificacionDTO toDTO(Calificacion calificacion);
}
