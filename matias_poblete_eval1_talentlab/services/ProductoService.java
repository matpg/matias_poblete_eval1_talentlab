package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;

@Service
public class ProductoService {
	
	//logica de negocio o empresarial
	
	@Autowired
	private ProductoRepository pR; //dependencia de servicio

	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}

	public Producto crearProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		return pR.save(producto);
	}

	public Producto buscarProducto(Long id) {
		// TODO Auto-generated method stub
		Optional<Producto> oProducto = pR.findById(id);
		if(oProducto.isPresent()) {
			return oProducto.get();
		}
		return null;
	}

	public void modificarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		pR.save(producto);
		
	}

	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		pR.deleteById(id);
	}


}
