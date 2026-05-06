package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestFavoritoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseFavoritoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.FavoritoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Favorito;
import co.edu.uniquindio.quindioflixbackend.repository.FavoritoRepository;
import co.edu.uniquindio.quindioflixbackend.service.FavoritoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoritoServiceImpl implements FavoritoService {

    private final FavoritoRepository favoritoRepository;
    private final FavoritoMapper favoritoMapper;

    public FavoritoServiceImpl(FavoritoRepository favoritoRepository, FavoritoMapper favoritoMapper) {
        this.favoritoRepository = favoritoRepository;
        this.favoritoMapper = favoritoMapper;
    }

    @Override
    public ResponseFavoritoDTO crearFavorito(RequestFavoritoDTO dto) {
        Favorito favorito = favoritoRepository.save(favoritoMapper.toEntity(dto));
        return favoritoMapper.toDTO(favorito);
    }

    @Override
    public ResponseFavoritoDTO obtenerFavorito(Long idFavorito) {
        return favoritoMapper.toDTO(buscarFavorito(idFavorito));
    }

    @Override
    public List<ResponseFavoritoDTO> listarFavoritos() {
        return convertirLista(favoritoRepository.findAll());
    }

    @Override
    public List<ResponseFavoritoDTO> listarPorPerfil(Long idPerfil) {
        return convertirLista(favoritoRepository.findByIdPerfil(idPerfil));
    }

    @Override
    public List<ResponseFavoritoDTO> listarPorContenido(Long idContenido) {
        return convertirLista(favoritoRepository.findByIdContenido(idContenido));
    }

    @Override
    public void eliminarFavorito(Long idFavorito) {
        favoritoRepository.delete(buscarFavorito(idFavorito));
    }

    private Favorito buscarFavorito(Long idFavorito) {
        return favoritoRepository.findById(idFavorito)
                .orElseThrow(() -> new RuntimeException("No existe favorito con id " + idFavorito));
    }

    private List<ResponseFavoritoDTO> convertirLista(List<Favorito> favoritos) {
        return favoritos.stream().map(favoritoMapper::toDTO).collect(Collectors.toList());
    }
}
