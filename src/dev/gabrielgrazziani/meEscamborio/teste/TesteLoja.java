package dev.gabrielgrazziani.meEscamborio.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamborio.bin.Mensagem;
import dev.gabrielgrazziani.meEscamborio.bin.Produto;

public class TesteLoja {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Loja doce = new Loja("doce", "doce@gmail.com", "12345");
		
		Produto p1 = new Produto();
		p1.setNome("bolo");
		p1.setDescricao("bolo de cenoura");
		p1.setPreco(new BigDecimal("20"));
		p1.setLoja(doce);
		
		Produto p2 = new Produto();
		p2.setNome("bolo 2");
		p2.setDescricao("bolo de chocolate");
		p2.setPreco(new BigDecimal("20"));
		p2.setLoja(doce);
		
		Mensagem msg1 = new Mensagem();
		msg1.setComprador("fulano");
		msg1.setProduto(p1);
		msg1.setLoja(doce);
		msg1.setQuantidade(2);
		msg1.setTelefone("1232-3423");
		
		
		
		em.getTransaction().begin();
		
		em.persist(doce);
		em.persist(p1);
		em.persist(p2);
		em.persist(msg1);
		//Loja doce = em.find(Loja.class, 2L);
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println(doce);
		
	}
}
