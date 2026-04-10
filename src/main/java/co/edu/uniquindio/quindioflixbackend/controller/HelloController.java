package co.edu.uniquindio.quindioflixbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/saludo")
    public String saludar() {
        return "¡QuindioFlix Backend funcionando correctamente! 🎬";
    }
}