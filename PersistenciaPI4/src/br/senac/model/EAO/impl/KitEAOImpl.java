package br.senac.model.EAO.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.senac.model.EAO.KitEAO;
import br.senac.model.entidades.KitAcessorio;
import br.senac.util.dbSingleton;
import javax.persistence.Query;

public class KitEAOImpl implements KitEAO {

    private EntityManager entityManager;

    @Override
    public void cadastrar(KitAcessorio kitAcessorio) {
        entityManager = dbSingleton.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(kitAcessorio);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<KitAcessorio> getLista() {
        entityManager = dbSingleton.getEntityManager();
        Query query = entityManager.createNamedQuery("Acessorio.recuperarTodos");
        return (List<KitAcessorio>) query.getResultList();
    }

    @Override
    public void editar(KitAcessorio kitAcessorio) {
        entityManager = dbSingleton.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(kitAcessorio);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    @Override
    public KitAcessorio getKitAcessorio(Integer id) {
        entityManager = dbSingleton.getEntityManager();
        Query query = entityManager.createNamedQuery("KitAcessorio.recuperarPorId");
        query.setParameter("id", id);
        return (KitAcessorio) query.getSingleResult();
    }

}
