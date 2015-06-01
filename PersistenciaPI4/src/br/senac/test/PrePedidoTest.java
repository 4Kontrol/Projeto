/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.test;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Hours;

import br.senac.model.EAO.impl.ClienteEAOImpl;
import br.senac.model.EAO.impl.PrePedidoEAOImpl;
import br.senac.model.EAO.impl.VeiculoEAOImpl;
import br.senac.model.entidades.PrePedido;

/**
 *
 * @author Geovan
 */
public class PrePedidoTest {

    public static void main(String[] args) {
        testaInsere();
        
    }
    public static void testaInsere (){
    	
    	PrePedidoEAOImpl prePedidoEAOImpl = new PrePedidoEAOImpl();
    	ClienteEAOImpl clienteEAOImpl = new ClienteEAOImpl();
    	VeiculoEAOImpl veiculoEAOImpl = new VeiculoEAOImpl();    	
    	PrePedido prePedido = new PrePedido(clienteEAOImpl.getCliente(2),veiculoEAOImpl.getVeiculo(2));
    	
    	prePedidoEAOImpl.registrarPrePedido(prePedido);
    }
    
    public static void testaBusca(){
    	
    	PrePedidoEAOImpl prePedidoEAOImpl = new PrePedidoEAOImpl();
    	PrePedido prePedido = new PrePedido();
    	prePedido = prePedidoEAOImpl.getPrePedido(1);
    	Calendar c = Calendar.getInstance();
    	Date agora = new Date();
    	//c = (agora - prePedido.getDataEmissaoPedido());
    	
    	DateTime dataInicial = new DateTime(agora);
    	DateTime dataFinal = new DateTime(prePedido.getDataEmissaoPedido());
    	
    	System.out.println("ID: "+prePedido.getId());
    	System.out.println("Horas: "+Hours.hoursBetween(dataFinal,dataInicial).getHours());
    	System.out.println("Carro: "+prePedido.getVeiculo().getModelo());
    	System.out.println("Cliente: "+prePedido.getCliente().getNome());
    	
    }
}
