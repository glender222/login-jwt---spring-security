package com.example.demo.login.service;

import java.util.List;

import com.example.demo.login.Entity.Usuario;

public interface UsuarioService {
    Usuario create(Usuario c);
	Usuario update(Usuario c);
	void delete(Long id);
	Usuario read(Long id);
	List<Usuario> readAll();
}
