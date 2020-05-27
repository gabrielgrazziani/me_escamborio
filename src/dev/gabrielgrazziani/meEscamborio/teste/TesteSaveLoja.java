package dev.gabrielgrazziani.meEscamborio.teste;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamdori.model.LojaDao;

public class TesteSaveLoja {

	public static void main(String[] args) {
		LojaDao lojaDao = new LojaDao();
		
		Loja doce = new Loja("doce23", "doce23@gmail.com", "12345");
		
		
		lojaDao.save(doce);
		
		lojaDao.close();
		
		System.out.println(doce.getId());
	}

}
