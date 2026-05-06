package co.edu.uniquindio.quindioflixbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PAGOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGO")
    private Long idPago;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "ID_PLAN")
    private Long idPlan;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_PAGO", insertable = false, updatable = false)
    private Date fechaPago;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "METODO_PAGO")
    private String metodoPago;

    @Column(name = "ESTADO_PAGO")
    private String estadoPago;
}
