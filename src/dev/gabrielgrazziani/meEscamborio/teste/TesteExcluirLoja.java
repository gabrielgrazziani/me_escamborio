package dev.gabrielgrazziani.meEscamborio.teste;

import dev.gabrielgrazziani.meEscamdori.model.LojaDao;

public class TesteExcluirLoja {

	public static void main(String[] args) {
		LojaDao lojaDao = new LojaDao();
		
		lojaDao.excluir(2L);
		
		lojaDao.close();
	}

}
