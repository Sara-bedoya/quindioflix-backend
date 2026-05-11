package co.edu.uniquindio.quindioflixbackend.service.impl;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestPagoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.request.RequestRenovacionMensualDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponsePagoDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseRenovacionMensualDTO;
import co.edu.uniquindio.quindioflixbackend.mapper.PagoMapper;
import co.edu.uniquindio.quindioflixbackend.model.EstadoCuenta;
import co.edu.uniquindio.quindioflixbackend.model.Pago;
import co.edu.uniquindio.quindioflixbackend.model.Plan;
import co.edu.uniquindio.quindioflixbackend.model.Usuario;
import co.edu.uniquindio.quindioflixbackend.repository.EstadoCuentaRepository;
import co.edu.uniquindio.quindioflixbackend.repository.PagoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.PlanRepository;
import co.edu.uniquindio.quindioflixbackend.repository.ReferidoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.UsuarioRepository;
import co.edu.uniquindio.quindioflixbackend.service.PagoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;
    private final UsuarioRepository usuarioRepository;
    private final PlanRepository planRepository;
    private final EstadoCuentaRepository estadoCuentaRepository;
    private final ReferidoRepository referidoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository,
                           PagoMapper pagoMapper,
                           UsuarioRepository usuarioRepository,
                           PlanRepository planRepository,
                           EstadoCuentaRepository estadoCuentaRepository,
                           ReferidoRepository referidoRepository) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
        this.usuarioRepository = usuarioRepository;
        this.planRepository = planRepository;
        this.estadoCuentaRepository = estadoCuentaRepository;
        this.referidoRepository = referidoRepository;
    }

    @Override
    public ResponsePagoDTO crearPago(RequestPagoDTO dto) {
        Pago pago = pagoRepository.save(pagoMapper.toEntity(dto));
        return pagoMapper.toDTO(pago);
    }

    @Override
    @Transactional
    public ResponseRenovacionMensualDTO renovarMensual(Long idUsuario, RequestRenovacionMensualDTO dto) {
        if (dto.getMetodoPago() == null || dto.getMetodoPago().isBlank()) {
            throw new RuntimeException("El metodo de pago es obligatorio");
        }

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("No existe usuario con id " + idUsuario));

        Plan plan = planRepository.findById(usuario.getIdPlan())
                .orElseThrow(() -> new RuntimeException("No existe plan con id " + usuario.getIdPlan()));

        BigDecimal valorBase = obtenerValorBase(plan);
        BigDecimal descuentoAntiguedad = calcularDescuentoAntiguedad(valorBase, usuario);
        BigDecimal descuentoReferido = calcularDescuentoReferido(valorBase, idUsuario);
        BigDecimal montoFinal = valorBase.subtract(descuentoAntiguedad).subtract(descuentoReferido);
        if (montoFinal.compareTo(BigDecimal.ZERO) < 0) {
            montoFinal = BigDecimal.ZERO;
        }
        montoFinal = montoFinal.setScale(2, RoundingMode.HALF_UP);

        Pago pago = Pago.builder()
                .idUsuario(idUsuario)
                .idPlan(plan.getIdPlan())
                .monto(montoFinal)
                .metodoPago(dto.getMetodoPago())
                .estadoPago("EXITOSO")
                .build();
        pago = pagoRepository.save(pago);

        EstadoCuenta estadoActivo = estadoCuentaRepository.findByDescripcionIgnoreCase("ACTIVO")
                .orElseThrow(() -> new RuntimeException("No existe estado de cuenta ACTIVO"));
        usuario.setIdEstado(estadoActivo.getIdEstado());
        usuario.setFechaUltimoPago(new Date());
        usuarioRepository.save(usuario);

        return ResponseRenovacionMensualDTO.builder()
                .idUsuario(idUsuario)
                .idPlan(plan.getIdPlan())
                .valorBase(valorBase)
                .descuentoAntiguedad(descuentoAntiguedad)
                .descuentoReferido(descuentoReferido)
                .montoFinal(montoFinal)
                .pago(pagoMapper.toDTO(pago))
                .build();
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

    private BigDecimal obtenerValorBase(Plan plan) {
        if (plan.getPrecioMensual() == null) {
            throw new RuntimeException("El plan no tiene precio mensual configurado");
        }
        return plan.getPrecioMensual().setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calcularDescuentoAntiguedad(BigDecimal valorBase, Usuario usuario) {
        if (usuario.getFechaRegistro() == null) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }

        LocalDate fechaRegistro = usuario.getFechaRegistro().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        long meses = ChronoUnit.MONTHS.between(fechaRegistro, LocalDate.now());

        if (meses >= 24) {
            return porcentaje(valorBase, "0.15");
        }
        if (meses >= 12) {
            return porcentaje(valorBase, "0.10");
        }
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calcularDescuentoReferido(BigDecimal valorBase, Long idUsuario) {
        boolean tieneReferidoActivo = referidoRepository.existsByIdUsuarioReferidorAndEstadoIgnoreCase(idUsuario, "ACTIVO")
                || referidoRepository.existsByIdUsuarioReferidoAndEstadoIgnoreCase(idUsuario, "ACTIVO");

        if (!tieneReferidoActivo) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        return porcentaje(valorBase, "0.10");
    }

    private BigDecimal porcentaje(BigDecimal valorBase, String porcentaje) {
        return valorBase.multiply(new BigDecimal(porcentaje)).setScale(2, RoundingMode.HALF_UP);
    }
}
