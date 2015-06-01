/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.EAO;

import br.senac.model.entidades.Veiculo;
import java.util.List;

/**
 *
 * @author user62
 */
public interface VeiculoEAO {
    public void cadastrar(Veiculo veiculo);

    public List<Veiculo> getLista();

    public void editar(Veiculo veiculo);

    public Veiculo getVeiculo(Integer id);
    
    public boolean deletar(Integer id);
}
