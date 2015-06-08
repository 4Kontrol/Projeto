package br.senac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.senac.model.EAO.AcessorioEAO;
import br.senac.model.entidades.Acessorio;
import br.senac.service.AcessorioService;

@Service
@Component
public class AcessorioServiceImpl implements AcessorioService{

	@Autowired
	private AcessorioEAO acessorioEAO;
	
	public void cadastrar(Acessorio acessorio) {
		
		acessorioEAO.cadastrar(acessorio);
	}

	public List<Acessorio> getLista() {
		
		return acessorioEAO.getLista();
	}

	public void editar(Acessorio acessorio) {
		acessorioEAO.editar(acessorio);
		
	}

	public Acessorio getAcessorio(Integer id) {
		
		return acessorioEAO.getAcessorio(id);
	}

	public boolean deletar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
