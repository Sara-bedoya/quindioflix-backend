package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPlanDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePlanDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.PlanMapper;
import co.edu.uniquindio.quindioflixbackend.model.Plan;
import co.edu.uniquindio.quindioflixbackend.repository.PlanRepository;
import co.edu.uniquindio.quindioflixbackend.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;
    private final PlanMapper planMapper;

    public PlanServiceImpl(PlanRepository planRepository, PlanMapper planMapper) {
        this.planRepository = planRepository;
        this.planMapper = planMapper;
    }

    @Override
    public ResponsePlanDTO crearPlan(RequestPlanDTO dto) {
        Plan plan = planRepository.save(planMapper.toEntity(dto));
        return planMapper.toDTO(plan);
    }

    @Override
    public ResponsePlanDTO obtenerPlan(Long idPlan) {
        return planMapper.toDTO(buscarPlan(idPlan));
    }

    @Override
    public List<ResponsePlanDTO> listarPlanes() {
        return planRepository.findAll().stream().map(planMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ResponsePlanDTO actualizarPlan(Long idPlan, RequestPlanDTO dto) {
        Plan plan = buscarPlan(idPlan);
        plan.setNombre(dto.getNombre());
        plan.setMaxPantallas(dto.getMaxPantallas());
        plan.setCalidadVideo(dto.getCalidadVideo());
        plan.setPrecioMensual(dto.getPrecioMensual());
        plan.setMaxPerfiles(dto.getMaxPerfiles());
        return planMapper.toDTO(planRepository.save(plan));
    }

    @Override
    public void eliminarPlan(Long idPlan) {
        planRepository.delete(buscarPlan(idPlan));
    }

    private Plan buscarPlan(Long idPlan) {
        return planRepository.findById(idPlan)
                .orElseThrow(() -> new RuntimeException("No existe plan con id " + idPlan));
    }
}
