package dev.gabrielgrazziani.meEscamdori.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dev.gabrielgrazziani.meEscamborio.bin.Mensagem;

public class MensagemDao implements AutoCloseable{
	EntityManagerFactory emf;
	EntityManager em;
	
	public MensagemDao() {
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();	
	}
	
	public List<Mensagem> index(){
		String jpql = "select m from Mensagem m";
		
		TypedQuery<Mensagem> query = em.createQuery(jpql, Mensagem.class);
		List<Mensagem> mensagem = query.getResultList();

		return mensagem;
	}
	
	public Mensagem getMensagem(Long id) {
		Mensagem mensagem = em.find(Mensagem.class,id);
		return mensagem;
	}
	
	public void excluir(Long id) {
		Mensagem mensagem = em.find(Mensagem.class, id);
		em.getTransaction().begin();
		em.remove(mensagem);
		em.getTransaction().commit();
	}
	
	public void save(Mensagem mensagem) {
		em.getTransaction().begin();
		if(mensagem.getId() == 0) {
			em.persist(mensagem);
		}
		else {
			em.merge(mensagem);
		}
		em.getTransaction().commit();
	}

	@Override
	public void close(){
		emf.close();
		em.close();
	}
}
