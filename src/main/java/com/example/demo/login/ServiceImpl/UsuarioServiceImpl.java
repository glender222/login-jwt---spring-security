package com.example.demo.login.ServiceImpl;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.login.Entity.Usuario;
import com.example.demo.login.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao dao;

	
	@Override
	public Usuario create(Usuario c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Usuario update(Usuario c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Usuario read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
