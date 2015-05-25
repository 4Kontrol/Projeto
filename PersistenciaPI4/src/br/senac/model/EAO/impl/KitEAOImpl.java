package br.senac.model.EAO.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.senac.model.EAO.KitEAO;
import br.senac.model.entidades.KitAcessorio;
import br.senac.util.dbSingleton;

public class KitEAOImpl implements KitEAO{
	
	private EntityManager entityManager;
	
	@Override
	public void cadastrar(KitAcessorio kitAcessorio) {
			entityManager = dbSingleton.getEntityManager();
			
			try{
				entityManager.getTransaction().begin();
				entityManager.persist(kitAcessorio);
				entityManager.getTransaction().commit();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				entityManager.close();
			}
	}

	@Override
	public List<KitAcessorio> getLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(KitAcessorio kitAcessorio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KitAcessorio getKitAcessorio(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
