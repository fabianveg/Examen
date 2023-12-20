package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Tipo_pokemon;

public interface TipoPokemonRepo extends JpaRepository<Tipo_pokemon, Integer> {

}
