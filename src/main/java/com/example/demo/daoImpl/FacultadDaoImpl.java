package com.example.demo.daoImpl;


import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.FacultadDao;
import com.example.demo.entity.Facultad;
import com.example.demo.repository.FacultadRepository;


@Component
public class FacultadDaoImpl implements FacultadDao {

	@Autowired
	private FacultadRepository facultadRepository;
	
	@Override
	public Facultad create(Facultad c) {
		// TODO Auto-generated method stub
		return facultadRepository.save(c);
	}

	@Override
	public Facultad update(Facultad c) {
		// TODO Auto-generated method stub
		return facultadRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		facultadRepository.deleteById(id);
	}

	@Override
	public Facultad read(Long id) {
		// TODO Auto-generated method stub
		return facultadRepository.findById(id).get();
	}

	@Override
	public List<Facultad> readAll() {
		// TODO Auto-generated method stub
		return facultadRepository.findAll();
	}

}

