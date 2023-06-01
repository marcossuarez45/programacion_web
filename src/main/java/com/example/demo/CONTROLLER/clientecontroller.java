package com.example.demo.CONTROLLER;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.MODEL.ENTITY.cliente;
import com.example.demo.SERVICE.Iclienteservice;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("cliente")
public class clientecontroller {

	@Autowired
	private Iclienteservice clienteservice;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "listado de clientes");
		model.addAttribute("clientes", clienteservice.findAll());
		return "listar";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String,Object>model) {
		
		cliente cliente=new cliente();
		model.put("cliente" , cliente);
		model.put("titulo", "formulario de cliente");
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid cliente cliente, BindingResult result, SessionStatus status, Model model ) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","formulario del cliente");
			return "form";
		}
		
		clienteservice.save(cliente);
		status.setComplete();
		return "redirect:listar";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id")Long id, Map<String,Object> model ) {
		
		cliente cliente=null;
		if(id>0) {
			cliente=clienteservice.findByid(id);
			
		}else {
			return "redirect:/listar";
			
		}
		model.put("cliente", cliente);
		model.put("titulo", "editar cliente");
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id")Long id) {
		
		if(id>0){
			clienteservice.delete(id);
		}
		return "redirect:/listar";
		
	}
	
}
