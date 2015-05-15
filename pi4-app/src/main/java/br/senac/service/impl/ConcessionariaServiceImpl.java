package br.senac.service.impl;

import java.util.List;

import br.senac.model.EAO.ConcessionariaEAO;
import br.senac.model.EAO.impl.ConcessionariaEAOImpl;
import br.senac.model.entidades.Concessionaria;
import br.senac.service.ConcessionariaService;

public class ConcessionariaServiceImpl implements ConcessionariaService{
	
	private ConcessionariaEAO concessionariaEAO;

	public void cadastrar(Concessionaria concessionaria) {
		concessionariaEAO = new ConcessionariaEAOImpl();
		concessionariaEAO.cadastrar(concessionaria);
		
	}

	public List<Concessionaria> getLista() {
		concessionariaEAO = new ConcessionariaEAOImpl();
		return concessionariaEAO.getLista();
	}

}
