package com.example.demo.login.service;

import java.util.List;

import com.example.demo.login.Entity.Rol;

public interface RolService {
Rol create(Rol c);
	Rol update(Rol c);
	void delete(Long id);
	Rol read(Long id);
	List<Rol> readAll();
}
