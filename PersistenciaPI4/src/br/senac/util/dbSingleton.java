/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Geovan
 */
public class dbSingleton {
    static EntityManagerFactory entityManagerFactory = null;
    
    public static EntityManager getEntityManager (){
        if (entityManagerFactory==null){
            try{
                entityManagerFactory = Persistence.createEntityManagerFactory("PI4PU");
                
            }catch(Exception e ){
                JOptionPane.showMessageDialog(null, "Erro na geração da conexão com o banco de dados, " +e);
            }
        }
        return entityManagerFactory.createEntityManager();
    }
}
