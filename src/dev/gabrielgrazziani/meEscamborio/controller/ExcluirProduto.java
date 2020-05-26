package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Produto;

public class ExcluirProduto implements Acao{
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idProduto = Long.parseLong(request.getParameter("idProduto"));
	
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Produto produto = em.find(Produto.class, idProduto);
		
		if(produto != null) {
			em.remove(produto);			
		}
	
		em.getTransaction().commit();
	
		return "redirect:HomeLoja";
	}

	
	
}
