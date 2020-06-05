package dev.gabrielgrazziani.meEscamdori.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dev.gabrielgrazziani.meEscamborio.bin.Produto;

public class ProdutoDao implements AutoCloseable{
	EntityManagerFactory emf;
	EntityManager em;
	
	public ProdutoDao() {
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();	
	}
	
	public List<Produto> index(){
		String jpql = "select p from Produto p";
		
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		List<Produto> produtos = query.getResultList();

		return produtos;
	}
	
	public Produto getProduto(Long id) {
		Produto produto = em.find(Produto.class,id);
		return produto;
	}
	
	public void excluir(Long id) {
		Produto produto = em.find(Produto.class,id);
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}
	
	public void save(Produto produto) {
		em.getTransaction().begin();
		if(produto.getId() == 0) {
			em.persist(produto);
		}
		else {
			em.merge(produto);
		}
		em.getTransaction().commit();
	}

	@Override
	public void close(){
		emf.close();
		em.close();
	}
}
