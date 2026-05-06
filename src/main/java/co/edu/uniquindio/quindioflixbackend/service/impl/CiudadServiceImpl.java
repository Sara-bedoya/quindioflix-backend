package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestCiudadDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseCiudadDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.CiudadMapper;
import co.edu.uniquindio.quindioflixbackend.model.Ciudad;
import co.edu.uniquindio.quindioflixbackend.repository.CiudadRepository;
import co.edu.uniquindio.quindioflixbackend.service.CiudadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;
    private final CiudadMapper ciudadMapper;

    public CiudadServiceImpl(CiudadRepository ciudadRepository, CiudadMapper ciudadMapper) {
        this.ciudadRepository = ciudadRepository;
        this.ciudadMapper = ciudadMapper;
    }

    @Override
    public ResponseCiudadDTO crearCiudad(RequestCiudadDTO dto) {
        Ciudad ciudad = ciudadRepository.save(ciudadMapper.toEntity(dto));
        return ciudadMapper.toDTO(ciudad);
    }

    @Override
    public ResponseCiudadDTO obtenerCiudad(Long idCiudad) {
        return ciudadMapper.toDTO(buscarCiudad(idCiudad));
    }

    @Override
    public List<ResponseCiudadDTO> listarCiudades() {
        return ciudadRepository.findAll().stream().map(ciudadMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseCiudadDTO actualizarCiudad(Long idCiudad, RequestCiudadDTO dto) {
        Ciudad ciudad = buscarCiudad(idCiudad);
        ciudad.setNombreCiudad(dto.getNombreCiudad());
        return ciudadMapper.toDTO(ciudadRepository.save(ciudad));
    }

    @Override
    public void eliminarCiudad(Long idCiudad) {
        ciudadRepository.delete(buscarCiudad(idCiudad));
    }

    private Ciudad buscarCiudad(Long idCiudad) {
        return ciudadRepository.findById(idCiudad)
                .orElseThrow(() -> new RuntimeException("No existe ciudad con id " + idCiudad));
    }
}
