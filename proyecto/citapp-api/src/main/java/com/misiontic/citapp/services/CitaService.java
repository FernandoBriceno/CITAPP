package com.misiontic.citapp.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.citapp.entity.Cita;
import com.misiontic.citapp.exceptions.GeneralServiceException;
import com.misiontic.citapp.exceptions.NoDataFoundException;
import com.misiontic.citapp.exceptions.ValidateServiceException;
import com.misiontic.citapp.repository.CitaRepository;
import com.misiontic.citapp.validardatos.CitaValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CitaService {
	@Autowired
	private CitaRepository citaRepo;
	
	public List<Cita> findAll(){

		try {
			//
			List<Cita> arregloCita = citaRepo.findAll();
			return arregloCita;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	public Cita finById(Long citaId) {

		try {
			//
			Cita objCita = citaRepo.findById(citaId)
					.orElseThrow(()-> new NoDataFoundException(" No existe ninguna Cita con dicha identificación"));
			return objCita;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	
	@Transactional
	public Cita create(Cita cita) {

		try {
			//
			CitaValidator.validar(cita); 
			Cita nuevaCita = citaRepo.save(cita);
			return nuevaCita;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	@Transactional
	public Cita update(Cita cita) {

		try {
			//
			CitaValidator.validar(cita); 
			
			Cita objCita = citaRepo.findById(cita.getIdCita())
					.orElseThrow(() -> new NoDataFoundException("No existe una cita con dicha identificacion"));
			
			objCita.setIdMedico(cita.getIdMedico());
			objCita.setFecha(cita.getFecha());
			objCita.setHora(cita.getHora());
			objCita.setConsulta(cita.getConsulta());
			objCita.setConsultorio(cita.getConsultorio());
			objCita.setDiagnostico(cita.getDiagnostico());
			objCita.setTratamiento(cita.getTratamiento());
			objCita.setEstado(cita.getEstado());
			return objCita;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	
	@Transactional
	public void delete ( Long citaId ) {

		try {
			//
			Cita objCita = citaRepo.findById(citaId)
					.orElseThrow(()-> new NoDataFoundException("No existe una cita con dicha identificacion"));
			citaRepo.delete(objCita);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	
	
	
	
}