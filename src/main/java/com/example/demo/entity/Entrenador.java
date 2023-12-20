package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name="fecha_vinculacion")
	private Date fechaVinculacion;
	
	@Column(name="pueblo_id")
	private Integer puebloId;
	
	private String uuid;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "entrenador_pokemon", 
        joinColumns = { @JoinColumn(name = "entrenador_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "pokemon_id") }
    )
    private List<Pokemon> pokemons = new ArrayList<>();

}
