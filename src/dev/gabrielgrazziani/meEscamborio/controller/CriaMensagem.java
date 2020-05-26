package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Mensagem;
import dev.gabrielgrazziani.meEscamborio.bin.Produto;

public class CriaMensagem implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idProduto = Long.parseLong(request.getParameter("idProduto"));
		String nome = request.getParameter("nomeComprador");
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		String telefone = request.getParameter("telefone");
		String mensagemString = request.getParameter("mensagem");
		
		Mensagem mensagem = new Mensagem();
		mensagem.setComprador(nome);
		mensagem.setQuantidade(quantidade);
		mensagem.setTelefone(telefone);
		mensagem.setMensagem(mensagemString);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, idProduto);
		
		mensagem.setProduto(produto);
		em.persist(mensagem);
		
		em.getTransaction().commit();
		
		
		return "redirect:ListarLojas";
	}

}
