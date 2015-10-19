/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.senac.model.EAO.impl;

import br.senac.model.EAO.VeiculoEAO;
import br.senac.model.entidades.Veiculo;
import br.senac.util.dbSingleton;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

/**
 *
 * @author Geovan
 */
@Component
public class VeiculoEAOImpl implements VeiculoEAO{

    EntityManager entityManager;
    
    @Override
    public void cadastrar(Veiculo veiculo) {
        entityManager = dbSingleton.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.persist(veiculo);
            entityTransaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
        }finally{
            entityManager.close();
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Veiculo> getLista() {
        entityManager = dbSingleton.getEntityManager();
        Query query = entityManager.createNamedQuery("Veiculo.resgatarTodos");
        return (List<Veiculo>) query.getResultList();
    }


    @Override
    public void editar(Veiculo veiculo) {
        entityManager = dbSingleton.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.merge(veiculo);
            entityTransaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
        }finally{
            entityManager.close();
        }
    }

    @Override
    public Veiculo getVeiculo(Integer id) {
        entityManager = dbSingleton.getEntityManager();
        return (Veiculo) entityManager.find(Veiculo.class, id);
    }

    @Override
    public boolean deletar(Integer id) {
        entityManager = dbSingleton.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.remove(entityManager.merge(getVeiculo(id)));
            entityTransaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
            return false;
        }finally{
            entityManager.close();                 
        }
    }
    
}
