package br.senac.service;

import java.util.List;

import br.senac.model.entidades.PrePedido;

public interface PrePedidosService {

	public List<PrePedido> getLista();
	
	public PrePedido getPrePedido(Integer id);
	
	public void gerar(PrePedido prePedido);
	
	public void aprovar(PrePedido prePedido);
	
	public void reprovar(PrePedido prePedido);
}
