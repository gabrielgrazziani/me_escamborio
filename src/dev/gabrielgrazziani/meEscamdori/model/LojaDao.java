package dev.gabrielgrazziani.meEscamdori.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;

public class LojaDao implements AutoCloseable{
	EntityManagerFactory emf;
	EntityManager em;
	
	public LojaDao() {
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();	
	}
	
	public List<Loja> index(){
		String jpql = "select loja from Loja loja";
		
		TypedQuery<Loja> query = em.createQuery(jpql, Loja.class);
		List<Loja> lojas = query.getResultList();

		return lojas;
	}
	
	public Loja GetLoja(Long id) {
		Loja loja = em.find(Loja.class,id);
		return loja;
	}
	
	public void excluir(Long id) {
		Loja loja = em.find(Loja.class, id);
		em.getTransaction().begin();
		em.remove(loja);
		em.getTransaction().commit();
	}
	
	public void save(Loja loja) {
		em.getTransaction().begin();
		if(loja.getId() == 0) {
			em.persist(loja);
		}
		else {
			em.merge(loja);
		}
		em.getTransaction().commit();
	}

	@Override
	public void close(){
		emf.close();
		em.close();
	}
}
