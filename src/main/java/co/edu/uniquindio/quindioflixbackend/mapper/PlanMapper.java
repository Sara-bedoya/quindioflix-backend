package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPlanDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePlanDTO;
import co.edu.uniquindio.quindioflixbackend.model.Plan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanMapper {

    Plan toEntity(RequestPlanDTO dto);

    ResponsePlanDTO toDTO(Plan plan);
}
