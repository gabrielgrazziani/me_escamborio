package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamborio.bin.Produto;
import dev.gabrielgrazziani.meEscamborio.infra.SaveImageProduto;
import dev.gabrielgrazziani.meEscamdori.model.ProdutoDao;

@WebServlet("/CriaProduto")
@MultipartConfig
public class CriaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Loja loja = (Loja) request.getSession().getAttribute("loja");
		
		final String nomeProduto = request.getParameter("nomeProduto");
		final String preco = request.getParameter("preco");
		final String descricao = request.getParameter("descricao");
		Part imagem = request.getPart("imagem");
		
		System.out.println("nome: " + nomeProduto + "preço: " + preco);
		
		Produto produto = new Produto();
		produto.setNome(nomeProduto);
		produto.setPreco(new BigDecimal(preco));
		produto.setDescricao(descricao);
		produto.setLoja(loja);
		
		ProdutoDao produtoDao = new ProdutoDao();
		
		produtoDao.save(produto);
		
		SaveImageProduto saveImageProduto = new SaveImageProduto();
		String relativePath = saveImageProduto.save(produto, imagem);
		produto.setImagem(relativePath);
		
		produtoDao.save(produto);
		
		produtoDao.close();
		
		response.sendRedirect("HomeLoja");
	}

}
