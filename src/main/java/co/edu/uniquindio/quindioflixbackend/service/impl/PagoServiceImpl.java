package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPagoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePagoDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.PagoMapper;
import co.edu.uniquindio.quindioflixbackend.model.Pago;
import co.edu.uniquindio.quindioflixbackend.repository.PagoRepository;
import co.edu.uniquindio.quindioflixbackend.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    public PagoServiceImpl(PagoRepository pagoRepository, PagoMapper pagoMapper) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public ResponsePagoDTO crearPago(RequestPagoDTO dto) {
        Pago pago = pagoRepository.save(pagoMapper.toEntity(dto));
        return pagoMapper.toDTO(pago);
    }

    @Override
    public ResponsePagoDTO obtenerPago(Long idPago) {
        return pagoMapper.toDTO(buscarPago(idPago));
    }

    @Override
    public List<ResponsePagoDTO> listarPagos() {
        return convertirLista(pagoRepository.findAll());
    }

    @Override
    public List<ResponsePagoDTO> listarPorUsuario(Long idUsuario) {
        return convertirLista(pagoRepository.findByIdUsuario(idUsuario));
    }

    @Override
    public List<ResponsePagoDTO> listarPorPlan(Long idPlan) {
        return convertirLista(pagoRepository.findByIdPlan(idPlan));
    }

    @Override
    public List<ResponsePagoDTO> listarPorEstado(String estadoPago) {
        return convertirLista(pagoRepository.findByEstadoPago(estadoPago));
    }

    @Override
    public ResponsePagoDTO actualizarPago(Long idPago, RequestPagoDTO dto) {
        Pago pago = buscarPago(idPago);
        pago.setIdUsuario(dto.getIdUsuario());
        pago.setIdPlan(dto.getIdPlan());
        pago.setMonto(dto.getMonto());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setEstadoPago(dto.getEstadoPago());
        return pagoMapper.toDTO(pagoRepository.save(pago));
    }

    @Override
    public void eliminarPago(Long idPago) {
        pagoRepository.delete(buscarPago(idPago));
    }

    private Pago buscarPago(Long idPago) {
        return pagoRepository.findById(idPago)
                .orElseThrow(() -> new RuntimeException("No existe pago con id " + idPago));
    }

    private List<ResponsePagoDTO> convertirLista(List<Pago> pagos) {
        return pagos.stream().map(pagoMapper::toDTO).collect(Collectors.toList());
    }
}
