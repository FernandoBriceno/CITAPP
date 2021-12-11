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

import com.misiontic.citapp.converters.CitaConverter;
import com.misiontic.citapp.dtos.CitaDTO;
import com.misiontic.citapp.entity.Cita;
import com.misiontic.citapp.services.CitaService;

@RestController
public class CitaController {
	@Autowired
	private CitaService citaService;
	private CitaConverter converter = new CitaConverter();
	
	@GetMapping(value = "/citas")
	public ResponseEntity<List<CitaDTO>> findAll(){
		List<Cita> arregloCitas = citaService.findAll();
		List<CitaDTO> arregloCitaDto = converter.fromEntity(arregloCitas);
		return new ResponseEntity<List<CitaDTO>>(arregloCitaDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/citas/{citaId}")
	public ResponseEntity<CitaDTO> finById(@PathVariable("citaId") Long citaId){
		Cita objCita = citaService.finById(citaId);
		CitaDTO objCitaDTO = converter.fromEntity(objCita);
		return new ResponseEntity<CitaDTO>(objCitaDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/citas")
	public ResponseEntity<CitaDTO> create(@RequestBody CitaDTO cita){
		Cita nuevaCita = citaService.create(converter.fromDTO(cita));
		CitaDTO objCitaDTO = converter.fromEntity(nuevaCita);
		return new ResponseEntity<CitaDTO>(objCitaDTO, HttpStatus.CREATED);		
	}
	
	@PutMapping(value= "/citas")
	public  ResponseEntity<CitaDTO> update(@RequestBody CitaDTO cita){
		Cita objCita = citaService.update(converter.fromDTO(cita));
		CitaDTO objCitaDTO = converter.fromEntity(objCita);		
		return new ResponseEntity<CitaDTO>(objCitaDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/citas/{citaId}")
	public ResponseEntity<Cita> delete(@PathVariable("citaId") Long citaId) {
		 citaService.delete(citaId);
		return new ResponseEntity(HttpStatus.OK);
	}
		
}