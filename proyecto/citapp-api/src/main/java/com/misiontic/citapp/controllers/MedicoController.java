package com.misiontic.citapp.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.citapp.converters.MedicoConverter;
import com.misiontic.citapp.dtos.MedicoDTO;
import com.misiontic.citapp.entity.Medico;
import com.misiontic.citapp.services.MedicoService;



@RestController
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	private MedicoConverter converter = new MedicoConverter();
	
	@GetMapping(value="/medicos")  
	public ResponseEntity<List<MedicoDTO>>  findAll(){
		List<Medico> arregloMedicos = medicoService.findAll();
		List<MedicoDTO> arregloMedicoDto = converter.fromEntity(arregloMedicos);
		return new ResponseEntity<List<MedicoDTO>>(arregloMedicoDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/medicos/{medicoId}")
	public ResponseEntity<MedicoDTO> finById(@PathVariable("medicoId") Long medicoId){
		Medico objMedico = medicoService.finById(medicoId);
		MedicoDTO objMedicoDto = converter.fromEntity(objMedico);
		return new ResponseEntity<MedicoDTO>(objMedicoDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/medicos")
	public ResponseEntity<MedicoDTO> create(@RequestBody MedicoDTO medico) {
		Medico nuevoMedico = medicoService.create(converter.fromDTO(medico));
		MedicoDTO objMedicoDto = converter.fromEntity(nuevoMedico);
		return new ResponseEntity<MedicoDTO>(objMedicoDto, HttpStatus.CREATED);
		
	}
	
	@PutMapping(value= "/medicos")
	public  ResponseEntity<MedicoDTO> update(@RequestBody MedicoDTO medico){
		Medico objMedico = medicoService.update(converter.fromDTO(medico));
		MedicoDTO objMedicoDto = converter.fromEntity(objMedico);		
		return new ResponseEntity<MedicoDTO>(objMedicoDto, HttpStatus.OK);

	}
	
	@DeleteMapping(value= "/medicos/{medicoId}")
	public ResponseEntity<Medico> delete(@PathVariable("medicoId") Long medicoId) {
		 medicoService.delete(medicoId);
		return new ResponseEntity(HttpStatus.OK);
	}
	

}

