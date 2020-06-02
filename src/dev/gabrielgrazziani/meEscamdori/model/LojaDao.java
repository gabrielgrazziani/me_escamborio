package dev.gabrielgrazziani.meEscamdori.model;

import java.util.List;
import java.util.Optional;

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
	
	public Loja getLoja(Long id) {
		String jpql = "select l from Loja l left join fetch l.produtos where l.id = :idLoja";
		TypedQuery<Loja> typedQuery = em.createQuery(jpql,Loja.class);
		typedQuery.setParameter("idLoja", id);
		Loja loja = typedQuery.getSingleResult();
		
		typedQuery = em.createQuery("select distinct l from Loja l left join fetch l.mensagens where l in :loja",Loja.class);
		typedQuery.setParameter("loja", loja);
		loja = typedQuery.getSingleResult();
		
		return loja;
	}
	
	public Optional<Loja> getLoja(String email) {
		String jpql = "select l from Loja l where l.email = :email";
		TypedQuery<Loja> typedQuery = em.createQuery(jpql, Loja.class);
		typedQuery.setParameter("email", email);
			 
		return typedQuery.getResultStream().findFirst();
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
