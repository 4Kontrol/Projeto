package br.senac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.senac.model.EAO.PrePedidoEAO;
import br.senac.model.entidades.PrePedido;
import br.senac.service.PrePedidosService;

@Component
public class PrePedidosServiceImpl implements PrePedidosService{

	@Autowired
	private PrePedidoEAO prePedidoEAO;
	
	public List<PrePedido> getLista() {

		return prePedidoEAO.getLista();
	}

	public PrePedido getPrePedido(Integer id) {

		return prePedidoEAO.getPrePedido(id);
	}

	public void gerar(PrePedido prePedido) {

		prePedidoEAO.cadastrar(prePedido);
	}

	public void aprovar(PrePedido prePedido) {
	
		prePedidoEAO.aprovar(prePedido);
	}

	public void reprovar(PrePedido prePedido) {
		
		prePedidoEAO.reprovar(prePedido);
	}

	public List<PrePedido> getPedidosEmAbertoConcessionaria(Integer id) {
		return prePedidoEAO.listarPrePedidosEmAberto(id);		
	}
	
	

}
