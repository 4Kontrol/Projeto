package br.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senac.model.entidades.Concessionaria;
import br.senac.model.entidades.Endereco;
import br.senac.service.ConcessionariaService;
import br.senac.service.impl.ConcessionariaServiceImpl;


@Controller
public class ConcessionariaController {
	
	
	private ConcessionariaService service;
	
	@RequestMapping(value = "/listarConcessionarias")
	public String cadastrar(Model model, Concessionaria concessionaria, Endereco endereco){
		
		service = new ConcessionariaServiceImpl();
		concessionaria.setEndereco(endereco);
		service.cadastrar(concessionaria);
		model.addAttribute("concessionarias", service.getLista());
		
		return "listarConcessionarias";
	}
	
	@RequestMapping("/abrirCadastroConcessionarias")
	public String abrirForm(Model model){
		
		return "formularioConcessionaria";
	}
	
	@RequestMapping("/abrirConcessionarias")
	public String abrirLista(Model model){
		
		service = new ConcessionariaServiceImpl();
		model.addAttribute("concessionarias", service.getLista());
		
		return "listarConcessionarias";
	}
	
	@RequestMapping("/editarConcessionaria/{id}")
	public String editarConcessionaria(Model model, @PathVariable("id") Integer id){
		service = new ConcessionariaServiceImpl();
		
		Concessionaria concessionaria = service.getConssecionaria(id);
		model.addAttribute("concessionaria", concessionaria);
		return "formularioConcessionaria";
	
	}
	
	@RequestMapping(value = "/confirmarEdicao/{id}")
	public String confirmarEdicao(Model model, Concessionaria concessionaria, Endereco endereco, @PathVariable("id") Integer id){
		
		service = new ConcessionariaServiceImpl();
		concessionaria.setId(id);
		concessionaria.setEndereco(endereco);
		service.editar(concessionaria);
		model.addAttribute("concessionarias", service.getLista());
		
		return "listarConcessionarias";
	}

}
