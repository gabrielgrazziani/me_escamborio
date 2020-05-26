package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamborio.controller.Acao;

public class ListarLojas implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select loja from Loja loja";
		
		TypedQuery<Loja> query = em.createQuery(jpql, Loja.class);
		List<Loja> lojas = query.getResultList();
		
		request.setAttribute("lojas", lojas);
		em.close();
		return "forward:Lojas.jsp";
	}

}
