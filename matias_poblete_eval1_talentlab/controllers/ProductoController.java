package com.everis.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService pS; //dependencia de servicio
	
	//Ejemplo de pasar una entidad completa al JSP
	@RequestMapping("")
	public String index(Model model, @ModelAttribute("producto") Producto producto) {
		System.out.println("Index");
		List<Producto> lista_productos = pS.findAll();
		model.addAttribute("lista_productos", lista_productos);
		return "producto.jsp";
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid Model model, @ModelAttribute("producto") Producto producto) {
		System.out.println("Crear producto: " + producto.getNombre());
		//Llamada a guardar el objeto/entidad
		Producto productoGuardado = pS.crearProducto(producto);
		return "redirect:/producto"; //redirect reenvia hacia una ruta particular
	}
	
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("Actualizar id: " + id);
		Producto producto = pS.buscarProducto(id);
		model.addAttribute("producto", producto);
		return "editar_producto.jsp";
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("producto") Producto producto) {
		pS.modificarProducto(producto);
		System.out.println("Modificar id de producto: " + producto.getId());
		return "redirect:/producto";
	}
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long id) {
		System.out.println("Eliminar id: " + id);
		pS.eliminarProducto(id);
		return "redirect:/producto";
	}

}
