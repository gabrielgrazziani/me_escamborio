package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamborio.bin.Produto;
import dev.gabrielgrazziani.meEscamdori.model.LojaDao;

public class ListarProdutosLoja implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong((String) request.getParameter("id"));
		
		LojaDao lojaDao = new LojaDao();
		
		Loja loja = lojaDao.getLoja(id);
		
		Collection<Produto> produtos = loja.getProdutos();
		
		request.setAttribute("produtos", produtos);
		
		lojaDao.close();
		return "forward:produtos.jsp";
	}

}
