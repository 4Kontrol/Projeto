/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.test;

import br.senac.model.EAO.impl.VeiculoEAOImpl;
import br.senac.model.entidades.Veiculo;

/**
 *
 * @author Geovan
 */
public class VeiculoTest {
    public static void main (String [] args){
        testaInsere();
        testaBusca();
    }
    public static void testaInsere(){
        Veiculo veiculo = new Veiculo();
        VeiculoEAOImpl veiculoEAOImpl = new VeiculoEAOImpl();
        veiculo.setModelo("Celta");
        veiculoEAOImpl.cadastrar(veiculo);
    }
    
    public static void testaBusca(){
        Veiculo veiculo = new Veiculo();
        VeiculoEAOImpl veiculoEAOImpl = new VeiculoEAOImpl();
        veiculo = veiculoEAOImpl.getVeiculo(1);
        System.out.println("Id: "+veiculo.getId());
        System.out.println("Modelo: "+veiculo.getModelo());
    }
            
}
