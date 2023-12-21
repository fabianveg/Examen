package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.util.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Entrenador  {
	
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
	
	
	@ManyToOne
	@JoinColumn(name = "pueblo_id")
	private Pueblo puebloId;
	
	private String uuid;
	

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "captura",
        joinColumns = @JoinColumn(name = "entrenador_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id"))
	  private List<Pokemon> pokemon;

}
