/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table
public class KitAcessorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private int id;    
    private String descricao;    
    @ManyToMany
    private List<Acessorio> itensDoKit;
    private float preco;
    

    public KitAcessorio() {

    }
    
    private boolean verificaAcessoriosRepetidos (Acessorio acessorio) {
        for (Acessorio a : this.itensDoKit) {
            if (a.equals(acessorio)){
                return true;
            }
        }
        return false;
    }

    private boolean isFull() {
        if (this.itensDoKit.size() == 5) {
            return true;
        } else {
            return false;
        }
    }

    public Acessorio adicionarAcessorio(Acessorio acessorio) {    
        
        if (this.itensDoKit!=null){
            if (!isFull() && !verificaAcessoriosRepetidos(acessorio)) {
                this.itensDoKit.add(acessorio);
                this.preco = preco+acessorio.getPreco();
                return acessorio;
            } else {
                return null;
            }
        }
        else{
            instanciarLista();
            if (!isFull() && !verificaAcessoriosRepetidos(acessorio)) {
                this.itensDoKit.add(acessorio);
                this.preco = preco+acessorio.getPreco();
                return acessorio;
            } else {
                return null;
            }
        }
    }
    
    private List<Acessorio> instanciarLista(){
       this.itensDoKit = new ArrayList<Acessorio>();
       return this.itensDoKit;
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

    //retorna o preço do kit com o desconto de 20%
    public float getPrecoVenda(){
    	return (preco/100)*80;    	
    }
    
    //retorna o preço do kit sem o desconto de 20%
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    

}


