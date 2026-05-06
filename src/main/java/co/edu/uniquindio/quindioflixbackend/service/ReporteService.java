package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReporteDTO;
import co.edu.uniquindio.quindioflixbackend.dto.request.RequestResolverReporteDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReporteDTO;

import java.util.List;

public interface ReporteService {

    ResponseReporteDTO crearReporte(RequestReporteDTO dto);

    ResponseReporteDTO obtenerReporte(Long idReporte);

    List<ResponseReporteDTO> listarReportes();

    List<ResponseReporteDTO> listarPorEstado(String estado);

    List<ResponseReporteDTO> listarPorContenido(Long idContenido);

    List<ResponseReporteDTO> listarPorModerador(Long idModerador);

    List<ResponseReporteDTO> listarPorPerfilReportante(Long idPerfilReportante);

    ResponseReporteDTO resolverReporte(Long idReporte, RequestResolverReporteDTO dto);

    void eliminarReporte(Long idReporte);
}
