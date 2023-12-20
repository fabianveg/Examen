package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Entrenador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String email;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String fechaVinculacion;
	private int puebloId;
	private String uuid;
	
	@OneToMany(mappedBy = "entrenador")
	private List<Pokemon> pokemons;

}
