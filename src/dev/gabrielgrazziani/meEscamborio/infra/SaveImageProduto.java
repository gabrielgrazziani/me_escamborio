package dev.gabrielgrazziani.meEscamborio.infra;

import java.io.IOException;

import javax.servlet.http.Part;

import dev.gabrielgrazziani.meEscamborio.bin.Produto;

public class SaveImageProduto {
	
	public String save(Produto produto,Part part) {
		if(produto.getId() == 0) {
			throw new IllegalArgumentException("O id do produto não pode ser nulo!");
		}
		try {
			String fileName = part.getSubmittedFileName();
			long id = produto.getId();
			
			String relatvePath = "ProdutoImagem/" + id + extensao(fileName);
			
			part.write(Arquivo.SERVER_PATH + "/" + relatvePath);
			
			return relatvePath;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private String extensao(String nameFile) {
		if(nameFile.contains(".")) {
			return nameFile.substring(nameFile.indexOf("."));
		}
		return "";
	}
}
