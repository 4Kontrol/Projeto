package br.senac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.senac.model.EAO.VeiculoEAO;
import br.senac.model.entidades.Veiculo;
import br.senac.service.VeiculoService;

@Component
public class VeiculoServiceImpl implements VeiculoService{

	@Autowired
	private VeiculoEAO veiculoEAO;
	
	public List<Veiculo> getLista() {
		return veiculoEAO.getLista();
	}

	public Veiculo getVeiculo(Integer id) {
		
		return veiculoEAO.getVeiculo(id);
	}

}
