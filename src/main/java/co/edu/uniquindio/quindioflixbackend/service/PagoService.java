package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPagoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePagoDTO;

import java.util.List;

public interface PagoService {

    ResponsePagoDTO crearPago(RequestPagoDTO dto);

    ResponsePagoDTO obtenerPago(Long idPago);

    List<ResponsePagoDTO> listarPagos();

    List<ResponsePagoDTO> listarPorUsuario(Long idUsuario);

    List<ResponsePagoDTO> listarPorPlan(Long idPlan);

    List<ResponsePagoDTO> listarPorEstado(String estadoPago);

    ResponsePagoDTO actualizarPago(Long idPago, RequestPagoDTO dto);

    void eliminarPago(Long idPago);
}
