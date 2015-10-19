package br.senac.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import br.senac.model.entidades.Acessorio;
import br.senac.model.entidades.Cliente;
import br.senac.model.entidades.Endereco;
import br.senac.model.entidades.KitAcessorio;
import br.senac.model.entidades.PrePedido;
import br.senac.model.entidades.Veiculo;
import br.senac.service.AcessorioService;
import br.senac.service.ClienteService;
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
	
	@Autowired
	private ClienteService clienteService;
	
	/*abre a página inicial do quiosque*/
	@RequestMapping("")
	public String inicar(){
		return "quiosque/iniciar";
	}
	
	/*
	 * Método que prepara a view com os veículos disponiveis.
	 * */
	@RequestMapping("/quiosque/veiculos")
	public String listarVeiculos(Model model, HttpSession httpSession){
		
		List <Veiculo> lista = veiculoService.getLista();
		httpSession.setAttribute("veiculosSessao", lista);
		model.addAttribute("veiculos",lista);
		return "quiosque/escolhaCarro";
	}
	
	/*
	 * Método responsável por exibir os detalhes do carro selecionado.
	 * */
	@RequestMapping("/quiosque/detalhes/{id}")
	public String detalharVeiculo(@PathVariable("id") Integer id, Model model, HttpSession httpSession){
		
		Veiculo veiculo = veiculoService.getVeiculo(id);
		model.addAttribute("veiculo", veiculo);
		httpSession.setAttribute("veiculoSessao", veiculo);
		return "quiosque/detalhesCarro";
	}
	
	/*
	 * Método que prepara a visualização dos kits de acessórios disponíveis.
	 * */
	@RequestMapping("/quiosque/selecaoKit")
	public String selecionarKit(Model model, HttpSession httpSession){		
		List<KitAcessorio> kits = kitService.getLista();		
		model.addAttribute("kits",kits);				
		return "quiosque/escolhaKit";
	}
	
	/*
	 * Esse método prepara a visualização de acessórios disponíveis, 
	 * removendo os da lista de acessórios a ser exibida os acessórios existentes no kit selecionado.
	 * Nesse momento é criado o objeto de pre pedido.
	 * */
	@RequestMapping("quiosque/selecaoAcessorios/{id}")
	public String adicionarAcessorio(Model model, HttpSession httpSession, @PathVariable("id") Integer id){
		PrePedido prePedido = new PrePedido();		
		KitAcessorio kitAcessorio = kitService.getKitAcessorio(id);		
		prePedido.setKitDeAcessorios(kitAcessorio);
		prePedido.setVeiculo((Veiculo)httpSession.getAttribute("veiculoSessao"));
		prePedido.setDataEmissaoPedido(new Date());		
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
	
	/*
	 * Prepara a visualização do pre pedido para que o usuário confirme os dados.
	 * */
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
	
	/*
	 * Após confirmar os itens no passo anterior o cliente 
	 * deve ser cadastrado todas as vezes por mais que já tenha se cadastrado (Conversar com o professor sobre esse requisito)
	 * */
	@RequestMapping("quiosque/cadastrarCliente")
	public String efetivarPrepedido(Model model, HttpSession session){
		return "quiosque/formCliente";
	}
	
	/*Retorna a view de impressão conforme o requisito
	 * */
	@RequestMapping("quiosque/finalizarPrepedido")
	public String finalizarPrepedido(Model model, HttpSession session, Cliente cliente, Endereco endereco){
		
		PrePedido prePedido = (PrePedido) session.getAttribute("prePedidoSessao");
		
		clienteService.cadastrar(cliente);
		prePedido.setCliente(cliente);		
		prePedidoService.gerar(prePedido);
		
		model.addAttribute("prePedido",prePedido);
		model.addAttribute("kit",prePedido.getKitDeAcessorios());
		model.addAttribute("acessorios",prePedido.getListaDeAcessorios());
		model.addAttribute("veiculo",prePedido.getVeiculo());
		model.addAttribute("cliente", cliente);
		
		return "quiosque/imprimir";
	}
	
	/*
	 * Método utilizado para calcular o valor total do pedido
	 * */
	private static Double calcularTotal(PrePedido prePedido){
		Double total = 0D;
		for(Acessorio a : prePedido.getListaDeAcessorios()){
			total = total + a.getPreco();
		}
		total = total + prePedido.getKitDeAcessorios().getPreco();
		total = total + prePedido.getVeiculo().getPreco();
		return total;
	}
	
	@RequestMapping("quiosque/concessionaria/listarPedidos/{idSelecionado}")
	public String listaPedidos(@PathVariable("idSelecionado") Integer idSelecionado,Model model){		
		model.addAttribute("prePedidos",prePedidoService.getPedidosEmAbertoConcessionaria(1));		
		return "quiosque/listarPedidos";
	}
	
	@RequestMapping("concessionaria/menu")
	public String menuConcessionaria(){
		return "quiosque/concessionariaMenu";
	}
	
	@RequestMapping("quiosque/concessionaria/exibirPrePedido/{id}")
	public String exibirPrePedido(@PathVariable("id") Integer id,Model model){
		PrePedido prePedido = prePedidoService.getPrePedido(id);
		
		model.addAttribute("veiculo",prePedido.getVeiculo());
		model.addAttribute("cliente",prePedido.getCliente());
		model.addAttribute("acessorios",prePedido.getListaDeAcessorios());
		model.addAttribute("kit",prePedido.getKitDeAcessorios());
		model.addAttribute("prePedido",prePedido);
		return "";
	}
	
}
