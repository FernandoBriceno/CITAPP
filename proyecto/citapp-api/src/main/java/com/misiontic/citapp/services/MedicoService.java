package com.misiontic.citapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.misiontic.citapp.entity.Medico;
import com.misiontic.citapp.exceptions.NoDataFoundException;
import com.misiontic.citapp.repository.MedicoRepository;
import com.misiontic.citapp.validardatos.MedicoValidator;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepo;
	
	
	public List<Medico> findAll(){
		List<Medico> arregloMedicos = medicoRepo.findAll();
		return arregloMedicos;
	}
	
	public Medico finById(Long medicoId){
		Medico objMedico = medicoRepo.findById(medicoId)
				.orElseThrow(() -> new NoDataFoundException("no existe el medico con ese id"));
		return objMedico;
	}
	
	@Transactional
	public Medico create( Medico medico) {
		MedicoValidator.validador(medico);
		Medico nuevoMedico = medicoRepo.save(medico);
		return nuevoMedico;
		
	}
	
	@Transactional
	public Medico update (Medico medico){
		MedicoValidator.validador(medico);
		
		Medico objMedico = medicoRepo.findById(medico.getIdMedico())
				.orElseThrow(() -> new NoDataFoundException("no existe el medico con ese id"));
		
		
		objMedico.setEspecialidad(medico.getEspecialidad());
		objMedico.setJornada(medico.getJornada());
		medicoRepo.save(objMedico);
		return objMedico;

	}
	
	@Transactional
	public void  delete( Long medicoId) {
		Medico objMedico = medicoRepo.findById(medicoId)
				.orElseThrow(() -> new NoDataFoundException("no existe el medico con ese id"));
		
		medicoRepo.delete(objMedico);
		
	}
	

}
