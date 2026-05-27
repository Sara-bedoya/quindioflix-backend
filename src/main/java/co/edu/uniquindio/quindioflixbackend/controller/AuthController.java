package co.edu.uniquindio.quindioflixbackend.controller;

import co.edu.uniquindio.quindioflixbackend.dto.request.RequestEmpleadoLoginDTO;
import co.edu.uniquindio.quindioflixbackend.dto.request.RequestLoginDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseEmpleadoLoginDTO;
import co.edu.uniquindio.quindioflixbackend.dto.response.ResponseLoginDTO;
import co.edu.uniquindio.quindioflixbackend.model.Departamento;
import co.edu.uniquindio.quindioflixbackend.model.Empleado;
import co.edu.uniquindio.quindioflixbackend.model.Usuario;
import co.edu.uniquindio.quindioflixbackend.repository.DepartamentoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.EmpleadoRepository;
import co.edu.uniquindio.quindioflixbackend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.Normalizer;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDTO> login(
            @RequestBody RequestLoginDTO request
    ) {

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail()).orElse(null);
        if (usuario == null) {
            return loginEmpleadoDesdeLoginGeneral(request);
        }

        if (usuario.getPassword() == null || !usuario.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }

        ResponseLoginDTO response = ResponseLoginDTO.builder()
                .idUsuario(usuario.getIdUsuario())
                .nombreCompleto(usuario.getNombreCompleto())
                .email(usuario.getEmail())
                .telefono(usuario.getTelefono())
                .idPlan(usuario.getIdPlan())
                .idCiudad(usuario.getIdCiudad())
                .idEstado(usuario.getIdEstado())
                .rol(usuario.getRol())
                .token("fake-jwt-token")
                .build();

        return ResponseEntity.ok(response);
    }

    private ResponseEntity<ResponseLoginDTO> loginEmpleadoDesdeLoginGeneral(RequestLoginDTO request) {
        Empleado empleado = empleadoRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales invalidas"));

        if (empleado.getPassword() == null || !empleado.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }

        Departamento departamento = departamentoRepository.findById(empleado.getIdDepartamento())
                .orElseThrow(() -> new RuntimeException("El empleado no tiene un departamento valido"));

        ResponseLoginDTO response = ResponseLoginDTO.builder()
                .idUsuario(empleado.getIdEmpleado())
                .nombreCompleto(empleado.getNombreCompleto())
                .email(empleado.getEmail())
                .telefono(empleado.getTelefono())
                .idPlan(0L)
                .idCiudad(0L)
                .idEstado(1L)
                .rol(rolEmpleado(departamento.getNombreDepartamento()))
                .token("fake-employee-jwt-token")
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/empleados/login")
    public ResponseEntity<ResponseEmpleadoLoginDTO> loginEmpleado(@RequestBody RequestEmpleadoLoginDTO request) {
        Empleado empleado = empleadoRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales invalidas"));

        if (empleado.getPassword() == null || !empleado.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }

        Departamento departamento = departamentoRepository.findById(empleado.getIdDepartamento())
                .orElseThrow(() -> new RuntimeException("El empleado no tiene un departamento valido"));

        String nombreDepartamento = departamento.getNombreDepartamento();
        ResponseEmpleadoLoginDTO response = ResponseEmpleadoLoginDTO.builder()
                .idEmpleado(empleado.getIdEmpleado())
                .nombreCompleto(empleado.getNombreCompleto())
                .email(empleado.getEmail())
                .idDepartamento(empleado.getIdDepartamento())
                .nombreDepartamento(nombreDepartamento)
                .cargo(empleado.getCargo())
                .idSupervisor(empleado.getIdSupervisor())
                .rol(rolEmpleado(nombreDepartamento))
                .permisos(permisosEmpleado(nombreDepartamento))
                .token("fake-employee-jwt-token")
                .build();

        return ResponseEntity.ok(response);
    }

    private String rolEmpleado(String nombreDepartamento) {
        String normalizado = normalizar(nombreDepartamento);
        if (esDepartamentoAdminPlataforma(normalizado)) {
            return "ADMIN";
        }
        if (normalizado.contains("contenido")) {
            return "EMPLEADO_CONTENIDO";
        }
        if (normalizado.contains("soporte")) {
            return "EMPLEADO_SOPORTE";
        }
        if (normalizado.contains("analitica")) {
            return "EMPLEADO_ANALITICA";
        }
        return "EMPLEADO";
    }

    private List<String> permisosEmpleado(String nombreDepartamento) {
        String normalizado = normalizar(nombreDepartamento);
        if (esDepartamentoAdminPlataforma(normalizado)) {
            return List.of("ADMIN_PLATAFORMA", "ANALITICA_LEER", "CONTENIDO_LEER", "EMPLEADOS_LEER");
        }
        if (normalizado.contains("contenido")) {
            return List.of("CONTENIDO_LEER", "CONTENIDO_CREAR", "CONTENIDO_EDITAR", "CONTENIDO_ELIMINAR");
        }
        if (normalizado.contains("soporte")) {
            return List.of("REPORTES_LEER", "REPORTES_RESOLVER");
        }
        if (normalizado.contains("analitica")) {
            return List.of("ANALITICA_LEER");
        }
        return List.of("EMPLEADO_LEER");
    }

    private boolean esDepartamentoAdminPlataforma(String normalizado) {
        return normalizado.contains("administracion")
                || normalizado.contains("administrativo")
                || normalizado.equals("admin")
                || normalizado.contains("admin plataforma");
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return "";
        }
        String limpio = Normalizer.normalize(valor.trim().toLowerCase(), Normalizer.Form.NFD);
        return limpio.replaceAll("\\p{M}", "");
    }
}
