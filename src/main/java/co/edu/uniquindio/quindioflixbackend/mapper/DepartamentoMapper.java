package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestDepartamentoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseDepartamentoDTO;
import co.edu.uniquindio.quindioflixbackend.model.Departamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {

    Departamento toEntity(RequestDepartamentoDTO dto);

    ResponseDepartamentoDTO toDTO(Departamento departamento);
}
