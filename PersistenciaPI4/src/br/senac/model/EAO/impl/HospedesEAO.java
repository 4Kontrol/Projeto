package br.senac.model.EAO.impl;


import br.senac.util.dbSingleton;
import br.senac.model.EAO.IHospedeEAO;
import br.senac.model.entidades.Hospede;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Geovan
 */

public class HospedesEAO implements IHospedeEAO{

    
    private List<Hospede> listaHospedes;

    @Override
    public List<Hospede> listarHospedes() {
        EntityManager entityManager = dbSingleton.getEntityManager();
        
        try{           
            Query q = entityManager.createQuery("SELECT h FROM Hospede h");
            return (List<Hospede>) q.getResultList();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERRO: "+e);
        }
        return null;
        }

    @Override
    public void cadastrarHospede(Hospede hospede) {
        EntityManager entityManager = dbSingleton.getEntityManager();
        try {
            
            entityManager.getTransaction().begin();
            entityManager.persist(hospede);
            entityManager.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
        
    }
    
    public void removePessoa(Hospede pessoa){
        
    }
    
    public void atualizaPessoa(Hospede pessoa){
       
    }
    
    public List buscaHospede(String nome){
        EntityManager entityManager = dbSingleton.getEntityManager();
        try{
            List<Hospede> lista  = new ArrayList <Hospede>();
            entityManager.getTransaction().begin();
            String query = "select * from tbl_hospedes where nome like "+nome;
            lista.addAll(entityManager.createNativeQuery(query).getResultList());
            entityManager.getTransaction().commit();
            return lista;
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
