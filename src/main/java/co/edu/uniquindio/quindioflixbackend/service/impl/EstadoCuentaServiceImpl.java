package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEstadoCuentaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEstadoCuentaDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.EstadoCuentaMapper;
import co.edu.uniquindio.quindioflixbackend.model.EstadoCuenta;
import co.edu.uniquindio.quindioflixbackend.repository.EstadoCuentaRepository;
import co.edu.uniquindio.quindioflixbackend.service.EstadoCuentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoCuentaServiceImpl implements EstadoCuentaService {

    private final EstadoCuentaRepository estadoCuentaRepository;
    private final EstadoCuentaMapper estadoCuentaMapper;

    public EstadoCuentaServiceImpl(EstadoCuentaRepository estadoCuentaRepository,
                                   EstadoCuentaMapper estadoCuentaMapper) {
        this.estadoCuentaRepository = estadoCuentaRepository;
        this.estadoCuentaMapper = estadoCuentaMapper;
    }

    @Override
    public ResponseEstadoCuentaDTO crearEstadoCuenta(RequestEstadoCuentaDTO dto) {
        EstadoCuenta estadoCuenta = estadoCuentaRepository.save(estadoCuentaMapper.toEntity(dto));
        return estadoCuentaMapper.toDTO(estadoCuenta);
    }

    @Override
    public ResponseEstadoCuentaDTO obtenerEstadoCuenta(Long idEstado) {
        return estadoCuentaMapper.toDTO(buscarEstado(idEstado));
    }

    @Override
    public List<ResponseEstadoCuentaDTO> listarEstadosCuenta() {
        return estadoCuentaRepository.findAll().stream().map(estadoCuentaMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseEstadoCuentaDTO actualizarEstadoCuenta(Long idEstado, RequestEstadoCuentaDTO dto) {
        EstadoCuenta estadoCuenta = buscarEstado(idEstado);
        estadoCuenta.setDescripcion(dto.getDescripcion());
        return estadoCuentaMapper.toDTO(estadoCuentaRepository.save(estadoCuenta));
    }

    @Override
    public void eliminarEstadoCuenta(Long idEstado) {
        estadoCuentaRepository.delete(buscarEstado(idEstado));
    }

    private EstadoCuenta buscarEstado(Long idEstado) {
        return estadoCuentaRepository.findById(idEstado)
                .orElseThrow(() -> new RuntimeException("No existe estado de cuenta con id " + idEstado));
    }
}
