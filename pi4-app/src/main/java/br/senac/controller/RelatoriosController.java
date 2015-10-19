package br.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.service.PrePedidosService;

@Controller
public class RelatoriosController {

	@Autowired
	private PrePedidosService pedidosService;
	
	
	@RequestMapping("relatorios/menu")
	public String menu(){		
		return "relatorios/relatorios";
	}
	
	@RequestMapping("relatorios/idade")
	public String maisConsultadosPorIdade(Model model){
		return "relatorios/porFaixaIdade";
	}
	
	
		
	
}
