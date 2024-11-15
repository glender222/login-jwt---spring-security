package com.example.demo.service;

import java.util.List;
 

import com.example.demo.entity.EscuelaProfesional;


public interface EscuelaProfesionalService {
	EscuelaProfesional create(EscuelaProfesional c);
	EscuelaProfesional update(EscuelaProfesional c);
	void delete(Long id);
	EscuelaProfesional read(Long id);
	List<EscuelaProfesional> readAll();
}