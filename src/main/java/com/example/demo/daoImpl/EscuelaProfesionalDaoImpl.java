package com.example.demo.daoImpl;


import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EscuelaProfesionalDao;
import com.example.demo.entity.EscuelaProfesional;
import com.example.demo.repository.EscuelaProfesionalRepository;


@Component
public class EscuelaProfesionalDaoImpl implements EscuelaProfesionalDao {

	@Autowired
	private EscuelaProfesionalRepository escuelaprofesionalRepository;
	
	@Override
	public EscuelaProfesional create(EscuelaProfesional c) {
		// TODO Auto-generated method stub
		return escuelaprofesionalRepository.save(c);
	}

	@Override
	public EscuelaProfesional update(EscuelaProfesional c) {
		// TODO Auto-generated method stub
		return escuelaprofesionalRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		escuelaprofesionalRepository.deleteById(id);
	}

	@Override
	public EscuelaProfesional read(Long id) {
		// TODO Auto-generated method stub
		return escuelaprofesionalRepository.findById(id).get();
	}

	@Override
	public List<EscuelaProfesional> readAll() {
		// TODO Auto-generated method stub
		return escuelaprofesionalRepository.findAll();
	}

}

