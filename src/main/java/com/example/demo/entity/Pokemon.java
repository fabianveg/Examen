package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Pokemon {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	private int tipoPokemon;
	
	private String fechaDescubrimiento;
	
	private int generacion;
	
	private String uuid;
	
	@ManyToOne
	@JoinColumn(name = "entrenador_id")
	private Entrenador entrenador;

}
