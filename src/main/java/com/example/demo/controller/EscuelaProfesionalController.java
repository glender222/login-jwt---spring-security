package com.example.demo.controller;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EscuelaProfesional;
import com.example.demo.service.EscuelaProfesionalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/escuelaprofesionales")
@CrossOrigin(origins = "http://localhost:4200/")
public class EscuelaProfesionalController {
	@Autowired
	private EscuelaProfesionalService escuelaprofesionalService;
	
	@GetMapping
	public ResponseEntity<List<EscuelaProfesional>> readAll(){
		try {
			List<EscuelaProfesional> EscuelaProfesionals = escuelaprofesionalService.readAll();
			if(EscuelaProfesionals.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(EscuelaProfesionals, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping
	public ResponseEntity<EscuelaProfesional> crear(@Valid @RequestBody EscuelaProfesional cat){
		try {
			EscuelaProfesional c = escuelaprofesionalService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<EscuelaProfesional> getEscuelaProfesionalId(@PathVariable("id") Long id){
		try {
			EscuelaProfesional c = escuelaprofesionalService.read(id);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<EscuelaProfesional> delEscuelaProfesional(@PathVariable("id") Long id){
		try {
			escuelaprofesionalService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEscuelaProfesional(@PathVariable("id") Long id, @Valid @RequestBody EscuelaProfesional cat){

			EscuelaProfesional c = escuelaprofesionalService.read(id);
			if(c.getId()>0) {
				return new ResponseEntity<>(escuelaprofesionalService.update(cat), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}		
		
	}
}
