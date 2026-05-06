package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEstadoCuentaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEstadoCuentaDTO;
import co.edu.uniquindio.quindioflixbackend.model.EstadoCuenta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadoCuentaMapper {

    EstadoCuenta toEntity(RequestEstadoCuentaDTO dto);

    ResponseEstadoCuentaDTO toDTO(EstadoCuenta estadoCuenta);
}
