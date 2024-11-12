package com.example.demo.login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.AuthResponseDto;
import com.example.demo.Dto.LoginDto;
import com.example.demo.login.config.JwtTokenProvider;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor

public class AuthController {

@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Endpoint para el inicio de sesión
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        System.out.println("Intentando autenticar al usuario: " + loginDto.getUsuario());
try {
     // Autenticar usuario
     Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
                loginDto.getUsuario(),  // campo de nombre de usuario
                loginDto.getPassword()  // campo de contraseña
        )
);

       
        // Establecer contexto de seguridad
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Generar token JWT
        String token = jwtTokenProvider.generateToken(authentication);

        // Responder con el token
        AuthResponseDto authResponse = new AuthResponseDto(token);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);


} catch (Exception e) {
    System.out.println("Error durante la autenticación: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
       }

    }

}
