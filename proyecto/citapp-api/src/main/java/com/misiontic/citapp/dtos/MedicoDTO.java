package com.misiontic.citapp.dtos;


import com.misiontic.citapp.entity.Usuario;

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
public class MedicoDTO {
	
	private Long idMedico;
	private Usuario idUsuario;
	private String especialidad;
	private String jornada;

}
