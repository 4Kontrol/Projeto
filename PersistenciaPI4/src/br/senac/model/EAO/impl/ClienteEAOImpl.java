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

import org.springframework.stereotype.Component;

/**
 *
 * @author user62
 */
@Component
public class ClienteEAOImpl implements ClienteEAO{

    private EntityManager entityManager;
        
    @Override
    public void cadastrar(Cliente cliente) {
    	entityManager = dbSingleton.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }

    @SuppressWarnings("unchecked")
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
        	entityManager.getTransaction().rollback();
        }finally{
        	entityManager.close();
        }
    }

    @Override
    public Cliente getCliente(Integer id) {
    	entityManager = dbSingleton.getEntityManager();
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public boolean deletar(Integer id) {
    	entityManager = dbSingleton.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(getCliente(id));
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }finally{
            entityManager.close();                 
        }
    }    
}
