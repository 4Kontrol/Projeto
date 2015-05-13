/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.test;


import br.senac.model.EAO.impl.HospedesEAO;
import br.senac.model.entidades.Hospede;
import java.util.List;

/**
 *
 * @author Geovan
 */
public class TesteHospede {
    
    
    public static void main (String[] args){
        testaInsere();
        testaExibe();
    }
    public static void testaExibe(){
        HospedesEAO hospedesEAO = new HospedesEAO();
        List<Hospede> lista = hospedesEAO.listarHospedes();
        
        for(Hospede h : lista){
            System.out.println("Id: "+h.getId());
            System.out.println("Nome: "+h.getNome());
            System.out.println("Documento: "+h.getDocumento());
            System.out.println("DDD: "+h.getDdd());
            System.out.println("Telefone: "+h.getTelefone());
        }
    }
    
    public static void testaInsere(){
        HospedesEAO hospedesEAO = new HospedesEAO();
        Hospede hospede = new Hospede();
       
        hospede.setNome("teste002");
        hospede.setDocumento("xxxxxx");
        hospede.setDdd(11);
        hospede.setTelefone("98976-2229");
        
        hospedesEAO.cadastrarHospede(hospede);
    }
}
