package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamborio.bin.Produto;

public class ListarProdutosLoja implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong((String) request.getParameter("id"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		Loja loja = em.find(Loja.class,id);
		
		Collection<Produto> produtos = loja.getProdutos();
		
		request.setAttribute("produtos", produtos);
		//em.close();
		
		return "forward:produtos.jsp";
	}

}
