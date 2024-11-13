package com.example.demo.login.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class SimpleController {

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/admin")
    public ResponseEntity<String> adminEndpoint() {
        return ResponseEntity.ok("Acceso concedido para ADMINISTRADOR");
    }

    @PreAuthorize("hasAuthority('PRACTICANTE')")
    @GetMapping("/practicante")
    public ResponseEntity<String> practicanteEndpoint() {
        return ResponseEntity.ok("Acceso concedido para PRACTICANTE");
    }

    @PreAuthorize("hasAuthority('SECRETARIA')")
    @GetMapping("/secretaria")
    public ResponseEntity<String> secretariaEndpoint() {
        return ResponseEntity.ok("Acceso concedido para SECRETARIA");
    }

    @PreAuthorize("hasAuthority('COORDINADOR')")
    @GetMapping("/coordinador")
    public ResponseEntity<String> coordinadorEndpoint() {
        return ResponseEntity.ok("Acceso concedido para COORDINADOR");
    }

    @PreAuthorize("hasAuthority('TUTOR_ACADEMICO')")
    @GetMapping("/tutor")
    public ResponseEntity<String> tutorEndpoint() {
        return ResponseEntity.ok("Acceso concedido para TUTOR_ACADEMICO");
    }

    @PreAuthorize("hasAuthority('DIRECTORA')")
    @GetMapping("/directora")
    public ResponseEntity<String> directoraEndpoint() {
        return ResponseEntity.ok("Acceso concedido para DIRECTORA");
    }
}
