package dev.gabrielgrazziani.meEscamborio.teste;

import java.util.List;

import dev.gabrielgrazziani.meEscamborio.bin.Produto;
import dev.gabrielgrazziani.meEscamdori.model.ProdutoDao;

public class TesteProdutoIndex {

	public static void main(String[] args) {
		ProdutoDao produtoDao = new ProdutoDao();
		
		List<Produto> index = produtoDao.index();
		
		index.forEach(System.out::println);
		
		produtoDao.close();
	}

}
