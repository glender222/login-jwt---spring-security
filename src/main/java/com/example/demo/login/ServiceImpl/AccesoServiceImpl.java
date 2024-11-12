package com.example.demo.login.ServiceImpl;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccesoDao;
import com.example.demo.login.Entity.Acceso;
import com.example.demo.login.service.AccesoService;


@Service
public class AccesoServiceImpl implements AccesoService {

	@Autowired
	private AccesoDao dao;
	
	@Override
	public Acceso create(Acceso c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Acceso update(Acceso c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Acceso read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Acceso> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
