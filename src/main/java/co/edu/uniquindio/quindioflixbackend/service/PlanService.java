package co.edu.uniquindio.quindioflixbackend.service;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPlanDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePlanDTO;

import java.util.List;

public interface PlanService {

    ResponsePlanDTO crearPlan(RequestPlanDTO dto);

    ResponsePlanDTO obtenerPlan(Long idPlan);

    List<ResponsePlanDTO> listarPlanes();

    ResponsePlanDTO actualizarPlan(Long idPlan, RequestPlanDTO dto);

    void eliminarPlan(Long idPlan);
}
