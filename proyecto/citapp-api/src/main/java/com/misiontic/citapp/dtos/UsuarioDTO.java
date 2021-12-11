package com.misiontic.citapp.dtos;

import com.misiontic.citapp.entity.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
	
	private Long idUsuario;
	private Rol idRol;
	private String clave;
	private Long identificacion;
	private String nombreUsuario;
	private String direccion;
	private Long telefono;
	private String correo;

}
