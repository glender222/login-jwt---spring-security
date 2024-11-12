package com.example.demo.dao;

import java.util.List;

import com.example.demo.login.Entity.Usuario;


public interface UsuarioDao {
	Usuario create(Usuario c);
	Usuario update(Usuario c);
	void delete(Long id);
	Usuario read(Long id);
	List<Usuario> readAll();
}