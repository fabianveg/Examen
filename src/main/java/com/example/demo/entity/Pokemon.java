package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Pokemon {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="tipo_pokemon")
	private TipoPokemon tipoPokemon;
	
	@Column(name="fecha_descubrimiento")
	private Date fechaDescubrimiento;
	
	private int generacion;
	
	private String uuid;
	
	@ManyToMany(mappedBy = "pokemons")
    private List<Entrenador> entrenadores = new ArrayList<>();

}
