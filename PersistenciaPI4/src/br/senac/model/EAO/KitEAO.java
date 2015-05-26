package br.senac.model.EAO;

import java.util.List;

import br.senac.model.entidades.KitAcessorio;




	public interface KitEAO {
		
		public void cadastrar(KitAcessorio kitAcessorio);
		
		public List<KitAcessorio> getLista();
		
		public void editar(KitAcessorio kitAcessorio);
		
		public KitAcessorio getKitAcessorio(Integer id);
                
                

	}

