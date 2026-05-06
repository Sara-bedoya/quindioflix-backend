package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestGeneroDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseGeneroDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.GeneroMapper;
import co.edu.uniquindio.quindioflixbackend.model.Genero;
import co.edu.uniquindio.quindioflixbackend.repository.GeneroRepository;
import co.edu.uniquindio.quindioflixbackend.service.GeneroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepository;
    private final GeneroMapper generoMapper;

    public GeneroServiceImpl(GeneroRepository generoRepository, GeneroMapper generoMapper) {
        this.generoRepository = generoRepository;
        this.generoMapper = generoMapper;
    }

    @Override
    public ResponseGeneroDTO crearGenero(RequestGeneroDTO dto) {
        Genero genero = generoMapper.toEntity(dto);
        genero = generoRepository.save(genero);
        return generoMapper.toDTO(genero);
    }

    @Override
    public List<ResponseGeneroDTO> listarGeneros() {
        return generoRepository.findAll()
                .stream()
                .map(generoMapper::toDTO)
                .collect(Collectors.toList());
    }
}