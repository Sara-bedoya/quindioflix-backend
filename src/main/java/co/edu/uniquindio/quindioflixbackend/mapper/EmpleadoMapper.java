package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEmpleadoDTO;
import co.edu.uniquindio.quindioflixbackend.model.Empleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    Empleado toEntity(RequestEmpleadoDTO dto);

    ResponseEmpleadoDTO toDTO(Empleado empleado);
}
