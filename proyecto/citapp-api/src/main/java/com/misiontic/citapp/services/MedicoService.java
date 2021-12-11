package com.misiontic.citapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.misiontic.citapp.entity.Medico;
import com.misiontic.citapp.exceptions.GeneralServiceException;
import com.misiontic.citapp.exceptions.NoDataFoundException;
import com.misiontic.citapp.exceptions.ValidateServiceException;
import com.misiontic.citapp.repository.MedicoRepository;
import com.misiontic.citapp.validardatos.MedicoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepo;
	
	
	public List<Medico> findAll(){

		try {
			//
			List<Medico> arregloMedicos = medicoRepo.findAll();
			return arregloMedicos;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	public Medico finById(Long medicoId){

		try {
			//
			Medico objMedico = medicoRepo.findById(medicoId)
					.orElseThrow(() -> new NoDataFoundException("no existe el medico con ese id"));
			return objMedico;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	@Transactional
	public Medico create( Medico medico) {

		try {
			//
			MedicoValidator.validador(medico);
			Medico nuevoMedico = medicoRepo.save(medico);
			return nuevoMedico;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
		
	}
	
	@Transactional
	public Medico update (Medico medico){

		try {
			//
			MedicoValidator.validador(medico);
			
			Medico objMedico = medicoRepo.findById(medico.getIdMedico())
					.orElseThrow(() -> new NoDataFoundException("no existe el medico con ese id"));
			
			
			objMedico.setEspecialidad(medico.getEspecialidad());
			objMedico.setJornada(medico.getJornada());
			medicoRepo.save(objMedico);
			return objMedico;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		

	}
	
	@Transactional
	public void  delete( Long medicoId) {

		try {
			//
			Medico objMedico = medicoRepo.findById(medicoId)
					.orElseThrow(() -> new NoDataFoundException("no existe el medico con ese id"));
			
			medicoRepo.delete(objMedico);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
		
	}
	

}
