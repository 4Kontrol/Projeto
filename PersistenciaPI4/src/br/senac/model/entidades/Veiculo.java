/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author geovan
 */
@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "Veiculo.resgatarTodos",query = "SELECT c FROM Cliente c")
})
public class Veiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String ano;
    private String imagem;
    private String cor;
    private Integer portas;
    private String combustivel;
    private String potencia;
    private String cambio;
    private Integer velocidade;
    private String estofado;
    private String som;
    private String capacidade;
    private BigDecimal preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getPortas() {
        return portas;
    }

    public void setPortas(Integer portas) {
        this.portas = portas;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public String getEstofado() {
        return estofado;
    }

    public void setEstofado(String estofado) {
        this.estofado = estofado;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    
    
}
