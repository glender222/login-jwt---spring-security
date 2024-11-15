package com.example.demo.serviceImpl;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CampusDao;
import com.example.demo.entity.Campus;
import com.example.demo.service.CampusService;


@Service
public class CampusServiceImpl implements CampusService {

	@Autowired
	private CampusDao dao;
	
	@Override
	public Campus create(Campus c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Campus update(Campus c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Campus read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Campus> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
