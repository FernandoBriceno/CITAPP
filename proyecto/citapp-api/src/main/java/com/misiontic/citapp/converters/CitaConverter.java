package com.misiontic.citapp.converters;

import com.misiontic.citapp.dtos.CitaDTO;
import com.misiontic.citapp.entity.Cita;

public class CitaConverter extends AbstractConverter<Cita, CitaDTO>{
	@Override
	public CitaDTO fromEntity(Cita entity) {
		return CitaDTO.builder()
				.idCita(entity.getIdCita())
				.idMedico(entity.getIdMedico())
				.idUsuario(entity.getIdUsuario())
				.fecha(entity.getFecha())				
				.hora(entity.getHora())
				.consulta(entity.getConsulta())
				.consultorio(entity.getConsultorio())
				.diagnostico(entity.getDiagnostico())
				.tratamiento(entity.getTratamiento())
				.estado(entity.getEstado())
				.build();
	}
	
	@Override
	public Cita fromDTO(CitaDTO dto) {
		return Cita.builder()
				.idCita(dto.getIdCita())
				.idMedico(dto.getIdMedico())
				.idUsuario(dto.getIdUsuario())
				.fecha(dto.getFecha())				
				.hora(dto.getHora())
				.consulta(dto.getConsulta())
				.consultorio(dto.getConsultorio())
				.diagnostico(dto.getDiagnostico())
				.tratamiento(dto.getTratamiento())
				.estado(dto.getEstado())
				.build();
				
	}
}