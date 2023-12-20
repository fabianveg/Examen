package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Entrenador;
import com.example.demo.entity.Pokemon;
import com.example.demo.entity.TipoPokemon;


public interface PokemonRepo extends JpaRepository<Pokemon, Integer>{
	
	
	
	public Optional<Pokemon> findByUuid(String uuid);
	
	public List<Pokemon> findByTipoPokemon(TipoPokemon tipoPokemon);


}
