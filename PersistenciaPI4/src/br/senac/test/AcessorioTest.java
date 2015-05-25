package br.senac.test;

import java.util.List;

import br.senac.model.EAO.impl.AcessorioEAOImpl;
import br.senac.model.entidades.Acessorio;

public class AcessorioTest {
	public static void main (String[] args){
		testaExibe();
		
	}
	public static void testaInsere(){
		AcessorioEAOImpl acessorioEAO = new AcessorioEAOImpl();
		for	(int i = 0 ; i<25;i++){
			Acessorio acessorio = new Acessorio();
			acessorio.setDesricao("Acessorio"+i);
			acessorioEAO.cadastrar(acessorio);
		}
	}
	
	public static void testaExibe(){
		AcessorioEAOImpl acessorioEAO = new AcessorioEAOImpl();
		List<Acessorio> lista = acessorioEAO.getLista();
		
		for (Acessorio acessorio : lista){
			System.out.println(acessorio.getDesricao());			
		}
	}
}
