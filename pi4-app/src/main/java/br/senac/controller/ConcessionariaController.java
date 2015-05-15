package br.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senac.model.entidades.Concessionaria;
import br.senac.service.ConcessionariaService;
import br.senac.service.impl.ConcessionariaServiceImpl;


@Controller
public class ConcessionariaController {
	
	
	private ConcessionariaService service;
	
	@RequestMapping(value = "/listarConcessionarias")
	public String cadastrar(Model model, Concessionaria concessionaria){
		
		service = new ConcessionariaServiceImpl();
		service.cadastrar(concessionaria);
		model.addAttribute("concessionarias", service.getLista());
		
		return "listarConcessionarias";
	}
	
	@RequestMapping("/abrirCadastroConcessionarias")
	public String abrirForm(Model model){
		
		return "cadastroConcessionaria";
	}
	
	@RequestMapping("/abrirConcessionarias")
	public String abrirLista(Model model){
		
		service = new ConcessionariaServiceImpl();
		model.addAttribute("concessionarias", service.getLista());
		
		return "listarConcessionarias";
	}

}
