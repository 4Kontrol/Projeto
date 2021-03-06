/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author geovan
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "KitAcessorio.regastarKits", query = "SELECT k FROM KitAcessorio k"),
    @NamedQuery(name = "KitAcessorio.regastarPorId", query = "SELECT k FROM KitAcessorio k WHERE k.id=:id")
})
@Table(name="kitacessorio")
public class KitAcessorio implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private Integer id;    
    private String descricao;    
    @ManyToMany
    private List<Acessorio> itensDoKit;
    private Double preco;
    

    public KitAcessorio() {

    }    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    
    
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    

}


