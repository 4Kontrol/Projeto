package br.senac.model.EAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senac.model.EAO.AcessorioEAO;
import br.senac.model.entidades.Acessorio;
import br.senac.util.dbSingleton;

public class AcessorioEAOImpl implements AcessorioEAO {

    EntityManager entityManager;

    @Override
    public void cadastrar(Acessorio acessorio) {

        entityManager = dbSingleton.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(acessorio);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Acessorio> getLista() {
        entityManager = dbSingleton.getEntityManager();
        Query query = entityManager.createNamedQuery("Acessorio.recuperarTodos");
        return (List<Acessorio>) query.getResultList();
    }

    @Override
    public void editar(Acessorio acessorio) {
        entityManager = dbSingleton.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(acessorio);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Acessorio getAcessorio(Integer id) {
        entityManager = dbSingleton.getEntityManager();               
        return (Acessorio) entityManager.find(Acessorio.class, id);
    }

}
