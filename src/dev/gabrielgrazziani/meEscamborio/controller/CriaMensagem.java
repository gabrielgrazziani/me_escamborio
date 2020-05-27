package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Mensagem;
import dev.gabrielgrazziani.meEscamborio.bin.Produto;
import dev.gabrielgrazziani.meEscamdori.model.MensagemDao;
import dev.gabrielgrazziani.meEscamdori.model.ProdutoDao;

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
		
		MensagemDao mensagemDao = new MensagemDao();
		ProdutoDao produtoDao = new ProdutoDao();
		
		Produto produto = produtoDao.getProduto(idProduto);
		
		mensagem.setProduto(produto);
		mensagemDao.save(mensagem);

		produtoDao.close();
		mensagemDao.close();
		return "redirect:ListarLojas";
	}

}
