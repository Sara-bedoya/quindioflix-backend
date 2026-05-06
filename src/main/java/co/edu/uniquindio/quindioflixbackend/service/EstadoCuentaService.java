package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEstadoCuentaDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEstadoCuentaDTO;

import java.util.List;

public interface EstadoCuentaService {

    ResponseEstadoCuentaDTO crearEstadoCuenta(RequestEstadoCuentaDTO dto);

    ResponseEstadoCuentaDTO obtenerEstadoCuenta(Long idEstado);

    List<ResponseEstadoCuentaDTO> listarEstadosCuenta();

    ResponseEstadoCuentaDTO actualizarEstadoCuenta(Long idEstado, RequestEstadoCuentaDTO dto);

    void eliminarEstadoCuenta(Long idEstado);
}
