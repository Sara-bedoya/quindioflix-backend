package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPagoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePagoDTO;
import co.edu.uniquindio.quindioflixbackend.model.Pago;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagoMapper {

    @Mapping(target = "idPago", ignore = true)
    @Mapping(target = "fechaPago", ignore = true)
    Pago toEntity(RequestPagoDTO dto);

    ResponsePagoDTO toDTO(Pago pago);
}
