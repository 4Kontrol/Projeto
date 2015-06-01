/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Geovan
 */
public class Teste {
    public static void main (String[] args){
        Calendar dataHoje = Calendar.getInstance(Locale.ROOT);
        System.out.println("Data de hoje"+dataHoje.getTime());
    }
    
}
