package br.senac.service;

import java.util.List;

import br.senac.model.entidades.Concessionaria;

public interface ConcessionariaService {

	public void cadastrar(Concessionaria concessionaria);

	public List<Concessionaria> getLista();

	public void editar(Concessionaria concessionaria);

	public Concessionaria getConssecionaria(Long id);

}
