package br.senac.service;

import java.util.List;

import br.senac.model.entidades.Veiculo;

public interface VeiculoService {
	
	public List<Veiculo> getLista();
	
	public Veiculo getVeiculo(Integer id);

}
