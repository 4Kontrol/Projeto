/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author geovan
 */
@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "PrePedido.resgatarTodos", query = "SELECT p FROM PrePedido p"),
    @NamedQuery(name = "PrePedido.resgatarPorId", query = "SELECT p FROM PrePedido p WHERE p.id=:id"),
    @NamedQuery(name = "PrePedido.resgatarPedidosDoMesmoCPFNoMesmoDia", query = "SELECT p FROM PrePedido p WHERE p.dataEmissaoPedido=:dataSelecionada and p.cliente.cpf=:cpf")
})
public class PrePedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Cliente cliente;
    @Temporal(TemporalType.DATE)
    private Date dataEmissaoPedido;
    @ManyToOne
    private Veiculo veiculo;
    @ManyToOne
    private KitAcessorio KitDeAcessorios;
    @ManyToMany
    private List<Acessorio> listaDeAcessorios;
    //situação do prté pedido true=concretizado false=não concretizado
    private boolean situacao;

    public PrePedido(Cliente cliente, Veiculo veiculo){
        this.cliente = cliente;
        this.veiculo = veiculo;
    	dataEmissaoPedido = new Date();
        setSituacao(false);
    }

    public PrePedido() {
    }   
    
    
    // método de apoio para verificar se o acessorio a ser adicionado não esta em um kit
    private boolean existeAcessorioNoKit(Acessorio acessorio) {
        if (!this.KitDeAcessorios.equals(null)) {
            if (this.KitDeAcessorios.getItensDoKit().contains(acessorio)) {
                return true;
            }
        }
        return false;
    }
    
    //método de apoio para verificar se o acessorio a ser adiciona já não está na lista de acessorios
    private boolean existeAcessorioNaListaAcessorios(Acessorio acessorio) {
        if (!this.listaDeAcessorios.equals(null)) {
            if (this.listaDeAcessorios.contains(acessorio)) {
                return true;
            }
        }
        return false;
    }

    /*
    Antes de adicionar um acessorio esse método verifica se o acessorio 
    já não está presente em algum kit ou na lista de acessorios    
    */    
    public Acessorio adicionarAcessorio(Acessorio acessorio) {
        if (this.listaDeAcessorios.equals(null)){
            this.listaDeAcessorios = new ArrayList();
        }else{
            if (!existeAcessorioNaListaAcessorios(acessorio) && !existeAcessorioNoKit(acessorio)){
                this.listaDeAcessorios.add(acessorio);
                return acessorio;
            }
            else{
                return null;
            }
        }
        return null;        
    }
    
    
    /*
    esse método verifica se algum item do kit 
    já não foi adicionado de forma individual na lista de acessorios
    Caso já tenha sido adicionado o método retorna o acessorio que esta 
    repetido para exibir ao cliente qual item está repetido
    Se não houver itens repetidos ele retorna um objeto null  
    */
    public Acessorio setKitDeAcessorios(KitAcessorio ListaDekitsDeAcessorios) {
        for(Acessorio k : ListaDekitsDeAcessorios.getItensDoKit()){
            if (existeAcessorioNaListaAcessorios(k)) {
                return k;
            }
        }
        this.KitDeAcessorios = ListaDekitsDeAcessorios;
        return null;
    }
    
    public KitAcessorio getKitDeAcessorios() {
        return KitDeAcessorios;
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
