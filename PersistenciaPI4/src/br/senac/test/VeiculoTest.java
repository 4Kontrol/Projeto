/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.test;

import br.senac.model.EAO.impl.ConcessionariaEAOImpl;
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
        ConcessionariaEAOImpl concessionariaEAOImpl = new ConcessionariaEAOImpl();
        VeiculoEAOImpl veiculoEAOImpl = new VeiculoEAOImpl();
        veiculo.setModelo("Gol");
        veiculo.setAno("2007");
        veiculo.setCambio("Automático");
        veiculo.setCapacidade("5");
        veiculo.setCombustivel("Flex");
        veiculo.setCor("Vermelho");
        veiculo.setEstofado("Prata");
        veiculo.setImagem("207.jpg");
        veiculo.setMarca("Volkswagem");
        veiculo.setPortas(4);
        veiculo.setPotencia("4 cavalos");
        veiculo.setPreco(2000D);
        veiculo.setSom("MP3");
        veiculo.setVelocidade(300);
        veiculo.setConcessionaria(concessionariaEAOImpl.getConssecionaria(2));
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
