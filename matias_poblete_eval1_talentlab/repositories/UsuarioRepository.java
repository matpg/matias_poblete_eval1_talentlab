package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	//plantilla
	//interaccion con la base de datos
	//metodos que heredamos de otras clases (crud y java)
	List<Usuario> findAll();
}
