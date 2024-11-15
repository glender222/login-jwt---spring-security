package com.example.demo.daoImpl;


import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CampusDao;
import com.example.demo.entity.Campus;
import com.example.demo.repository.CampusRepository;


@Component
public class CampusDaoImpl implements CampusDao {

	@Autowired
	private CampusRepository campusRepository;
	
	@Override
	public Campus create(Campus c) {
		// TODO Auto-generated method stub
		return campusRepository.save(c);
	}

	@Override
	public Campus update(Campus c) {
		// TODO Auto-generated method stub
		return campusRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		campusRepository.deleteById(id);
	}

	@Override
	public Campus read(Long id) {
		// TODO Auto-generated method stub
		return campusRepository.findById(id).get();
	}

	@Override
	public List<Campus> readAll() {
		// TODO Auto-generated method stub
		return campusRepository.findAll();
	}

}
