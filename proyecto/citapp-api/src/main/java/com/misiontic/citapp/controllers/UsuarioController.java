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

import com.misiontic.citapp.converters.UsuarioConverter;
import com.misiontic.citapp.dtos.UsuarioDTO;
import com.misiontic.citapp.entity.Usuario;
import com.misiontic.citapp.services.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	private UsuarioConverter converter = new UsuarioConverter();
	
	@GetMapping(value="/usuarios")  
	public ResponseEntity<List<UsuarioDTO>>  findAll(){
		List<Usuario> arregloUsuarios = usuarioService.findAll();
		List<UsuarioDTO> arregloUsuarioDto = converter.fromEntity(arregloUsuarios);
		return new ResponseEntity<List<UsuarioDTO>>(arregloUsuarioDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/usuarios/{usuarioId}")
	public ResponseEntity<UsuarioDTO> finById(@PathVariable("usuarioId") Long usuarioId){
		Usuario objUsuario = usuarioService.finById(usuarioId);
		UsuarioDTO objUsuarioDto = converter.fromEntity(objUsuario);
		return new ResponseEntity<UsuarioDTO>(objUsuarioDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/usuarios")
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuario) {
		Usuario nuevUsuario = usuarioService.create(converter.fromDTO(usuario));
		UsuarioDTO objUsuarioDto = converter.fromEntity(nuevUsuario);
		return new ResponseEntity<UsuarioDTO>(objUsuarioDto, HttpStatus.CREATED);
		
	}
	
	@PutMapping(value= "/usuarios")
	public  ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuario){
		Usuario objUsuario = usuarioService.update(converter.fromDTO(usuario));
		UsuarioDTO objUsuarioDto = converter.fromEntity(objUsuario);		
		return new ResponseEntity<UsuarioDTO>(objUsuarioDto, HttpStatus.OK);

	}
	
	@DeleteMapping(value= "/usuarios/{usuarioId}")
	public ResponseEntity<Usuario> delete(@PathVariable("usuarioId") Long usuarioId) {
		usuarioService.delete(usuarioId);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	

}
