package br.senac.model.EAO.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.senac.model.EAO.AcessorioEAO;
import br.senac.model.entidades.Acessorio;
import br.senac.util.dbSingleton;
import org.springframework.stereotype.Component;

@Component
public class AcessorioEAOImpl implements AcessorioEAO {

    private EntityManager entityManager;
    
    @Override
    public void cadastrar(Acessorio acessorio) {
    	entityManager = dbSingleton.getEntityManager();
    	EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(acessorio);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Acessorio> getLista() {
    	entityManager = dbSingleton.getEntityManager();
        Query query = entityManager.createNamedQuery("Acessorio.recuperarTodos");
        return (List<Acessorio>) query.getResultList();
    }

    @Override
    public void editar(Acessorio acessorio) {
    	entityManager = dbSingleton.getEntityManager();
    	EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(acessorio);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Acessorio getAcessorio(Integer id) {
    	entityManager = dbSingleton.getEntityManager();
        return (Acessorio) entityManager.find(Acessorio.class, id);
    }

    @Override
    public boolean deletar(Integer id) {
    	entityManager = dbSingleton.getEntityManager();
    	EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
        	entityTransaction.begin();
            entityManager.remove(entityManager.merge(getAcessorio(id)));
            entityTransaction.commit();
            return true;
        }catch(Exception e ){
            e.printStackTrace();
            entityTransaction.rollback();
            return false;
        }finally{
            entityManager.close();
        }        
    }
}
