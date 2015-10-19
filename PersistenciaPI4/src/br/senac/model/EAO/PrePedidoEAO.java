/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.EAO;

import br.senac.model.entidades.PrePedido;

import java.util.List;

/**
 *
 * @author Geovan
 */
public interface PrePedidoEAO {

    public void cadastrar (PrePedido prePedido);

    public List<PrePedido> getLista();
    
    public PrePedido getPrePedido(Integer id);
    
    public boolean deletar (Integer id);
    
	public void aprovar(PrePedido prePedido);
	
	public void reprovar(PrePedido prePedido);
	
	public List<PrePedido> listarPrePedidosEmAberto(Integer id);

}
