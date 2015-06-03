package br.senac.test;

import java.util.List;

import br.senac.model.EAO.ConcessionariaEAO;
import br.senac.model.EAO.impl.ConcessionariaEAOImpl;
import br.senac.model.EAO.impl.HospedesEAO;
import br.senac.model.entidades.Concessionaria;
import br.senac.model.entidades.Endereco;
import br.senac.model.entidades.Hospede;

public class ConcessionariaTest {
	
	public static void main (String[] args){
        testaInsere();
        testaBuscaPorID(1);
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
        
    	Concessionaria registro = new Concessionaria();
    	registro.setNome("ConcessionariaTeste");
    	Endereco endereco = new Endereco();
    	endereco.setEndereco("Rua 001");
    	endereco.setBairro("Bairro 001");
    	endereco.setCep("0000001");
    	endereco.setCidade("Cidade 001");
    	endereco.setComplemento("Complemento 001");
    	endereco.setEstado("SP");
    	endereco.setNumero(3000);
    	registro.setEndereco(endereco);
    	registro.setTelefone("8979461345");
        c.cadastrar(registro);
    }
    
    public static void testaBuscaPorID(Integer id){
    	ConcessionariaEAO c = new ConcessionariaEAOImpl();
    	Concessionaria con = new Concessionaria();
    	con = c.getConssecionaria(id);
    	
    	System.out.println("Id: "+ con.getId());
    	System.out.println("Nome: "+con.getNome());
    	
						  	
    }

}
