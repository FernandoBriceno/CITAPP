package com.misiontic.citapp.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.citapp.entity.Cita;
import com.misiontic.citapp.repository.CitaRepository;
import com.misiontic.citapp.validardatos.CitaValidator;

@Service
public class CitaService {
	@Autowired
	private CitaRepository citaRepo;
	
	public List<Cita> findAll(){
		List<Cita> arregloCita = citaRepo.findAll();
		return arregloCita;
	}
	
	public Cita finById(Long citaId) {
		Cita objCita = citaRepo.findById(citaId)
				.orElseThrow(()-> new RuntimeException(" No existe ninguna Cita con dicha identificación"));
		return objCita;
	}
	
	
	@Transactional
	public Cita create(Cita cita) {
		CitaValidator.validar(cita); 
		Cita nuevaCita = citaRepo.save(cita);
		return nuevaCita;
	}
	
	@Transactional
	public Cita update(Cita cita) {
		CitaValidator.validar(cita); 
		
		Cita objCita = citaRepo.findById(cita.getIdCita())
				.orElseThrow(() -> new RuntimeException("No existe una cita con dicha identificacion"));
		
		objCita.setIdMedico(cita.getIdMedico());
		objCita.setFecha(cita.getFecha());
		objCita.setHora(cita.getHora());
		objCita.setConsulta(cita.getConsulta());
		objCita.setConsultorio(cita.getConsultorio());
		objCita.setDiagnostico(cita.getDiagnostico());
		objCita.setTratamiento(cita.getTratamiento());
		objCita.setEstado(cita.getEstado());
		return objCita;
	}
	
	
	@Transactional
	public void delete ( Long citaId ) {
		Cita objCita = citaRepo.findById(citaId)
				.orElseThrow(()-> new RuntimeException("No existe una cita con dicha identificacion"));
		citaRepo.delete(objCita);
	}
	
	
	
	
	
}