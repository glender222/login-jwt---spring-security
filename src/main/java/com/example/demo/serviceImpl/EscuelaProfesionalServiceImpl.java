package com.example.demo.serviceImpl;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EscuelaProfesionalDao;
import com.example.demo.entity.EscuelaProfesional;
import com.example.demo.service.EscuelaProfesionalService;


@Service
public class EscuelaProfesionalServiceImpl implements EscuelaProfesionalService {

	@Autowired
	private EscuelaProfesionalDao dao;
	
	@Override
	public EscuelaProfesional create(EscuelaProfesional c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public EscuelaProfesional update(EscuelaProfesional c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public EscuelaProfesional read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<EscuelaProfesional> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
