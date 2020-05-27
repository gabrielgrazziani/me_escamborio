package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Produto;
import dev.gabrielgrazziani.meEscamdori.model.ProdutoDao;

public class FormMensagem implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("idProduto"));
		
		ProdutoDao produtoDao = new ProdutoDao();
		
		Produto produto = produtoDao.getProduto(id);
		
		request.setAttribute("produto", produto);
		produtoDao.close();
		return "forward:formMensagem.jsp";
	}

}
