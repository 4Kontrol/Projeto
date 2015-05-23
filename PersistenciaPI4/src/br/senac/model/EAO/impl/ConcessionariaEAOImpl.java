package br.senac.model.EAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.senac.model.EAO.ConcessionariaEAO;
import br.senac.model.entidades.Concessionaria;
import br.senac.util.dbSingleton;

public class ConcessionariaEAOImpl implements ConcessionariaEAO{

	private EntityManager entityManager;
	
	@Override
	public void cadastrar(Concessionaria concessionaria) {
		
		 entityManager = dbSingleton.getEntityManager();
        
		try {
            
            entityManager.getTransaction().begin();
            entityManager.persist(concessionaria);
            entityManager.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Concessionaria> getLista(){
		   entityManager = dbSingleton.getEntityManager();
	        
	        try{           
	            Query q = entityManager.createQuery("SELECT c FROM Concessionaria c");
	            return (List<Concessionaria>) q.getResultList();            
	        }catch(Exception e){
	        	 entityManager.close();
	        }finally{
	            entityManager.close();
	        }
	        return null;
		
	}

	@Override
	public void editar(Concessionaria concessionaria) {
		entityManager = dbSingleton.getEntityManager();
		
		try{           
			entityManager.getTransaction().begin();
			entityManager.persist(concessionaria);
			entityManager.getTransaction().commit();
			
        }catch(Exception e){
        	 entityManager.close();
        }finally{
            entityManager.close();
        }
		
	}

	@Override
	public Concessionaria getConssecionaria(Integer id){
		
		entityManager = dbSingleton.getEntityManager();
		return entityManager.find(Concessionaria.class, id);
	}

}
