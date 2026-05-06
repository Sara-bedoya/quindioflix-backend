package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseContenidoRelacionadoDTO;
import co.edu.uniquindio.quindioflixbackend.model.ContenidoRelacionado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContenidoRelacionadoMapper {

    @Mapping(source = "contenidoOrigen.idContenido", target = "idContenidoOrigen")
    @Mapping(source = "contenidoOrigen.titulo", target = "tituloContenidoOrigen")
    @Mapping(source = "contenidoDestino.idContenido", target = "idContenidoDestino")
    @Mapping(source = "contenidoDestino.titulo", target = "tituloContenidoDestino")
    ResponseContenidoRelacionadoDTO toDTO(ContenidoRelacionado contenidoRelacionado);
}
