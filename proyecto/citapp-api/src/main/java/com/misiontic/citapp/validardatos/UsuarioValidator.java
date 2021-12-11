package com.misiontic.citapp.validardatos;

import com.misiontic.citapp.entity.Usuario;
import com.misiontic.citapp.exceptions.ValidateServiceException;

public class UsuarioValidator {
	public static void validador(Usuario usuario) {
			
			if(usuario.getClave() == null || usuario.getClave().trim().isEmpty()) {
				throw new ValidateServiceException("la contraseña es obligatoria");
			}
			
			if(usuario.getClave().length() > 20) {
				throw new ValidateServiceException("la contraseña es muy larga");
			}
			
			
			if(usuario.getCorreo() == null || usuario.getCorreo().trim().isEmpty()) {
				throw new ValidateServiceException("el correo es obligatorio");
			}
			
			if(usuario.getCorreo().length() > 200) {
				throw new ValidateServiceException("el correo es muy largo");
			}
			
			
			
			if(usuario.getDireccion() == null || usuario.getDireccion().trim().isEmpty()) {
				throw new ValidateServiceException("la dirección es obligatoria");
			}
			
			if(usuario.getCorreo().length() > 200) {
				throw new ValidateServiceException("la dirección es muy larga");
			}
			
			
			
			if(usuario.getIdentificacion() == null || usuario.getIdentificacion().toString().trim().isEmpty()) {
				throw new ValidateServiceException("la identificación es obligatoria");
			}
			
			if(usuario.getIdentificacion().toString().length() > 200) {
				throw new ValidateServiceException("la identificación es muy larga");
			}
			
			
			
			if(usuario.getIdRol() == null || usuario.getIdRol().toString().trim().isEmpty()) {
				throw new ValidateServiceException("el rol es obligatorio");
			}
			
			if(usuario.getIdRol().toString().length() > 200) {
				throw new ValidateServiceException("el rol es muy largo");
			}
			
			
			
			if(usuario.getNombreUsuario() == null || usuario.getNombreUsuario().trim().isEmpty()) {
				throw new ValidateServiceException("el Nombre es obligatorio");
			}
			
			if(usuario.getNombreUsuario().length() > 200) {
				throw new ValidateServiceException("el Nombre es muy largo");
			}
			
			
			
			if(usuario.getTelefono() == null || usuario.getTelefono().toString().trim().isEmpty()) {
				throw new ValidateServiceException("el telefono es obligatorio");
			}
			
			if(usuario.getTelefono().toString().length() > 200) {
				throw new ValidateServiceException("el telefono es muy largo");
			}
		}
}
