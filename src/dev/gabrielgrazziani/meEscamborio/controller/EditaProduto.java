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

import dev.gabrielgrazziani.meEscamborio.bin.Produto;
import dev.gabrielgrazziani.meEscamborio.infra.SaveImageProduto;
import dev.gabrielgrazziani.meEscamdori.model.ProdutoDao;

@WebServlet("/EditaProduto")
@MultipartConfig
public class EditaProduto extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idProduto = Long.parseLong(request.getParameter("idProduto"));
		
		final String nomeProduto = request.getParameter("nomeProduto");
		final String preco = request.getParameter("preco");
		final String descricao = request.getParameter("descricao");
		final Part imagem = request.getPart("imagem"); 
		
		ProdutoDao produtoDao = new ProdutoDao();
		
		Produto produto = produtoDao.getProduto(idProduto);
		produto.setId(idProduto);
		produto.setNome(nomeProduto);
		produto.setPreco(new BigDecimal(preco));
		produto.setDescricao(descricao);
		
		produtoDao.save(produto);
		
		if(!imagem.getSubmittedFileName().contentEquals("")) {
			SaveImageProduto saveImageProduto = new SaveImageProduto();
			String relativePath = saveImageProduto.save(produto, imagem);
			produto.setImagem(relativePath);
			
			produtoDao.save(produto);	
		}
	
		produtoDao.close();

		response.sendRedirect("HomeLoja");
	}
	
}
