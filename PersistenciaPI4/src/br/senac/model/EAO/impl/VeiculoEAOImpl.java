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
import javax.persistence.Query;

/**
 *
 * @author Geovan
 */
public class VeiculoEAOImpl implements VeiculoEAO{

    EntityManager entityManager;
    
    @Override
    public void cadastrar(Veiculo veiculo) {
        entityManager = dbSingleton.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(veiculo);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<Veiculo> getLista() {
        entityManager = dbSingleton.getEntityManager();
        Query query = entityManager.createNamedQuery("Veiculo.resgatarTodos");
        return (List<Veiculo>) query.getResultList();
    }


    @Override
    public void editar(Veiculo veiculo) {
        entityManager = dbSingleton.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(veiculo);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
    }

    @Override
    public Veiculo getAcessorio(Integer id) {
        entityManager = dbSingleton.getEntityManager();
        return (Veiculo) entityManager.find(Veiculo.class, id);
    }

    @Override
    public boolean deletar(Integer id) {
        entityManager = dbSingleton.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(getAcessorio(id));
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            entityManager.close();                 
        }
    }
    
}
