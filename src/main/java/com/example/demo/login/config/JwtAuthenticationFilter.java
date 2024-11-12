package com.example.demo.login.config;

import java.io.IOException;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;



@Component

public class JwtAuthenticationFilter extends OncePerRequestFilter{

    
    private final  JwtTokenProvider jwtTokenProvider;
    
    private final  UserDetailsService userDetailsService;

 // Constructor que recibe JwtTokenProvider y UserDetailsService
 
 public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UserDetailsService userDetailsService) {
     this.jwtTokenProvider = jwtTokenProvider;
     this.userDetailsService = userDetailsService;
 }


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, 
                                    @NonNull HttpServletResponse response, 
                                     @NonNull   FilterChain filterChain)
            throws ServletException, IOException {
          // Excluir la ruta de login del procesamiento del filtro
           String path = request.getServletPath();
            if ("/api/auth/login".equals(path)) {
               filterChain.doFilter(request, response);
                  return;
                  }

        // 1. Extraer el token JWT de la solicitud HTTP
        String token = getJwtFromRequest(request);
        System.out.println("Token recibido en el filtro: " + token);

        // 2. Validar el token y, si es válido, obtener el nombre de usuario
        if (token != null && jwtTokenProvider.validateToken(token)) {
            String username = jwtTokenProvider.getUsernameFromToken(token);
            System.out.println("Token válido. Usuario extraído: " + username);

            // 3. Cargar los detalles del usuario mediante UserDetailsService
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 4. Crear el objeto de autenticación para el contexto de seguridad
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // 5. Establecer el contexto de seguridad con la autenticación
            SecurityContextHolder.getContext().setAuthentication(authToken);
            System.out.println("Autenticación establecida en el contexto de seguridad.");

        }

        // 6. Continuar con el filtro de la cadena de seguridad
        filterChain.doFilter(request, response);
    }

    // Método para extraer el token JWT del encabezado de autorización
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
