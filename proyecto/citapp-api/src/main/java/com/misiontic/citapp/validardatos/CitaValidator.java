package com.misiontic.citapp.validardatos;



import com.misiontic.citapp.entity.Cita;

public class CitaValidator {
	public static void validar(Cita cita) {
		
		if (cita.getFecha() == null) {
			throw new RuntimeException("Es necesario que se ingrese la Fecha de la cita");
		}
		
		if(cita.getHora() == null) {
			throw new RuntimeException("Es necesario que se ingrese la Hora de la cita");
		}
		
		if(cita.getConsultorio() == null) {
			throw new RuntimeException("Es necesario que se ingrese el Numero del Consultorio de la cita");
		}
		
		if (cita.getConsulta() == null || cita.getConsulta().trim().isEmpty()) {
			throw new RuntimeException("Es necesario que se ingrese los datos De consulta de la cita");
		}
		if (cita.getConsulta().length() > 1000) {
			throw new RuntimeException("Este apartado tiene uan longitud maxima de 1000 caracteres.");
		}
		
		if (cita.getDiagnostico() == null || cita.getDiagnostico().trim().isEmpty()) {
			throw new RuntimeException("Es necesario que se ingrese los datos Del Dignostico de la cita");
		}
		if (cita.getDiagnostico().length() > 1000) {
			throw new RuntimeException("Este apartado tiene uan longitud maxima de 1000 caracteres.");
		}
		
		if (cita.getTratamiento() == null || cita.getTratamiento().trim().isEmpty()) {
			throw new RuntimeException("Es necesario que se ingrese los datos Del Tratamiento del paciente");
		}
		if (cita.getTratamiento().length() > 1000) {
			throw new RuntimeException("Este apartado tiene uan longitud maxima de 1000 caracteres.");
		}
		
		if (cita.getEstado() == null || cita.getEstado().trim().isEmpty()) {
			throw new RuntimeException("Es necesario que se ingrese los datos De estado de la cita");
		}
		if (cita.getEstado().length() > 1) {
			throw new RuntimeException("Este apartado tiene uan longitud maxima de 1 caracteres.");
		}
	}
}