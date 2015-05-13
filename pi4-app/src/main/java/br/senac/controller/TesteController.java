package br.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.model.entidades.Hospede;
import br.senac.service.TesteService;
import br.senac.service.impl.TesteServiceImpl;

@Controller
public class TesteController {
	
	
	
	
	@RequestMapping("/teste")
	public String teste(){
		
		TesteService t = new TesteServiceImpl();
		Hospede h = new Hospede();
		h.setDocumento("spring");
		h.setDdd(11);
		h.setNome("noem");
		h.setTelefone("5614");
		t.cadastrar(h);
		System.out.println("passou controller");
		return "ok";
	}

}
