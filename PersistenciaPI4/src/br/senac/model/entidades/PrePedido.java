/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author geovan
 */
@Entity
public class PrePedido implements Serializable{
    private int id;
    private int cpfCliente;
    private Date dataEmissaoPedido;
    private Veiculo veiculo;
    private List<KitAcessorio> ListaDekitsDeAcessorios;
    private List<Acessorio> listaDeAcessorios;
    private boolean situacao;
    
}
