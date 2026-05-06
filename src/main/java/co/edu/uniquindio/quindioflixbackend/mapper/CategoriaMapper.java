package co.edu.uniquindio.quindioflixbackend.mapper;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCategoriaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCategoriaDTO;
import co.edu.uniquindio.quindioflixbackend.model.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toEntity(RequestCategoriaDTO dto);

    ResponseCategoriaDTO toDTO(Categoria categoria);
}
