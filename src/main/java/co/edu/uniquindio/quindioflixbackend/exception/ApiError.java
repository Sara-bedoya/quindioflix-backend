package co.edu.uniquindio.quindioflixbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ApiError {

    private String mensaje;

    private LocalDateTime fecha;

    private Integer status;
}