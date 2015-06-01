package br.senac.service;

import java.util.List;

import br.senac.model.entidades.Acessorio;

public interface AcessorioService {

	public void cadastrar(Acessorio acessorio);

	public List<Acessorio> getLista();

	public void editar(Acessorio acessorio);

	public Acessorio getAcessorio(Integer id);

	public boolean deletar(Integer id);

}
