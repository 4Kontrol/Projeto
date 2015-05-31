/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.model.EAO.impl;

import br.senac.model.EAO.ClienteEAO;
import br.senac.model.entidades.Cliente;
import br.senac.util.dbSingleton;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author user62
 */
public class ClienteEAOImpl implements ClienteEAO{

    EntityManager entityManager;
    
    @Override
    public void cadastrar(Cliente cliente) {
        entityManager = dbSingleton.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<Cliente> getLista() {
        entityManager = dbSingleton.getEntityManager();
        Query query = entityManager.createNamedQuery("Cliente.recuperarTodos");
        return (List<Cliente>) query.getResultList(); 
    }

    @Override
    public void editar(Cliente cliente) {
        entityManager = dbSingleton.getEntityManager();
        
        try{
        	entityManager.getTransaction().begin();
        	entityManager.merge(cliente);
        	entityManager.getTransaction().commit();
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	entityManager.close();
        }
    }

    @Override
    public Cliente getCliente(Integer id) {
        entityManager = dbSingleton.getEntityManager();
        return entityManager.find(Cliente.class, id);
    }
    
}
