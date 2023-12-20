package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Entrenador;
import com.example.demo.entity.Pokemon;
import com.example.demo.repository.EntrenadorRepo;
import com.example.demo.repository.PokemonRepo;

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
	
	@GetMapping("/{uuid}/pokemons")
	public List<Pokemon> listarPokemons(@PathVariable String uuid){
		
		Optional<Entrenador> entrenador = repo.findByUuid(uuid);
		
		if(entrenador.isPresent()) {
			return entrenador.get().getPokemons();
		}
		
		return null;
	}
	
	@PostMapping("/{uuid}/pokemons/{uuid_pokemon}")
	public List<Pokemon> agregarPokemons(@PathVariable String uuid, @PathVariable String uuidPokemon){
		
		Optional<Entrenador> entrenador = repo.findByUuid(uuid);
		
		
		if(entrenador.isPresent()) {
			
		}
		
		return null;
	}
	
	@GetMapping("/listar")
	public List<Entrenador> listarEntrenadores(){
		return repo.findAll();
	}
}
