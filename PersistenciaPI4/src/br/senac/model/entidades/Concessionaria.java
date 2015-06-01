package br.senac.model.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Concessionaria implements Serializable{
	

	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
        private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "cnpj")
	private String cnpj;	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco; 
        @ManyToMany
        private List<Veiculo> listaDeVeiculos;
        
        

	
	public Concessionaria(){
	}

	public Concessionaria(String nome, String telefone, String cnpj) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.cnpj = cnpj;
	}

    public List<Veiculo> getListaDeVeiculos() {
        return listaDeVeiculos;
    }

    public void setListaDeVeiculos(List<Veiculo> listaDeVeiculos) {
        this.listaDeVeiculos = listaDeVeiculos;
    }
        
        

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	

}
