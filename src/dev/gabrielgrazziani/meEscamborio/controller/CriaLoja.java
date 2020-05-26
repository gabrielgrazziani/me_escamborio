package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;

public class CriaLoja implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeLogista = request.getParameter("nomeLogista");
		String nomeLoja = request.getParameter("nomeLoja");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Loja loja = new Loja(nomeLoja, email, senha);
		loja.setLogista(nomeLogista);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(loja);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return "redirect:FormLogin";
	}

}
