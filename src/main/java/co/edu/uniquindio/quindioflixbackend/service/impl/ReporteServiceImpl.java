package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestReporteDTO;
import co.edu.uniquindio.quindioflixbackend.dto.request.RequestResolverReporteDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReporteDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.ReporteMapper;
import co.edu.uniquindio.quindioflixbackend.model.Reporte;
import co.edu.uniquindio.quindioflixbackend.repository.ReporteRepository;
import co.edu.uniquindio.quindioflixbackend.service.ReporteService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;
    private final ReporteMapper reporteMapper;

    public ReporteServiceImpl(ReporteRepository reporteRepository, ReporteMapper reporteMapper) {
        this.reporteRepository = reporteRepository;
        this.reporteMapper = reporteMapper;
    }

    @Override
    public ResponseReporteDTO crearReporte(RequestReporteDTO dto) {
        Reporte reporte = reporteMapper.toEntity(dto);
        reporte.setEstado("PENDIENTE");
        reporte = reporteRepository.save(reporte);
        return reporteMapper.toDTO(reporte);
    }

    @Override
    public ResponseReporteDTO obtenerReporte(Long idReporte) {
        return reporteMapper.toDTO(buscarReporte(idReporte));
    }

    @Override
    public List<ResponseReporteDTO> listarReportes() {
        return convertirLista(reporteRepository.findAll());
    }

    @Override
    public List<ResponseReporteDTO> listarPorEstado(String estado) {
        return convertirLista(reporteRepository.findByEstado(estado));
    }

    @Override
    public List<ResponseReporteDTO> listarPorContenido(Long idContenido) {
        return convertirLista(reporteRepository.findByIdContenido(idContenido));
    }

    @Override
    public List<ResponseReporteDTO> listarPorModerador(Long idModerador) {
        return convertirLista(reporteRepository.findByIdModerador(idModerador));
    }

    @Override
    public List<ResponseReporteDTO> listarPorPerfilReportante(Long idPerfilReportante) {
        return convertirLista(reporteRepository.findByIdPerfilReportante(idPerfilReportante));
    }

    @Override
    public ResponseReporteDTO resolverReporte(Long idReporte, RequestResolverReporteDTO dto) {
        Reporte reporte = buscarReporte(idReporte);
        reporte.setEstado(dto.getEstado());
        reporte.setIdModerador(dto.getIdModerador());
        reporte.setComentarioResolucion(dto.getComentarioResolucion());
        reporte.setFechaResolucion(new Date());
        return reporteMapper.toDTO(reporteRepository.save(reporte));
    }

    @Override
    public void eliminarReporte(Long idReporte) {
        reporteRepository.delete(buscarReporte(idReporte));
    }

    private Reporte buscarReporte(Long idReporte) {
        return reporteRepository.findById(idReporte)
                .orElseThrow(() -> new RuntimeException("No existe reporte con id " + idReporte));
    }

    private List<ResponseReporteDTO> convertirLista(List<Reporte> reportes) {
        return reportes.stream().map(reporteMapper::toDTO).collect(Collectors.toList());
    }
}
