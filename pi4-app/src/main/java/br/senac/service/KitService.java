/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.service;

import br.senac.model.entidades.KitAcessorio;
import java.util.List;

/**
 *
 * @author Geovan
 */
public interface KitService {

    public void cadastrar(KitAcessorio kitAcessorio);

    public List<KitAcessorio> getLista();

    public void editar(KitAcessorio kitAcessorio);

    public KitAcessorio getKitAcessorio(Integer id);

    public boolean deletar(Integer id);
}
