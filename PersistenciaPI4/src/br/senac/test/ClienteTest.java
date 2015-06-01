package br.senac.test;

import br.senac.model.EAO.impl.ClienteEAOImpl;
import br.senac.model.entidades.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geovan
 */
public class ClienteTest {
    public static void main (String [] args){
        testaBusca();
    }
    
    public static void testaInsere(){
        Cliente cliente = new Cliente();
        cliente.setNome("Geovan");
        cliente.setCpf("333");
        ClienteEAOImpl clienteEAOImpl = new ClienteEAOImpl();
        clienteEAOImpl.cadastrar(cliente);
    }
    
    public static void testaBusca(){
        ClienteEAOImpl clienteEAOImpl = new ClienteEAOImpl();
        Cliente cliente = new Cliente();
        cliente = clienteEAOImpl.getCliente(1);
        System.out.println("Id: "+cliente.getId());
        System.out.println("Nome: "+cliente.getNome());
        System.out.println("CPF: "+cliente.getCpf());
    }
}
