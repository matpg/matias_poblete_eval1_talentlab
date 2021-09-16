package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	//logica de negocio o empresarial
	
	@Autowired
	private UsuarioRepository uR; //dependencia de servicio

	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return uR.findAll();
	}

	public Usuario crearUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		return uR.save(usuario);
	}

	public Usuario buscarUsuario(Long id) {
		// TODO Auto-generated method stub
		Optional<Usuario> oUsuario = uR.findById(id);
		if(oUsuario.isPresent()) {
			return oUsuario.get();
		}
		return null;
	}

	public void modificarUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		uR.save(usuario);
		
	}

	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		uR.deleteById(id);
	}

}
