package br.senac.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.model.entidades.Acessorio;
import br.senac.service.AcessorioService;


@Controller
public class AcessorioController {
	
	@Autowired
	private AcessorioService service;
	
	@RequestMapping("/acessorio/efetivarCadastro")
	public String cadastrar(Model model, Acessorio acessorio){
		
		service.cadastrar(acessorio);
		model.addAttribute("acessorios", service.getLista());
		
		return "acessorio/listar";
	}
	
	@RequestMapping("/acessorio/abrirFormulario")
	public String abrirForm(){
		
		return "acessorio/formulario";
	}
	
	@RequestMapping("/acessorio/listar")
	public String abrirLista(Model model){
		
		model.addAttribute("acessorios", service.getLista());
		
		return "acessorio/listar";
	}
	
	@RequestMapping("/acessorio/abrirFormulario/{id}")
	public String editar(Model model, @PathVariable("id") Long id, HttpSession session){
		
		Acessorio acessorio = service.getAcessorio(id);
		
		session.setAttribute("acessorioSessao", acessorio);
		model.addAttribute("acessorio", acessorio);
		
		return "acessorio/formulario";
	
	}
	
	@RequestMapping(value = "/acessorio/efetivarEdicao")
	public String confirmarEdicao(Model model, Acessorio acessorio, HttpSession session){

		Acessorio acessorioRecuperado = (Acessorio)session.getAttribute("acessorioSessao");
		
		
		acessorio.setId(acessorioRecuperado.getId());
		service.editar(acessorio);
		model.addAttribute("acessorios", service.getLista());
		
		return "acessorio/listar";
	}

}
