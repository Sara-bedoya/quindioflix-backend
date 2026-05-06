package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoDTO;
import co.edu.uniquindio.quindioflixbackend.model.Contenido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GeneroMapper.class})
public interface ContenidoMapper {

    ResponseContenidoDTO toDTO(Contenido contenido);

    @Mapping(target = "idContenido", ignore = true)
    @Mapping(target = "fechaAgregado", ignore = true)
    @Mapping(target = "generos", ignore = true)
    Contenido toEntity(RequestContenidoDTO dto);
}
