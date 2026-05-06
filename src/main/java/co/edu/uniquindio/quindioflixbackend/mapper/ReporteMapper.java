package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReporteDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReporteDTO;
import co.edu.uniquindio.quindioflixbackend.model.Reporte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReporteMapper {

    @Mapping(target = "idReporte", ignore = true)
    @Mapping(target = "fechaReporte", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "idModerador", ignore = true)
    @Mapping(target = "fechaResolucion", ignore = true)
    @Mapping(target = "comentarioResolucion", ignore = true)
    Reporte toEntity(RequestReporteDTO dto);

    ResponseReporteDTO toDTO(Reporte reporte);
}
