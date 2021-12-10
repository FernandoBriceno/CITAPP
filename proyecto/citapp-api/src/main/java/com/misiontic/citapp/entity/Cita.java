package com.misiontic.citapp.entity;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name ="citas" )
public class Cita{
	
	@Id
	@Column(name = "idcita", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idmedico", nullable = false, updatable = false, referencedColumnName = "idmedico")
	private Medico idMedico;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idusuario", nullable = false, updatable = false, referencedColumnName = "idusuario")
	private Usuario idUsuario;
	
	
	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;
	
	@Column(name = "hora", nullable = false)
	private Time hora;
	
	@Column(name = "consultorio", nullable = false)
	private Long consultorio;
	
	@Column(name = "consulta", nullable = false, length =1000 )
	private String consulta;
	
	@Column(name = "diagnostico", nullable = false, length =1000)
	private String diagnostico;
	
	@Column(name = "tratamiento", nullable = false, length = 1000)
	private String tratamiento;
	
	@Column(name = "estado", nullable = false, length =1)
	private String estado;	
}