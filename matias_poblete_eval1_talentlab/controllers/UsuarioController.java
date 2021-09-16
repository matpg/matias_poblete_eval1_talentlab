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

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService uS; //dependencia de servicio
	
	//Ejemplo de pasar una entidad completa al JSP
	@RequestMapping("")
	public String index(Model model, @ModelAttribute("usuario") Usuario usuario) {
		System.out.println("Index");
		List<Usuario> lista_usuarios = uS.findAll();
		model.addAttribute("lista_usuarios", lista_usuarios);
		return "usuario.jsp";
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid Model model, @ModelAttribute("usuario") Usuario usuario) {
		System.out.println("Crear usuario: " + usuario.getNombre());
		//Llamada a guardar el objeto/entidad
		Usuario usuarioGuardado = uS.crearUsuario(usuario);
		return "redirect:/usuario"; //redirect reenvia hacia una ruta particular
	}
	
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("Actualizar id: " + id);
		Usuario usuario = uS.buscarUsuario(id);
		model.addAttribute("usuario", usuario);
		return "editar_usuario.jsp";
	}
	
	@RequestMapping(value = "/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario) {
		uS.modificarUsuario(usuario);
		System.out.println("Modificar id de usuario: " + usuario.getId());
		return "redirect:/usuario";
	}
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long id) {
		System.out.println("Eliminar id: " + id);
		uS.eliminarUsuario(id);
		return "redirect:/usuario";
	}

}
