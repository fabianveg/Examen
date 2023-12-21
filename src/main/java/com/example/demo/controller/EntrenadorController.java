package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Entrenador;
import com.example.demo.entity.Pokemon;
import com.example.demo.repository.EntrenadorRepo;
import com.example.demo.repository.PokemonRepo;
import com.example.demo.util.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
	
	@Autowired
	EntrenadorRepo repo;
	
	@Autowired
	PokemonRepo pokemonRepo;
	


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

	@GetMapping("/{uuid}/pokemons")
	public List<Pokemon> listarPokemons(@PathVariable String uuid){
		
		Optional<Entrenador> entrenador = repo.findByUuid(uuid);
		
		if(entrenador.isPresent()) {
			System.out.println(":)");
			return entrenador.get().getPokemon();
		}
		
		return null;
	}
	
	@PostMapping("/{uuid}/pokemons/{uuidPokemon}")
	public ResponseEntity<?> agregarPokemons(@PathVariable String uuid, @PathVariable String uuidPokemon){
		System.out.println(uuidPokemon);
		Optional<Entrenador> entrenador = repo.findByUuid(uuid);
		Optional<Pokemon> pokemon = pokemonRepo.findByUuid(uuidPokemon);
		
		
		if(entrenador.isPresent() && pokemon.isPresent()) {
			System.out.println("entre");
			Entrenador entrenadorReturn = entrenador.get();
			Pokemon pokemonR = pokemon.get();
			
			for (Pokemon p : entrenadorReturn.getPokemon()) {
	            if (pokemon.equals(pokemonR)) {
	            	return ResponseEntity.badRequest().body(Map.of("error", "true", "message", "Pokémon ya registrado al entrenador"));
	            }else {
	            	entrenadorReturn.getPokemon().add(pokemonR);
	            	pokemonR.getEntrenadores().add(entrenadorReturn);
	            	repo.save(entrenadorReturn);
	            	pokemonRepo.save(pokemonR);
	            	System.out.println("entre");
	            	 return ResponseEntity.ok(entrenadorReturn.getPokemon());
	            }
	            }
		}
		
		return null;
	}
	
	@GetMapping("/listar")
	public List<Entrenador> listarEntrenadores(){

		return repo.findAll();
	}
}
