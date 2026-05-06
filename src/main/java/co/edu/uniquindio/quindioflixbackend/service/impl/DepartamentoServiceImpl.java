package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestDepartamentoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseDepartamentoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.DepartamentoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Departamento;
import co.edu.uniquindio.quindioflixbackend.repository.DepartamentoRepository;
import co.edu.uniquindio.quindioflixbackend.service.DepartamentoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoMapper departamentoMapper;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository,
                                   DepartamentoMapper departamentoMapper) {
        this.departamentoRepository = departamentoRepository;
        this.departamentoMapper = departamentoMapper;
    }

    @Override
    public ResponseDepartamentoDTO crearDepartamento(RequestDepartamentoDTO dto) {
        Departamento departamento = departamentoRepository.save(departamentoMapper.toEntity(dto));
        return departamentoMapper.toDTO(departamento);
    }

    @Override
    public ResponseDepartamentoDTO obtenerDepartamento(Long idDepartamento) {
        return departamentoMapper.toDTO(buscarDepartamento(idDepartamento));
    }

    @Override
    public List<ResponseDepartamentoDTO> listarDepartamentos() {
        return departamentoRepository.findAll().stream().map(departamentoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ResponseDepartamentoDTO actualizarDepartamento(Long idDepartamento, RequestDepartamentoDTO dto) {
        Departamento departamento = buscarDepartamento(idDepartamento);
        departamento.setNombreDepartamento(dto.getNombreDepartamento());
        departamento.setIdJefe(dto.getIdJefe());
        return departamentoMapper.toDTO(departamentoRepository.save(departamento));
    }

    @Override
    public void eliminarDepartamento(Long idDepartamento) {
        departamentoRepository.delete(buscarDepartamento(idDepartamento));
    }

    private Departamento buscarDepartamento(Long idDepartamento) {
        return departamentoRepository.findById(idDepartamento)
                .orElseThrow(() -> new RuntimeException("No existe departamento con id " + idDepartamento));
    }
}
