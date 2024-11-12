package com.example.demo.daoImpl;


import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.login.Entity.Usuario;
import com.example.demo.login.Repository.UsuarioRepository;


@Component
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario create(Usuario c) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(c);
	}

	@Override
	public Usuario update(Usuario c) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario read(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

}

