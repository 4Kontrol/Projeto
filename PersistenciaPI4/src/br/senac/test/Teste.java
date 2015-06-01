/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.test;

/**
 *
 * @author Geovan
 */
public class Teste {
    public static void main (String[] args){
        TestaLIsta testaLista = new TestaLIsta();
        String a  = "a";
        String b = "b";
        
        testaLista.getLista().add(a);
        testaLista.getLista().add(b);
        
        for (String s : testaLista.getLista()){
            System.out.println(s);
        }
    }
    
}
