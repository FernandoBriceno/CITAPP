package com.misiontic.citapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="usuarios")
public class Usuario {
	@Id
	@Column(name="idusuario", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(name="idrol", nullable=false)
	private Long idRol;
	
	@Column(name="clave", nullable=false, length=20)
	private String clave;
	
	@Column(name="identificacion", nullable=false)
	private Long identificacion;
	
	@Column(name="nombreusuario", nullable=false, length=200)
	private String nombreUsuario;
	
	@Column(name="direccion", nullable=false, length=200)
	private String direccion;
	
	@Column(name="telefono", nullable=false)
	private Long telefono;
	
	@Column(name="correo", nullable=false, length=200)
	private String correo;
	


}
