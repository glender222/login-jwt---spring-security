package com.example.demo.login.service;

import java.util.List;

import com.example.demo.login.Entity.Acceso;





public interface AccesoService {
	Acceso create(Acceso c);
	Acceso update(Acceso c);
	void delete(Long id);
	Acceso read(Long id);
	List<Acceso> readAll();
}
