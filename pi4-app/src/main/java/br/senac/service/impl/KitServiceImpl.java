/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.service.impl;

import br.senac.model.EAO.KitEAO;
import br.senac.model.entidades.KitAcessorio;
import br.senac.service.KitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Geovan
 */
@Component
@Service
public class KitServiceImpl implements KitService{
    
    @Autowired
    private KitEAO kitEAO;
    
    public void cadastrar(KitAcessorio kitAcessorio) {
        kitEAO.cadastrar(kitAcessorio);
    }

    public List<KitAcessorio> getLista() {
        return kitEAO.getLista();
    }

    public void editar(KitAcessorio kitAcessorio) {
        kitEAO.editar(kitAcessorio);
    }

    public KitAcessorio getKitAcessorio(Integer id) {
        return kitEAO.getKitAcessorio(id);
    }

    public boolean deletar(Integer id) {
        if(kitEAO.deletar(id)){
            return true;
        }
        else
            return false;
    }
    
}
