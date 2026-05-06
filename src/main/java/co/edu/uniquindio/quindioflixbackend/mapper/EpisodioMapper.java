package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEpisodioDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEpisodioDTO;
import co.edu.uniquindio.quindioflixbackend.model.Episodio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EpisodioMapper {

    @Mapping(source = "temporada.idTemporada", target = "idTemporada")
    @Mapping(source = "temporada.numeroTemporada", target = "numeroTemporada")
    ResponseEpisodioDTO toDTO(Episodio episodio);

    @Mapping(target = "idEpisodio", ignore = true)
    @Mapping(target = "temporada", ignore = true)
    Episodio toEntity(RequestEpisodioDTO dto);
}
