package com.example.demo.dao;

import java.util.List;

import com.example.demo.login.Entity.Acceso;

public interface AccesoDao {
	Acceso create(Acceso c);
	Acceso update(Acceso c);
	void delete(Long id);
	Acceso read(Long id);
	List<Acceso> readAll();
}
