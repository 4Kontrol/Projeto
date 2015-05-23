package br.senac.test;

import java.util.List;

import br.senac.model.EAO.ConcessionariaEAO;
import br.senac.model.EAO.impl.ConcessionariaEAOImpl;
import br.senac.model.EAO.impl.HospedesEAO;
import br.senac.model.entidades.Concessionaria;
import br.senac.model.entidades.Hospede;

public class ConcessionariaTest {
	
	public static void main (String[] args){
        testaInsere();
        testaExibe();
    }
    public static void testaExibe(){
        ConcessionariaEAO c = new ConcessionariaEAOImpl();
        List<Concessionaria> lista = c.getLista();
        
        for(Concessionaria h : lista){
            System.out.println("Id: "+h.getId());
            System.out.println("Nome: "+h.getNome());
        }
    }
    
    public static void testaInsere(){
    	 ConcessionariaEAO c = new ConcessionariaEAOImpl();
        
    	// Concessionaria registro = new Concessionaria("edu","rua","56141614",25,"B","04434110","niteroi","sao apulo","sp","0655");
       // c.cadastrar(registro);
    }

}
