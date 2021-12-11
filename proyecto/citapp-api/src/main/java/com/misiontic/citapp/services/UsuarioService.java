package com.misiontic.citapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.misiontic.citapp.entity.Usuario;
import com.misiontic.citapp.exceptions.NoDataFoundException;
import com.misiontic.citapp.repository.UsuarioRepository;
import com.misiontic.citapp.validardatos.UsuarioValidator;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	
	public List<Usuario> findAll(){
		List<Usuario> arregloUsuarios = usuarioRepo.findAll();
		return arregloUsuarios;
	}
	
	public Usuario finById(Long usuarioId){
		Usuario objUsuario = usuarioRepo.findById(usuarioId)
				.orElseThrow(() -> new NoDataFoundException("no existe el usuario con ese id"));
		return objUsuario;
	}
	
	@Transactional
	public Usuario create(Usuario usuario) {
		UsuarioValidator.validador(usuario);
		Usuario nuevoUsuario = usuarioRepo.save(usuario);
		return nuevoUsuario;
		
	}
	
	@Transactional
	public Usuario update(Usuario usuario){
		UsuarioValidator.validador(usuario);
		
		Usuario objUsuario = usuarioRepo.findById(usuario.getIdUsuario())
				.orElseThrow(() -> new NoDataFoundException("no existe el medico con ese id"));
		
		
		objUsuario.setClave(usuario.getClave());
		objUsuario.setCorreo(usuario.getCorreo());
		objUsuario.setDireccion(usuario.getDireccion());
		objUsuario.setIdentificacion(usuario.getIdentificacion());
		objUsuario.setIdRol(usuario.getIdRol());
		objUsuario.setNombreUsuario(usuario.getNombreUsuario());
		objUsuario.setTelefono(usuario.getTelefono());
		usuarioRepo.save(objUsuario);
		return objUsuario;

	}
	
	@Transactional
	public void  delete(Long usuarioId) {
		Usuario objUsuario = usuarioRepo.findById(usuarioId)
				.orElseThrow(() -> new NoDataFoundException("no existe el usuario con ese id"));
		
		usuarioRepo.delete(objUsuario);
		
	}
	
}
