package com.misiontic.citapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.citapp.entity.Rol;

@RestController
public class RolController {
	
	private List<Rol> arregloRol = new ArrayList<>();
	
	public RolController() {
		for (int c = 0; c <= 10; c++) {
			Rol objRol = new Rol();
			
			objRol.setIdRol(c + 1L);
			objRol.setNombreRol("Rol " +(c + 1));
			
			arregloRol.add(objRol);
		}
	}
	
	@GetMapping(value="/Rol")
	public List<Rol> findAll(){
		return this.arregloRol;
	}
	
	@GetMapping(value="/Rol/{RolId}")
	public Rol findById(@PathVariable ("RolId") Long RolId) {
		for (Rol objRol: this.arregloRol) {
			if(objRol.getIdRol().longValue() == RolId.longValue()) {
				return objRol;
			}
		}
		return null;
	}
	
	@GetMapping(value="/Rol")
	public Rol create(@RequestBody Rol rol) {
		this.arregloRol.add(rol);
		return rol;
	}
	
	@GetMapping(value="/Rol")
	public Rol update(@RequestBody Rol rol) {
		for (Rol objRol : this.arregloRol) {
			if(objRol.getIdRol().longValue() == rol.getIdRol().longValue()) {
				objRol.setNombreRol(rol.getNombreRol());
				return objRol;
			}
		}
		throw new RuntimeException("No existe el Rol con ese Id");	
	}
	
	@GetMapping(value="/Rol/{rolId}")
	public void delete(@PathVariable ("rolId") Long rolId) {
		Rol deleteRol = null;
		for (Rol objRol : this.arregloRol) {
			if(objRol.getIdRol().longValue() == rolId.longValue()) {
				deleteRol = objRol;
				break;
			}
		}
		
		if(deleteRol == null) {
			throw new RuntimeException("No existe el Rol con ese Id");	
		}
		this.arregloRol.remove(deleteRol);
		
	}
	

}
