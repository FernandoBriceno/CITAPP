package com.misiontic.citapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="medicos")
public class Medico {
	
	@Id
	@Column(name="idmedico", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedico;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario", nullable = false, updatable = false, referencedColumnName = "idUsuario")
	private Usuario idUsuario;
	
	@Column(name = "especialidad", nullable = false, length = 200)
	private String especialidad;
	
	@Column(name = "jornada", nullable = false, length = 200)
	private String jornada;
	
	@OneToMany(mappedBy = "idMedico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Citas> listaCitas;

}
