package com.misiontic.citapp.validardatos;

import com.misiontic.citapp.entity.Medico;
import com.misiontic.citapp.exceptions.ValidateServiceException;

public class MedicoValidator {
	
	public static void validador(Medico medico) {
		
		if(medico.getEspecialidad() == null || medico.getEspecialidad().trim().isEmpty()) {
			throw new ValidateServiceException("la especialidad  del medico es obligatorio");
			
		}
		
		if(medico.getEspecialidad().length() > 200) {
			throw new ValidateServiceException("la especialidad  del medico es muy largo");
		}
		
		if(medico.getJornada() == null || medico.getJornada().trim().isEmpty()) {
			throw new ValidateServiceException("la jornada  del medico es obligatorio");
			
		}
		
		if(medico.getJornada().length() > 200) {
			throw new ValidateServiceException("la jornada  del medico es muy largo");
		}
	}

}
