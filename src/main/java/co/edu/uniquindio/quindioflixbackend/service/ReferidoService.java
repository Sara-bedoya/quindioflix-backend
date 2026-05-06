package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReferidoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReferidoDTO;

import java.util.List;

public interface ReferidoService {

    ResponseReferidoDTO crearReferido(RequestReferidoDTO dto);

    ResponseReferidoDTO obtenerReferido(Long idReferido);

    List<ResponseReferidoDTO> listarReferidos();

    List<ResponseReferidoDTO> listarPorReferidor(Long idUsuarioReferidor);

    List<ResponseReferidoDTO> listarPorReferido(Long idUsuarioReferido);

    ResponseReferidoDTO actualizarReferido(Long idReferido, RequestReferidoDTO dto);

    void eliminarReferido(Long idReferido);
}
