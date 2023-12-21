package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Entrenador;
import com.example.demo.entity.Pokemon;
import com.example.demo.entity.TipoPokemon;
import com.example.demo.repository.PokemonRepo;
import com.example.demo.repository.TipoPokemonRepo;
import com.example.demo.util.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

	@Autowired
	PokemonRepo repo;
	
	@Autowired
	TipoPokemonRepo tipoPokemonRepo;
	
	
	
	@GetMapping("/{uuid}")
	public List<Pokemon> getByTipo(@PathVariable String uuid){
		Optional<TipoPokemon> tipo = tipoPokemonRepo.findByUuid(uuid);
		System.out.println(tipo.get().toString() + "--------------------------");
		if(tipo.isPresent()) {
			System.out.println(tipo.get().toString());
			return repo.findByTipoPokemon(tipo.get());
			
		}

		return null;
	}
	
	
	
	@PostMapping("/registro")
	public Pokemon registroPokemon(@RequestBody Pokemon pokemon) {
		
		repo.save(pokemon);
		return pokemon;
	}
	
	@GetMapping("/listar")
	public List<Pokemon> listar(){
		return repo.findAll();
	}
	

	@GetMapping("/{uuid}/entrenadores")
	public List<Entrenador> listarEntrenadores(@PathVariable String uuid){
		
		return repo.findByUuid(uuid).get().getEntrenadores();
	}
	
	
}
