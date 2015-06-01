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
    //situa��o do prt� pedido true=concretizado false=n�o concretizado
    private boolean situacao;

    public PrePedido(Cliente cliente, Veiculo veiculo){
        this.cliente = cliente;
        this.veiculo = veiculo;
    	dataEmissaoPedido = new Date();
        setSituacao(false);
    }

    public PrePedido() {
    }   
    
    
    // m�todo de apoio para verificar se o acessorio a ser adicionado n�o esta em um kit
    private boolean existeAcessorioNoKit(Acessorio acessorio) {
        if (!this.KitDeAcessorios.equals(null)) {
            if (this.KitDeAcessorios.getItensDoKit().contains(acessorio)) {
                return true;
            }
        }
        return false;
    }
    
    //m�todo de apoio para verificar se o acessorio a ser adiciona j� n�o est� na lista de acessorios
    private boolean existeAcessorioNaListaAcessorios(Acessorio acessorio) {
        if (!this.listaDeAcessorios.equals(null)) {
            if (this.listaDeAcessorios.contains(acessorio)) {
                return true;
            }
        }
        return false;
    }

    /*
    Antes de adicionar um acessorio esse m�todo verifica se o acessorio 
    j� n�o est� presente em algum kit ou na lista de acessorios    
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
    esse m�todo verifica se algum item do kit 
    j� n�o foi adicionado de forma individual na lista de acessorios
    Caso j� tenha sido adicionado o m�todo retorna o acessorio que esta 
    repetido para exibir ao cliente qual item est� repetido
    Se n�o houver itens repetidos ele retorna um objeto null  
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
