package com.example.demo.daoImpl;


import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.RolDao;
import com.example.demo.login.Entity.Rol;
import com.example.demo.login.Repository.RolRepository;


@Component
public class RolDaoImpl implements RolDao {

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public Rol create(Rol c) {
		// TODO Auto-generated method stub
		return rolRepository.save(c);
	}

	@Override
	public Rol update(Rol c) {
		// TODO Auto-generated method stub
		return rolRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		rolRepository.deleteById(id);
	}

	@Override
	public Rol read(Long id) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id).get();
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

}

