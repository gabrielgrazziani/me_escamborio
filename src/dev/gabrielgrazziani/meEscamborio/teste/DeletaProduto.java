package dev.gabrielgrazziani.meEscamborio.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dev.gabrielgrazziani.meEscamborio.bin.Produto;

public class DeletaProduto {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Produto produto = em.find(Produto.class, 1L);
		
		System.out.println(produto);
		em.remove(produto);
	
		em.getTransaction().commit();

	}

}
