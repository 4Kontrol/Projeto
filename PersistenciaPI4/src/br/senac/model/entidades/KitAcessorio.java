/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author geovan
 */

public class KitAcessorio implements Serializable{
    
    private int id;
    private List<Acessorio> itensDoKit;

    public KitAcessorio() {
        //precisamos encontrar uma maneira de limitar o tamanho dos list pra 5 itens 
    }
    
    
    
}
