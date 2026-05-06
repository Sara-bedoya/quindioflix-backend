package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCategoriaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCategoriaDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.CategoriaMapper;
import co.edu.uniquindio.quindioflixbackend.model.Categoria;
import co.edu.uniquindio.quindioflixbackend.repository.CategoriaRepository;
import co.edu.uniquindio.quindioflixbackend.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository,
                                CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public ResponseCategoriaDTO crearCategoria(RequestCategoriaDTO dto) {
        Categoria categoria = categoriaMapper.toEntity(dto);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(categoria);
    }

    @Override
    public List<ResponseCategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
