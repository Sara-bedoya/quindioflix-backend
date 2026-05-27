package co.edu.uniquindio.quindioflixbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEmpleadoLoginDTO {

    private String email;
    private String password;
}
