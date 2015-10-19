package br.senac.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import br.senac.model.entidades.Concessionaria;
import br.senac.model.entidades.Endereco;
import br.senac.service.ConcessionariaService;



@Controller
public class ConcessionariaController {
	
	@Autowired
	private ConcessionariaService service;
	
	@RequestMapping(value = "/concessionaria/efetivarCadatro")
	public String cadastrar(Model model, Concessionaria concessionaria, Endereco endereco){
		
		concessionaria.setEndereco(endereco);
		service.cadastrar(concessionaria);
		model.addAttribute("concessionarias", service.getLista());
		
		return "redirect:/concessionaria/listarConcessionarias";
	}
	
	@RequestMapping("/concessionaria/abrirFormulario")
	public String abrirForm(){
		
		return "concessionaria/formularioConcessionaria";
	}
	
	@RequestMapping("/concessionaria/listarConcessionarias")
	public String abrirLista(Model model){
		
		model.addAttribute("concessionarias", service.getLista());
		
		return "concessionaria/listarConcessionarias";
	}
	
	@RequestMapping("/concessionaria/abrirFormulario/{id}")
	public String editarConcessionaria(Model model, @PathVariable("id") Integer id, HttpSession session){
		
		Concessionaria concessionaria = service.getConssecionaria(id);
		
		session.setAttribute("concessionariaSessao", concessionaria);
		model.addAttribute("concessionaria", concessionaria);
		
		return "concessionaria/formularioConcessionaria";
	
	}
	
	@RequestMapping(value = "/concessionaria/efetivarEdicao")
	public String confirmarEdicao(Model model, Concessionaria concessionaria, Endereco endereco, HttpSession session){

		Concessionaria concessionariaRecuperada = (Concessionaria)session.getAttribute("concessionariaSessao");		
		concessionaria.setId(concessionariaRecuperada.getId());
		concessionaria.setEndereco(endereco);
		concessionaria.getEndereco().setId(concessionariaRecuperada.getEndereco().getId());
		service.editar(concessionaria);
		model.addAttribute("concessionarias", service.getLista());		
		return "redirect:/concessionaria/listarConcessionarias";
	}
	
	@RequestMapping("backoffice")
	public String menubackOffice(){
		return "homeBackOffice";
	}
	
	@RequestMapping("/concessionaria/excluir/{id}")
	public String remover(Model model, @PathVariable("id") Integer id,HttpSession httpSession){
		boolean resultado = service.remover(id);
				
		if (resultado){
			return "concessionaria/listarConcessionarias";
		}
		else{
			model.addAttribute("concessionaria", service.getConssecionaria(id));
			return "concessionaria/erro";
		}		
	}
}
