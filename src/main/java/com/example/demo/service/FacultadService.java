package com.example.demo.service;

import java.util.List;
 

import com.example.demo.entity.Facultad;


public interface FacultadService {
	Facultad create(Facultad c);
	Facultad update(Facultad c);
	void delete(Long id);
	Facultad read(Long id);
	List<Facultad> readAll();
}
