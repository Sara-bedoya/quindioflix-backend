package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCategoriaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCategoriaDTO;
import co.edu.uniquindio.quindioflixbackend.model.Categoria;
import co.edu.uniquindio.quindioflixbackend.repository.ContenidoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.CategoriaRepository;
import co.edu.uniquindio.quindioflixbackend.service.CategoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ContenidoRepository contenidoRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository,
                                ContenidoRepository contenidoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.contenidoRepository = contenidoRepository;
    }

    @Override
    public ResponseCategoriaDTO crearCategoria(RequestCategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(dto.getNombreCategoria());
        categoria = categoriaRepository.save(categoria);
        return toDTO(categoria);
    }

    @Override
    public List<ResponseCategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void eliminarCategoria(Long idCategoria) {
        Categoria categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("No existe categoria con id " + idCategoria));
        contenidoRepository.findByIdCategoria(idCategoria).forEach(contenido -> {
            contenido.setIdCategoria(null);
            contenidoRepository.save(contenido);
        });
        categoriaRepository.delete(categoria);
    }

    private ResponseCategoriaDTO toDTO(Categoria categoria) {
        return new ResponseCategoriaDTO(
                categoria.getIdCategoria(),
                categoria.getNombreCategoria()
        );
    }
}
