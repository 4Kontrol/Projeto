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

    public void cadastrar(PrePedido prePedido);

    public List<PrePedido> getLista();
    
    

}