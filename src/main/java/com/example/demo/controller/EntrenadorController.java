package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Entrenador;
import com.example.demo.repository.EntrenadorRepo;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
	
	@Autowired
	EntrenadorRepo repo;

	@PostMapping("/login")
	public String login(@PathVariable String email) {
		Optional<Entrenador> entrenador = repo.findByEmail(email);
		
		if(entrenador.isPresent()) {
			if(entrenador.get().getEmail().equals(email)) {
				
				return entrenador.get().getUuid();
				
			}
		}
		
		return null;
		
	}
}
