package dev.gabrielgrazziani.meEscamborio.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;

public class TesteVerLoja {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select loja from Loja loja";
		
		TypedQuery<Loja> query = em.createQuery(jpql, Loja.class);
		List<Loja> lojas = query.getResultList();
		
		
		em.close();
		
		lojas.forEach(System.out::println);

	}

}
