package com.misiontic.citapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.citapp.entity.Medico;

@RestController
public class MedicoController {
	
	private List<Medico> arregloMedicos = new ArrayList<>();
	
	public MedicoController() {
		for(int c = 0;c <= 10; c++){
			Medico objMedico = new Medico();
			
			objMedico.setIdMedico((c + 1L));
			objMedico.setEspecialidad("especialidad "+ (c + 1));
			objMedico.setJornada("jornada" + (c + 1));
			
			arregloMedicos.add(objMedico);
		}
	}
	
	@GetMapping(value="/medicos")  
	public List<Medico> findAll(){
		return this.arregloMedicos;
	}
	
	@GetMapping(value = "/medicos/{medicoId}")
	public Medico finById(@PathVariable("medicoId") Long medicoId){
		for (Medico objMedico : this.arregloMedicos) {
			if (objMedico.getIdMedico().longValue() == medicoId.longValue()) {
				return objMedico;
			}
			
			 
		}
		return null;
	
	}
	
	@PostMapping(value = "/medicos")
	public Medico create(@RequestBody Medico medico) {
		this.arregloMedicos.add(medico);
		return medico;
		
	}
	
	@PutMapping(value= "/medicos")
	public Medico update(@RequestBody Medico medico){
		for (Medico objMedico : this.arregloMedicos) {
			if (objMedico.getIdMedico().longValue() == medico.getIdMedico().longValue()) {
				objMedico.setEspecialidad(medico.getEspecialidad());
				objMedico.setJornada(medico.getJornada());
				
				return objMedico;
			}
				
			}
		throw new RuntimeException("No existe el medico con ese id");
	}
	
	@DeleteMapping(value= "/medicos/{medicoId}")
	public void delete(@PathVariable("medicoId") Long medicoId) {
		Medico deleteMedico = null;
		
		for(Medico objMedico : this.arregloMedicos) {
			if(objMedico.getIdMedico().longValue() == medicoId.longValue()) {
				deleteMedico = objMedico;
				break;
			}
		}
		
		if(deleteMedico == null) {
			throw new RuntimeException("No existe el medico con ese id");
		}
		this.arregloMedicos.remove(deleteMedico);
		
	}
	

}
