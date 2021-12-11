package com.misiontic.citapp.converters;

import com.misiontic.citapp.dtos.UsuarioDTO;
import com.misiontic.citapp.entity.Usuario;

public class UsuarioConverter extends AbstractConverter<Usuario, UsuarioDTO>{
	
	@Override
	public UsuarioDTO fromEntity(Usuario entity) {
		return UsuarioDTO.builder()
				.idUsuario(entity.getIdUsuario())
				.idRol(entity.getIdRol())
				.clave(entity.getClave())
				.identificacion(entity.getIdentificacion())
				.nombreUsuario(entity.getNombreUsuario())
				.direccion(entity.getDireccion())
				.telefono(entity.getTelefono())
				.correo(entity.getCorreo())
				.build();
	}

	@Override
	public Usuario fromDTO(UsuarioDTO dto) {
		return Usuario.builder()
				.idUsuario(dto.getIdUsuario())
				.idRol(dto.getIdRol())
				.clave(dto.getClave())
				.identificacion(dto.getIdentificacion())
				.nombreUsuario(dto.getNombreUsuario())
				.direccion(dto.getDireccion())
				.telefono(dto.getTelefono())
				.correo(dto.getCorreo())
				.build();
	}

}
