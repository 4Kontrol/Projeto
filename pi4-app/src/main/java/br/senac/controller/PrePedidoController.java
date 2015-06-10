package br.senac.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senac.model.entidades.Acessorio;
import br.senac.model.entidades.Cliente;
import br.senac.model.entidades.Endereco;
import br.senac.model.entidades.KitAcessorio;
import br.senac.model.entidades.PrePedido;
import br.senac.model.entidades.Veiculo;
import br.senac.service.AcessorioService;
import br.senac.service.KitService;
import br.senac.service.PrePedidosService;
import br.senac.service.VeiculoService;

@Controller
public class PrePedidoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private KitService kitService;
	
	@Autowired
	private AcessorioService acessorioService;
	
	@Autowired
	private PrePedidosService prePedidoService;
	
	@RequestMapping("/quiosque/iniciar")
	public String inicar(){
		return "quiosque/iniciar";
	}
	
	@RequestMapping("/quiosque/veiculos")
	public String listarVeiculos(Model model, HttpSession httpSession){
		
		List <Veiculo> lista = veiculoService.getLista();
		httpSession.setAttribute("veiculosSessao", lista);
		model.addAttribute("veiculos",lista);
		return "quiosque/escolhaCarro";
	}
	
	@RequestMapping("/quiosque/detalhes/{id}")
	public String detalharVeiculo(@PathVariable("id") Integer id, Model model, HttpSession httpSession){
		
		Veiculo veiculo = veiculoService.getVeiculo(id);
		model.addAttribute("veiculo", veiculo);
		httpSession.setAttribute("veiculoSessao", veiculo);
		return "quiosque/detalhesCarro";
	}
	
	@RequestMapping("/quiosque/selecaoKit")
	public String selecionarKit(Model model, HttpSession httpSession){		
		List<KitAcessorio> kits = kitService.getLista();
		
		model.addAttribute("kits",kits);
				
		return "quiosque/escolhaKit";
	}
	
	@RequestMapping("quiosque/selecaoAcessorios/{id}")
	public String adicionarAcessorio(Model model, HttpSession httpSession, @PathVariable("id") Integer id){
		PrePedido prePedido = new PrePedido();
		KitAcessorio kitAcessorio = kitService.getKitAcessorio(id);
		prePedido.setKitDeAcessorios(kitAcessorio);
		Veiculo veiculo = (Veiculo)httpSession.getAttribute("veiculoSessao");
		prePedido.setVeiculo(veiculo);
		Date data = new Date();
		prePedido.setDataEmissaoPedido(data);
		
		List<Acessorio> acessorios = acessorioService.getLista();
		
		
		for(Acessorio a: kitAcessorio.getItensDoKit()){
			for(int i = 0; i < acessorios.size(); i++){
				if(a.getId() == acessorios.get(i).getId()){
					acessorios.remove(i);
				}
			}
		}
		
		httpSession.setAttribute("prePedidoSessao", prePedido);
		model.addAttribute("acessorios",acessorios);		
		
		return "quiosque/escolhaAcessorios";
	}
	
	@RequestMapping("quiosque/exibirPrePedido")
	public String exibirPrePedido(Model model, HttpSession httpSession, String[] acessorio){
		
		PrePedido prePedido = (PrePedido) httpSession.getAttribute("prePedidoSessao");
		
		prePedido.setListaDeAcessorios(new ArrayList<Acessorio>());
		for(String id : acessorio){
			prePedido.getListaDeAcessorios().add(acessorioService.getAcessorio(Integer.valueOf(id)));
		}
		prePedido.setPreco(calcularTotal(prePedido));
		httpSession.setAttribute("prePedidoSessao", prePedido);
		
		model.addAttribute("prePedido",prePedido);
		model.addAttribute("kit",prePedido.getKitDeAcessorios());
		model.addAttribute("acessorios",prePedido.getListaDeAcessorios());
		model.addAttribute("veiculo",prePedido.getVeiculo());
		
		return "quiosque/prePedido";
	}
	
	@RequestMapping("quiosque/cadastrarCliente")
	public String efetivarPrepedido(Model model, HttpSession session){

		return "quiosque/cliente";
	}
	
	@RequestMapping("quiosque/finalizarPrepedido")
	public String finalizarPrepedido(Model model, HttpSession session, Cliente cliente, Endereco endereco){
		cliente.setEndereco(endereco);
		PrePedido prePedido = (PrePedido) session.getAttribute("prePedidoSessao");
		
		
		prePedido.setCliente(cliente);
		
		prePedidoService.gerar(prePedido);
		
		model.addAttribute("prePedido",prePedido);
		model.addAttribute("kit",prePedido.getKitDeAcessorios());
		model.addAttribute("acessorios",prePedido.getListaDeAcessorios());
		model.addAttribute("veiculo",prePedido.getVeiculo());
		model.addAttribute("cliente", cliente);
		
		
		//mudar para tela que exibi todo o prepedido agora com as informações do cliente e com botão de imprimir e de inicio
		return "quiosque/imprimir";
	}
	
	private static Double calcularTotal(PrePedido prePedido){
		Double total = 0D;
		for(Acessorio a : prePedido.getListaDeAcessorios()){
			total = total + a.getPreco();
		}
		total = total + prePedido.getKitDeAcessorios().getPreco();
		total = total + prePedido.getVeiculo().getPreco();
		return total;
	}
	
	@RequestMapping("quiosque/concessionaria/listarPedidos/{id}")
	public String listaPedidos(@PathVariable("id") Integer id,Model model){
		
		model.addAttribute("prePedidos",prePedidoService.getPedidosEmAbertoConcessionaria(id));
		
		return "quisosque/listarPedidos";
	}
	
}
