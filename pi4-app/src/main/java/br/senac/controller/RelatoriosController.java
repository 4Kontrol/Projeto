package br.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.service.PrePedidosService;

@Controller
public class RelatoriosController {

	@Autowired
	private PrePedidosService pedidosService;
	
	
	@RequestMapping
	public String maisConsultadosPorFaixaIdade(){		
		return "";
	}
	
}
