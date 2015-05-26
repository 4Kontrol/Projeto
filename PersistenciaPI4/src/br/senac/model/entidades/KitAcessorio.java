/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author geovan
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "KitAcessorio.regastarKits", query = "SELECT k FROM KitAcessorio k"),
    @NamedQuery(name = "KitAcessorio.regastarPorId", query = "SELECT k FROM KitAcessorio k WHERE k.id=:id")
})
public class KitAcessorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private int id;
    
    private String descricao;
    
    @ManyToMany
    private List<Acessorio> itensDoKit = new ArrayList<Acessorio>();

    public KitAcessorio() {

    }

    private boolean isFull() {
        if (this.itensDoKit.size() == 5) {
            return true;
        } else {
            return false;
        }
    }

    public Acessorio adicionarAcessorio(Acessorio acessorio) {
        if (!isFull()) {
            this.itensDoKit.add(acessorio);
            return acessorio;
        } else {
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Acessorio> getItensDoKit() {
        return itensDoKit;
    }

    public void setItensDoKit(List<Acessorio> itensDoKit) {
        this.itensDoKit = itensDoKit;
    }
    
    

}


