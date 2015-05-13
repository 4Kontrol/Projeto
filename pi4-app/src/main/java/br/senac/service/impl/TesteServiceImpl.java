package br.senac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.senac.model.EAO.IHospedeEAO;
import br.senac.model.EAO.impl.HospedesEAO;
import br.senac.model.entidades.Hospede;
import br.senac.service.TesteService;

public class TesteServiceImpl implements TesteService{

	
	
	public void cadastrar(Hospede hospede) {
		// TODO Auto-generated method stub
		IHospedeEAO h = new HospedesEAO();
		
		h.cadastrarHospede(hospede);
	}

}
