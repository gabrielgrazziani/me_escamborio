package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;

public class HomeLoja implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Loja loja = (Loja) request.getSession().getAttribute("loja");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = emf.createEntityManager();
		
		Loja lojaAtual = entityManager.find(Loja.class, loja.getId());
		
		request.setAttribute("loja", lojaAtual);
		
		return "froward:HomeLoja.jsp";
	}

}
