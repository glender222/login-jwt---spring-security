package com.example.demo.login.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.login.Entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
   // Cambia la consulta para usar JOIN FETCH y así cargar los roles del usuario
    @Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.usuario = :usuario")
     Optional<Usuario> findByUsuario(@Param("usuario") String usuario);
}