package com.misiontic.citapp.converters;

import com.misiontic.citapp.dtos.MedicoDTO;
import com.misiontic.citapp.entity.Medico;

public class MedicoConverter extends AbstractConverter<Medico, MedicoDTO>{

	@Override
	public MedicoDTO fromEntity(Medico entity) {
		return MedicoDTO.builder()
				.idMedico(entity.getIdMedico())
				.idUsuario(entity.getIdUsuario())
				.especialidad(entity.getEspecialidad())
				.jornada(entity.getJornada())
				.build();
	}

	@Override
	public Medico fromDTO(MedicoDTO dto) {
		return Medico.builder()
				.idMedico(dto.getIdMedico())
				.idUsuario(dto.getIdUsuario())
				.especialidad(dto.getEspecialidad())
				.jornada(dto.getJornada())
				.build();
	}

}
