package com.misiontic.citapp.validardatos;

import com.misiontic.citapp.entity.Usuario;

public class UsuarioValidator {
	public static void validador(Usuario usuario) {
			
			if(usuario.getClave() == null || usuario.getClave().trim().isEmpty()) {
				throw new RuntimeException("la contraseña es obligatoria");
			}
			
			if(usuario.getClave().length() > 20) {
				throw new RuntimeException("la contraseña es muy larga");
			}
			
			
			
			if(usuario.getCorreo() == null || usuario.getCorreo().trim().isEmpty()) {
				throw new RuntimeException("el correo es obligatorio");
			}
			
			if(usuario.getCorreo().length() > 200) {
				throw new RuntimeException("el correo es muy largo");
			}
			
			
			
			if(usuario.getDireccion() == null || usuario.getDireccion().trim().isEmpty()) {
				throw new RuntimeException("la dirección es obligatoria");
			}
			
			if(usuario.getCorreo().length() > 200) {
				throw new RuntimeException("la dirección es muy larga");
			}
			
			
			
			if(usuario.getIdentificacion() == null || usuario.getIdentificacion().toString().trim().isEmpty()) {
				throw new RuntimeException("la identificación es obligatoria");
			}
			
			if(usuario.getIdentificacion().toString().length() > 200) {
				throw new RuntimeException("la identificación es muy larga");
			}
			
			
			
			if(usuario.getIdRol() == null || usuario.getIdRol().toString().trim().isEmpty()) {
				throw new RuntimeException("el rol es obligatorio");
			}
			
			if(usuario.getIdRol().toString().length() > 200) {
				throw new RuntimeException("el rol es muy largo");
			}
			
			
			
			if(usuario.getNombreUsuario() == null || usuario.getNombreUsuario().trim().isEmpty()) {
				throw new RuntimeException("el Nombre es obligatorio");
			}
			
			if(usuario.getNombreUsuario().length() > 200) {
				throw new RuntimeException("el Nombre es muy largo");
			}
			
			
			
			if(usuario.getTelefono() == null || usuario.getTelefono().toString().trim().isEmpty()) {
				throw new RuntimeException("el telefono es obligatorio");
			}
			
			if(usuario.getTelefono().toString().length() > 200) {
				throw new RuntimeException("el telefono es muy largo");
			}
		}
}
