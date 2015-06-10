/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.test;

import br.senac.model.EAO.impl.ConcessionariaEAOImpl;
import br.senac.model.EAO.impl.VeiculoEAOImpl;
import br.senac.model.entidades.Veiculo;

/**
 *
 * @author Geovan
 */
public class VeiculoTest {
	public static void main(String[] args) {
		testaInsere();
		testaBusca();
	}

	public static void testaInsere() {

		String[] modelos = { "Peugeout 207", "Agile", "Celta", "City", "Clio",
				"Ferrari", "Fiesta", "Fit", "Fox", "Fusca", "Gol", "J3", "KA",
				"Onix", "Palio", "Prisma", "Tumbler", "Uno" };
		String[] anos = { "2007", "2005", "2009", "2010", "2002", "2015",
				"2014", "2000", "2009", "2001", "1998", "1999", "2000", "2001",
				"2008", "2010", "2011", "2012" };
		String[] cambios = { "Automático", "Manual", "Manual", "Manual",
				"Automático", "Manual", "Manual", "Automático", "Manual",
				"Automático", "Automático", "Manual", "Manual", "Manual",
				"Automático", "Automático", "Automático", "Manual" };
		String[] capacidades = { "5", "5", "5", "5", "5", "5", "5", "5", "5",
				"5", "5", "5", "5", "5", "5", "5", "5", "5" };
		String[] combustiveis = { "Flex", "Gasolina", "Álcool", "Gasolina",
				"Gasolina", "Álcool", "Diesel", "Gasolina", "Gasolina",
				"Álcool", "Gasolina", "Diesel", "Gasolina", "Álcool", "Diesel",
				"Gasolina", "Diesel", "Gasolina" };
		String[] cores = { "Prata", "Amarelo", "Vermelho", "Vermelho",
				"Vermelho", "Vermelho", "Prata", "Vermelho", "Vermelho",
				"Azul", "Prata", "Branco", "Vermelho", "Prata", "Prata",
				"Prata", "Dark", "Amarelo" };
		String[] estofados = { "Couro", "Comum", "Couro", "Couro", "Couro",
				"Couro", "Comum", "Couro", "Couro", "Comum", "Comum", "Comum",
				"Comum", "Couro", "Couro", "Couro", "Couro", "Comum" };
		String[] imagens = { "207.jpg", "agile.jpg", "celta.jpg", "city.jpg",
				"clio.jpg", "ferrari.jpg", "fiesta.jpg", "fit.jpg", "fox.jpg",
				"fusca.jpg", "gol.jpg", "j3.jpg", "ka.jpg", "onix.jpg",
				"palio.jpg", "prisma.jpg", "tumbler.jpg", "uno.jpg" };
		String[] marcas = { "Peugeout", "Chevrolet", "Chevrolet", "Honda",
				"Renault", "Ferrari", "Ford", "Honda", "Volkswagem",
				"Volkswagem", "Volkswagem", "ASUS", "Ford", "Chevrolet",
				"Fiat", "AOC", "Wayne", "Fiat" };
		String[] portas = { "2", "4", "2", "4", "2", "2", "2", "4", "4", "2",
				"4", "4", "2", "4", "2", "2", "1", "2" };
		String[] potencias = { "16 cavalos", "11 cavalos", "10 cavalos",
				"8 cavalos", "18 cavalos", "17 cavalos", "10 cavalos",
				"15 cavalos", "5 cavalos", "1 cavalos", "8 cavalos",
				"10 cavalos", "4 cavalos", "11 cavalos", "9 cavalos",
				"3 cavalos", "300 cavalos", "12 cavalos" };
		String[] precos = { "194113", "320748", "254165", "212370", "45148",
				"213394", "172979", "272956", "173129", "333181", "42214",
				"328835", "221478", "66823", "224825", "165091", "301266",
				"188457" };
		String[] som = { "MP3", "MP3", "CD", "CD", "CD", "CD", "CD", "CD",
				"MP3", "MP3", "MP3", "MP3", "MP3", "Rádio", "Rádio", "Rádio",
				"Morcegos", "Rádio" };
		String[] velocidades = { "262", "193", "425", "266", "278", "431",
				"402", "364", "152", "219", "208", "414", "407", "259", "130",
				"261", "550", "216" };
		String[] concessionarias = { "1", "2", "2", "3", "3", "2", "3", "1",
				"2", "1", "1", "2", "1", "3", "3", "3", "2", "2" };

		
		ConcessionariaEAOImpl concessionariaEAOImpl = new ConcessionariaEAOImpl();
		VeiculoEAOImpl veiculoEAOImpl = new VeiculoEAOImpl();

		for (int i = 0; i < modelos.length; i++) {
			Veiculo veiculo = new Veiculo();
			veiculo.setModelo(modelos[i]);
			veiculo.setAno(anos[i]);
			veiculo.setCambio(cambios[i]);
			veiculo.setCapacidade(capacidades[i]);
			veiculo.setCombustivel(combustiveis[i]);
			veiculo.setCor(cores[i]);
			veiculo.setEstofado(estofados[i]);
			veiculo.setImagem(imagens[i]);
			veiculo.setMarca(marcas[i]);
			veiculo.setPortas(Integer.valueOf(portas[i]));
			veiculo.setPotencia(potencias[i]);
			veiculo.setPreco(Double.valueOf(precos[i]));
			veiculo.setSom(som[i]);
			veiculo.setVelocidade(Integer.valueOf(velocidades[i]));
			veiculo.setConcessionaria(concessionariaEAOImpl
					.getConssecionaria(Integer.valueOf(concessionarias[i])));
			veiculoEAOImpl.cadastrar(veiculo);

		}

	}

	public static void testaBusca() {
		Veiculo veiculo = new Veiculo();
		VeiculoEAOImpl veiculoEAOImpl = new VeiculoEAOImpl();
		veiculo = veiculoEAOImpl.getVeiculo(1);
		System.out.println("Id: " + veiculo.getId());
		System.out.println("Modelo: " + veiculo.getModelo());
	}

}
