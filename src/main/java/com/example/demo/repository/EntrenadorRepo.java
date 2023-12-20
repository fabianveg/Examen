package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Entrenador;
import com.example.demo.entity.Pokemon;

public interface EntrenadorRepo extends JpaRepository<Entrenador, Integer> {
	
	public Optional<Entrenador> findByEmail(String email);
	
	public Optional<Entrenador> findByUuid(String uuid);

}
