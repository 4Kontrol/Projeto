/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.model.EAO;

import br.senac.model.entidades.Hospede;
import java.util.List;

/**
 *
 * @author Geovan
 */
public interface IHospedeEAO {
    public void cadastrarHospede(Hospede hospede);
    
    public List<Hospede> listarHospedes();
}
