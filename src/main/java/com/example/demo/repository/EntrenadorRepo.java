package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Entrenador;

public interface EntrenadorRepo extends JpaRepository<Entrenador, Integer> {
	
	public Optional<Entrenador> findByEmail(String email);

}
