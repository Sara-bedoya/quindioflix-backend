package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseReporteAnaliticoDTO;

import java.util.List;

public interface AnaliticaService {

    List<ResponseReporteAnaliticoDTO> consumoPorCiudad();

    List<ResponseReporteAnaliticoDTO> consumoPorCategoria();

    List<ResponseReporteAnaliticoDTO> consumoPorGenero();

    List<ResponseReporteAnaliticoDTO> consumoPorDispositivo();

    List<ResponseReporteAnaliticoDTO> ingresosPorCiudad();

    List<ResponseReporteAnaliticoDTO> ingresosPorPlan();

    List<ResponseReporteAnaliticoDTO> rankingContenido();
}
