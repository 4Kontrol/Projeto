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

/**
 *
 * @author Geovan
 */
public class PrePedidoEAOImpl implements PrePedidoEAO {

    EntityManager entityManager;
    
    
    private void cadastrar(PrePedido prePedido) {
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

    @Override
    public void editar(PrePedido prePedido) {
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
    
    //regra de negócio o cliente só podera registrar duas intenções de compra por dia
    private boolean existemDoisPedidosDoCPFNoMesmoDia(PrePedido prePedido){
    	entityManager = dbSingleton.getEntityManager();
    	Query query = entityManager.createNamedQuery("PrePedido.resgatarPedidosDoMesmoCPFNoMesmoDia");
    	query.setParameter("dataSelecionada", prePedido.getDataEmissaoPedido());
    	query.setParameter("cpf", prePedido.getCliente().getCpf());    	
    	if(!query.getResultList().equals(null) && query.getResultList().size()==2){
    		return true;
    	}
    	else
    		return false;    	
    }
    
    public boolean registrarPrePedido(PrePedido prePedido){    	
    	if(!existemDoisPedidosDoCPFNoMesmoDia(prePedido)){
    		cadastrar(prePedido);
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}
