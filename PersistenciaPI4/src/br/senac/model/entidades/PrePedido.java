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

public class PrePedido implements Serializable{
    private int id;
    private Cliente cliente;
    private Date dataEmissaoPedido;
    private Veiculo veiculo;
    private KitAcessorio ListaDekitsDeAcessorios;
    private List<Acessorio> listaDeAcessorios;
    private boolean situacao;
    
    
    private boolean existeAcessorioDaListaNoKit(Acessorio acessorio){
        return true;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }    

    public Date getDataEmissaoPedido() {
        return dataEmissaoPedido;
    }

    public void setDataEmissaoPedido(Date dataEmissaoPedido) {
        this.dataEmissaoPedido = dataEmissaoPedido;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public KitAcessorio getListaDekitsDeAcessorios() {
        return ListaDekitsDeAcessorios;
    }

    public void setListaDekitsDeAcessorios(KitAcessorio ListaDekitsDeAcessorios) {
        this.ListaDekitsDeAcessorios = ListaDekitsDeAcessorios;
    }

    public List<Acessorio> getListaDeAcessorios() {
        return listaDeAcessorios;
    }

    public void setListaDeAcessorios(List<Acessorio> listaDeAcessorios) {
        this.listaDeAcessorios = listaDeAcessorios;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    
    
}
