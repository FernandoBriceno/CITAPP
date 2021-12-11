package com.misiontic.citapp.dtos;

import java.sql.Time;
import java.time.LocalDate;

import com.misiontic.citapp.entity.Medico;
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

public class CitaDTO {
	
	private Long idCita;
	private Medico idMedico;
	private Usuario idUsuario;
	private LocalDate fecha;
	private Time hora;
	private Long consultorio;
	private String consulta;
	private String diagnostico;
	private String tratamiento;
	private String estado;
	
}