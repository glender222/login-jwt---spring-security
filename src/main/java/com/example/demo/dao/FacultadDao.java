package com.example.demo.dao;

import java.util.List;


import com.example.demo.entity.Facultad;


public interface FacultadDao {
	Facultad create(Facultad c);
	Facultad update(Facultad c);
	void delete(Long id);
	Facultad read(Long id);
	List<Facultad> readAll();
}
