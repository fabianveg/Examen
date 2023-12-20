package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pokemon;
import com.example.demo.repository.PokemonRepo;

@RestController
public class PokemonController {

	@Autowired
	PokemonRepo repo;
	
	@GetMapping("/pokemons/{tipo}")
	public List<Pokemon> getByTipo(@PathVariable String tipoPokemon){
		
		List<Pokemon> pokemons = repo.findByTipo(tipoPokemon);
		
		
		
		return pokemons;
	}
	
	
	@PostMapping("/pokemons")
	public Pokemon registroPokemon(@RequestBody Pokemon pokemon) {
		
		repo.save(pokemon);
		return pokemon;
	}
}
