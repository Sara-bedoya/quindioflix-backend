package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReferidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReferidoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.ReferidoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Referido;
import co.edu.uniquindio.quindioflixbackend.repository.ReferidoRepository;
import co.edu.uniquindio.quindioflixbackend.service.ReferidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReferidoServiceImpl implements ReferidoService {

    private final ReferidoRepository referidoRepository;
    private final ReferidoMapper referidoMapper;

    public ReferidoServiceImpl(ReferidoRepository referidoRepository, ReferidoMapper referidoMapper) {
        this.referidoRepository = referidoRepository;
        this.referidoMapper = referidoMapper;
    }

    @Override
    public ResponseReferidoDTO crearReferido(RequestReferidoDTO dto) {
        Referido referido = referidoRepository.save(referidoMapper.toEntity(dto));
        return referidoMapper.toDTO(referido);
    }

    @Override
    public ResponseReferidoDTO obtenerReferido(Long idReferido) {
        return referidoMapper.toDTO(buscarReferido(idReferido));
    }

    @Override
    public List<ResponseReferidoDTO> listarReferidos() {
        return convertirLista(referidoRepository.findAll());
    }

    @Override
    public List<ResponseReferidoDTO> listarPorReferidor(Long idUsuarioReferidor) {
        return convertirLista(referidoRepository.findByIdUsuarioReferidor(idUsuarioReferidor));
    }

    @Override
    public List<ResponseReferidoDTO> listarPorReferido(Long idUsuarioReferido) {
        return convertirLista(referidoRepository.findByIdUsuarioReferido(idUsuarioReferido));
    }

    @Override
    public ResponseReferidoDTO actualizarReferido(Long idReferido, RequestReferidoDTO dto) {
        Referido referido = buscarReferido(idReferido);
        referido.setIdUsuarioReferidor(dto.getIdUsuarioReferidor());
        referido.setIdUsuarioReferido(dto.getIdUsuarioReferido());
        referido.setEstado(dto.getEstado());
        return referidoMapper.toDTO(referidoRepository.save(referido));
    }

    @Override
    public void eliminarReferido(Long idReferido) {
        referidoRepository.delete(buscarReferido(idReferido));
    }

    private Referido buscarReferido(Long idReferido) {
        return referidoRepository.findById(idReferido)
                .orElseThrow(() -> new RuntimeException("No existe referido con id " + idReferido));
    }

    private List<ResponseReferidoDTO> convertirLista(List<Referido> referidos) {
        return referidos.stream().map(referidoMapper::toDTO).collect(Collectors.toList());
    }
}
