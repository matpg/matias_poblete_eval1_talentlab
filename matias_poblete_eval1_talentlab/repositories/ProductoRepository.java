package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
	//plantilla
	//interaccion con la base de datos
	//metodos que heredamos de otras clases (crud y java)
	List<Producto> findAll();

}
