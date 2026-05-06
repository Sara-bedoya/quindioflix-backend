package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCategoriaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCategoriaDTO;

import java.util.List;

public interface CategoriaService {

    ResponseCategoriaDTO crearCategoria(RequestCategoriaDTO dto);

    List<ResponseCategoriaDTO> listarCategorias();

    void eliminarCategoria(Long idCategoria);
}
