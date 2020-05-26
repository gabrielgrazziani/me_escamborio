package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamborio.bin.Produto;

public class CriaProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Loja loja = (Loja) request.getSession().getAttribute("loja");
		
		String nomeProduto = request.getParameter("nomeProduto");
		String preco = request.getParameter("preco");
		String descricao = request.getParameter("descricao");
		
		Produto produto = new Produto();
		produto.setNome(nomeProduto);
		produto.setPreco(new BigDecimal(preco));
		produto.setDescricao(descricao);
		produto.setLoja(loja);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(produto);
		
		em.getTransaction().commit();
		
		return "redirect:HomeLoja";
	}

}
