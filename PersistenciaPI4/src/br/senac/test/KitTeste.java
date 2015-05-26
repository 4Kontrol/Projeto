package br.senac.test;

import java.util.ArrayList;
import java.util.List;

import br.senac.model.EAO.impl.AcessorioEAOImpl;
import br.senac.model.EAO.impl.KitEAOImpl;
import br.senac.model.entidades.Acessorio;
import br.senac.model.entidades.KitAcessorio;

public class KitTeste {
	
	public static void main (String [] args){
		testaInsere();
	}
	
	public static void testaInsere(){
		KitAcessorio kitAcessorio = new KitAcessorio();
		
		AcessorioEAOImpl acessorioEAOImpl = new AcessorioEAOImpl();
		List<Acessorio> lista = new ArrayList<Acessorio>();
		lista = acessorioEAOImpl.getLista();
		
		int conta = 1;
		
		for(Acessorio acessorio : lista){
			if (conta>=2){
				kitAcessorio.adicionarAcessorio(acessorio);				
			}
			
			conta++;
		}
		
		KitEAOImpl eaoImpl = new KitEAOImpl();
		eaoImpl.cadastrar(kitAcessorio);
	}
	
	public static void testaExibe(){
		
	}
	
}
