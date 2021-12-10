package com.misiontic.citapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="roles")
public class Rol {
	
	@Id
	@Column(name="idrol", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;
	
	@Column(name="nombrerol", nullable = false, length = 100)
	private String nombreRol;
	
	@OneToMany(mappedBy = "idRol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Usuario> listaUsuarios;
	
	
}
