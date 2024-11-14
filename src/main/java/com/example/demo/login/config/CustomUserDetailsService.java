package com.example.demo.login.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.Entity.Rol;
import com.example.demo.login.Entity.Usuario;
import com.example.demo.login.Repository.UsuarioRepository;
@Service

public class CustomUserDetailsService implements UserDetailsService{

        private final UsuarioRepository usuarioRepository;

        public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
            this.usuarioRepository = usuarioRepository;
        }
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Intentamos cargar al usuario y mostramos un mensaje para depurar

        System.out.println("Intentando cargar usuario con nombre: " + username);


        // Carga el usuario desde la base de datos usando el campo "usuario"
        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> {
                 System.out.println("Usuario no encontrado: " + username);
                 return new UsernameNotFoundException("Usuario no encontrado con el nombre: " + username);
                    });
                    // Verificamos si el usuario fue encontrado y mostramos la información relevante
                    System.out.println("Usuario encontrado: " + usuario.getUsuario() + ", Estado: " + usuario.getEstado());
                    System.out.println("Contraseña almacenada (encriptada): " + usuario.getPassword());
        // Mostrar los roles cargados desde la base de datos
        Set<Rol> roles = usuario.getRoles();
        System.out.println("Roles cargados para el usuario: " + roles);

         // Depurando cada rol individualmente para verificar su estado
         roles.forEach(rol -> {
                System.out.println("Rol en roles: " + rol.getRol() + ", Estado: " + rol.getEstado());
            });

        // Convertimos los roles de Usuario a una colección de GrantedAuthority
        Set<GrantedAuthority> authorities = roles.stream()
                  // Filtra solo los roles activos
                .filter(role -> "A".equals(role.getEstado()))
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRol()))
                .collect(Collectors.toSet());
                
        System.out.println("Roles asignados: " + authorities);


        // Retornamos un UserDetails con el nombre de usuario, contraseña y permisos
        return new org.springframework.security.core.userdetails.User(
                usuario.getUsuario(),    // campo usuario en tu entidad
                usuario.getPassword(),      // campo clave en tu entidad
                authorities
        );

    }



}
