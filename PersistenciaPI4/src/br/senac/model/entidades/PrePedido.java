/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
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
    @NamedQuery(name = "PrePedido.resgatarPorId", query = "SELECT p FROM PrePedido p WHERE p.id=:id")
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
    private boolean situacao;

    private boolean existeAcessorioNoKit(Acessorio acessorio) {
        if (!this.KitDeAcessorios.equals(null)) {
            if (this.KitDeAcessorios.getItensDoKit().contains(acessorio)) {
                return true;
            }
        }
        return false;
    }

    private boolean existeAcessorioNaListaAcessorios(Acessorio acessorio) {
        if (!this.listaDeAcessorios.equals(null)) {
            if (this.listaDeAcessorios.contains(acessorio)) {
                return true;
            }
        }
        return false;
    }

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

    public KitAcessorio getKitDeAcessorios() {
        return KitDeAcessorios;
    }

    public void setKitDeAcessorios(KitAcessorio ListaDekitsDeAcessorios) {
        this.KitDeAcessorios = ListaDekitsDeAcessorios;
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
