package br.senac.model.EAO;

import java.util.List;

import br.senac.model.entidades.Concessionaria;

public interface ConcessionariaEAO {
	
	public void cadastrar(Concessionaria concessionaria);
	
	public List<Concessionaria> getLista();

}
