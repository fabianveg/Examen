package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Entrenador;

public interface PokemonRepo extends JpaRepository<PokemonRepo, Integer>{

}