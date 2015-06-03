package br.senac.test;

import java.util.List;

import br.senac.model.EAO.impl.AcessorioEAOImpl;
import br.senac.model.entidades.Acessorio;

public class AcessorioTest {
	public static void main (String[] args){
				testaInsere();
                testaExibe();
                testaBuscarPorId(1);
	}
	public static void testaInsere(){
		AcessorioEAOImpl acessorioEAO = new AcessorioEAOImpl();
		for	(int i = 0 ; i<25;i++){
			Acessorio acessorio = new Acessorio();
			acessorio.setDescricao("Acessorio"+i);
			acessorio.setPreco(i+0.5);
			
			acessorioEAO.cadastrar(acessorio);
		}
	}
	
	public static void testaExibe(){
		AcessorioEAOImpl acessorioEAO = new AcessorioEAOImpl();
		List<Acessorio> lista = acessorioEAO.getLista();
		
		for (Acessorio acessorio : lista){
			System.out.println(acessorio.getDescricao());			
		}
	}
	
	
	public static void testaBuscarPorId(Integer id){
		AcessorioEAOImpl acessorioEAO = new AcessorioEAOImpl();
		Acessorio acessorio = new Acessorio();
		acessorio = acessorioEAO.getAcessorio(id);
		System.out.println("Id: "+acessorio.getId());
		System.out.println("Nome: "+acessorio.getDescricao());
	}
	
	public static void testaEditar(){
		Acessorio acessorio = new Acessorio();		
		AcessorioEAOImpl acessorioEAO = new AcessorioEAOImpl();
		acessorio = acessorioEAO.getAcessorio(5);
		System.out.println("Antigo: "+acessorio.getDescricao());
		acessorio.setDescricao("Descri��o alterada!");
		acessorioEAO.editar(acessorio);
		acessorio = acessorioEAO.getAcessorio(5);
		System.out.println("Nova: "+acessorio.getDescricao());
	}
        
        public static void testaRemover(){
            AcessorioEAOImpl acessorioEAOImpl = new AcessorioEAOImpl();
            acessorioEAOImpl.deletar(6);
        }
	
}
