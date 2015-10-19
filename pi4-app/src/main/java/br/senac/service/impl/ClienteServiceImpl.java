package br.senac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.senac.model.EAO.ClienteEAO;
import br.senac.model.entidades.Cliente;
import br.senac.service.ClienteService;

@Component
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteEAO clienteEAO;

	public void cadastrar(Cliente cliente) {
		clienteEAO.cadastrar(cliente);
		
	}


}
