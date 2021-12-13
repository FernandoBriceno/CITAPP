package com.misiontic.citapp.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.misiontic.citapp.converters.UsuarioConverter;
import com.misiontic.citapp.dtos.LoginRequestDTO;
import com.misiontic.citapp.dtos.LoginResponseDTO;
import com.misiontic.citapp.entity.Usuario;
import com.misiontic.citapp.exceptions.GeneralServiceException;
import com.misiontic.citapp.exceptions.NoDataFoundException;
import com.misiontic.citapp.exceptions.ValidateServiceException;
import com.misiontic.citapp.repository.UsuarioRepository;
import com.misiontic.citapp.validardatos.UsuarioValidator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService {
	
	@Value("${jwt.clave}")
	private String jwtSecret;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	
	private UsuarioConverter converter = new UsuarioConverter();
	
	public List<Usuario> findAll(){
		List<Usuario> arregloUsuarios = usuarioRepo.findAll();
		return arregloUsuarios;
	}
	
	public Usuario finById(Long usuarioId){

		try {
			//
			Usuario objUsuario = usuarioRepo.findById(usuarioId)
					.orElseThrow(() -> new NoDataFoundException("no existe el usuario con ese id"));
			return objUsuario;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	@Transactional
	public Usuario signUp(Usuario usuario) {

		try {
			Usuario existeUsuario = usuarioRepo.findByIdentificacion(usuario.getIdentificacion())
					.orElse(null);
			if(existeUsuario != null) {
				throw new ValidateServiceException("Ya existe un usuario con ese username");
			}
			//
			UsuarioValidator.validador(usuario);
			Usuario nuevoUsuario = usuarioRepo.save(usuario);
			return nuevoUsuario;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
		
	}
	
	@Transactional
	public Usuario create(Usuario usuario) {

		try {
			Usuario existeUsuario = usuarioRepo.findByIdentificacion(usuario.getIdentificacion())
					.orElse(null);
			if(existeUsuario != null) {
				throw new ValidateServiceException("Ya existe un usuario con ese documento de identidad.");
			}
			//
			UsuarioValidator.validador(usuario);
			Usuario nuevoUsuario = usuarioRepo.save(usuario);
			return nuevoUsuario;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
		
	}
	
	
	@Transactional
	public Usuario update(Usuario usuario){

		try {
			//
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
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		

	}
	
	@Transactional
	public void  delete(Long usuarioId) {

		try {
			//
			Usuario objUsuario = usuarioRepo.findById(usuarioId)
					.orElseThrow(() -> new NoDataFoundException("no existe el usuario con ese id"));
			
			usuarioRepo.delete(objUsuario);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
		
	}
	
public LoginResponseDTO login(LoginRequestDTO request) {
		
		try {
			//validar que exista el usuario en la db
			Usuario usuario = usuarioRepo.findByIdentificacion(request.getIdentificacion())
					.orElseThrow(() -> new ValidateServiceException("Documento de identidad o contraseña incorrecta."));
			
			//validar que exista la clave en la db
			if (!usuario.getClave().equals(request.getClave())) {
				throw new ValidateServiceException("Nombre de usuario o contraseña incorrecta.");
			}
			
			//crear token
			String token = createToken(usuario);
			
			return new LoginResponseDTO(converter.fromEntity(usuario), token);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	public String createToken(Usuario usuario) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + (1000 * 60 * 60));
		
		return Jwts.builder()
				.setSubject(usuario.getIdentificacion().toString())
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();	
	}
}
