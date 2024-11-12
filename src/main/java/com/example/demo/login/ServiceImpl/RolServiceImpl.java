package com.example.demo.login.ServiceImpl;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RolDao;
import com.example.demo.login.Entity.Rol;
import com.example.demo.login.service.RolService;


@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolDao dao;
	
	@Override
	public Rol create(Rol c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Rol update(Rol c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Rol read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
