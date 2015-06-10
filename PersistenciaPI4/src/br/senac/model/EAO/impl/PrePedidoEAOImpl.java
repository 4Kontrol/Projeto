/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.model.EAO.impl;

import br.senac.model.EAO.PrePedidoEAO;
import br.senac.model.entidades.PrePedido;
import br.senac.util.dbSingleton;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

/**
 *
 * @author Geovan
 */
@Component
public class PrePedidoEAOImpl implements PrePedidoEAO {

    EntityManager entityManager;
    
    
    @Override
    public void cadastrar(PrePedido prePedido) {
        entityManager = dbSingleton.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(prePedido);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<PrePedido> getLista() {
        entityManager = dbSingleton.getEntityManager();
        Query query = entityManager.createNamedQuery("PrePedido.resgatarTodos");
        return (List<PrePedido>)query.getResultList();
    }

    @Override
    public PrePedido getPrePedido(Integer id) {
        entityManager = dbSingleton.getEntityManager();
        return (PrePedido)entityManager.find(PrePedido.class, id);
    }

    @Override
    public boolean deletar(Integer id) {
       entityManager = dbSingleton.getEntityManager();
       
       try{
           entityManager.getTransaction().begin();
           entityManager.remove(getPrePedido(id));
           entityManager.getTransaction().commit();
           return true;
       }catch(Exception e){
           e.printStackTrace();
           return false;
       }finally{
           entityManager.close();                   
       }
    }

    
    private void editar(PrePedido prePedido) {
        entityManager = dbSingleton.getEntityManager();
        
        try{
        	entityManager.getTransaction().begin();
        	entityManager.merge(prePedido);
        	entityManager.getTransaction().commit();        	
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	entityManager.close();
        }
    }

	@Override
	public void aprovar(PrePedido prePedido) {
		// TODO Auto-generated method stub
		editar(prePedido);
	}

	@Override
	public void reprovar(PrePedido prePedido) {
		// TODO Auto-generated method stub
		editar(prePedido);
	}
}
