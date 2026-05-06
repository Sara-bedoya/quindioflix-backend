package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestTemporadaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseTemporadaDTO;
import co.edu.uniquindio.quindioflixbackend.model.Temporada;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TemporadaMapper {

    @Mapping(source = "contenido.idContenido", target = "idContenido")
    @Mapping(source = "contenido.titulo", target = "tituloContenido")
    ResponseTemporadaDTO toDTO(Temporada temporada);

    @Mapping(target = "idTemporada", ignore = true)
    @Mapping(target = "contenido", ignore = true)
    Temporada toEntity(RequestTemporadaDTO dto);
}
