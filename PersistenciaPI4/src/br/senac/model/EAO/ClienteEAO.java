/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.EAO;

import br.senac.model.entidades.Cliente;
import java.util.List;

/**
 *
 * @author user62
 */
public interface ClienteEAO {

    public void cadastrar(Cliente cliente);

    public List<Cliente> getLista();

    public void editar(Cliente cliente);

    public Cliente getCliente(Integer id);
    
    public boolean deletar(Integer id);

}
