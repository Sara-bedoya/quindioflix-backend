package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReferidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReferidoDTO;
import co.edu.uniquindio.quindioflixbackend.model.Referido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReferidoMapper {

    @Mapping(target = "idReferido", ignore = true)
    @Mapping(target = "fechaReferido", ignore = true)
    Referido toEntity(RequestReferidoDTO dto);

    ResponseReferidoDTO toDTO(Referido referido);
}
