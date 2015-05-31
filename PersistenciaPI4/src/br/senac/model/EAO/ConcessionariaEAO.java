package br.senac.model.EAO;

import java.util.List;

import br.senac.model.entidades.Concessionaria;

public interface ConcessionariaEAO {
	
	public void cadastrar(Concessionaria concessionaria);
	
	public List<Concessionaria> getLista();
	
	public void editar(Concessionaria concessionaria);
	
	public Concessionaria getConssecionaria(Integer id);
        
        public boolean deletar(Integer id);

}
