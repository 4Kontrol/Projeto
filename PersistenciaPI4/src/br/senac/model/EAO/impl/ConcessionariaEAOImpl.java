package br.senac.model.EAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.senac.model.EAO.ConcessionariaEAO;
import br.senac.model.entidades.Concessionaria;
import br.senac.util.dbSingleton;

import org.springframework.stereotype.Component;

@Component
public class ConcessionariaEAOImpl implements ConcessionariaEAO {

    private EntityManager entityManager;
   
    @Override
    public void cadastrar(Concessionaria concessionaria) {
    	entityManager = dbSingleton.getEntityManager();
    	EntityTransaction entityTransaction = entityManager.getTransaction();
    	try {
    		entityTransaction.begin();
            entityManager.persist(concessionaria);
            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Concessionaria> getLista() {
    	entityManager = dbSingleton.getEntityManager();
    	Query q = entityManager.createQuery("SELECT c FROM Concessionaria c");
        return (List<Concessionaria>) q.getResultList();
    }

    @Override
    public void editar(Concessionaria concessionaria) {
    	entityManager = dbSingleton.getEntityManager();
    	EntityTransaction entityTransaction = entityManager.getTransaction();
    	try {  
    		entityTransaction.begin();
            entityManager.merge(concessionaria);
            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Concessionaria getConssecionaria(Integer id) {
    	entityManager = dbSingleton.getEntityManager();
        return entityManager.find(Concessionaria.class, id);
    }

    @Override
    public boolean deletar(Integer id) {
    	entityManager = dbSingleton.getEntityManager();
    	EntityTransaction entityTransaction = entityManager.getTransaction();
        try { 
        	entityTransaction.begin();
            entityManager.remove(entityManager.merge(getConssecionaria(id)));
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }
}
