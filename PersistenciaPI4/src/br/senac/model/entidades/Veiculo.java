/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author geovan
 */
@Entity
@Table (name="veiculo")
public class Veiculo implements Serializable{
    
    @Id
    private int id;
    private String marca;
    private String modelo;
    private String ano;
    private String imagem;
    private String cor;
    private int portas;
    private String combustivel;
    private String potencia;
    private String cambio;
    private int velocidade;
    private String estofado;
    private String som;
    private String capacidade;
    private double preco;
}
