package br.senac.model.EAO;

import java.util.List;

import br.senac.model.entidades.Acessorio;

public interface AcessorioEAO {
	public void cadastrar(Acessorio acessorio);
	
	public List<Acessorio> getLista();
	
	public void editar(Acessorio acessorio);
	
	public Acessorio getAcessorio(Integer id);
}
