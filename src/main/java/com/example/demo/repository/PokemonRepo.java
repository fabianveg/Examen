package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Entrenador;
import com.example.demo.entity.Pokemon;

public interface PokemonRepo extends JpaRepository<Pokemon, Integer>{
	
	public List<Pokemon> findByTipo(String tipo);

}
