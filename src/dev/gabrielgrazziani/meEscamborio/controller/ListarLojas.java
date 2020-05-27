package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamdori.model.LojaDao;

public class ListarLojas implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LojaDao lojaDao = new LojaDao();
		List<Loja> lojas = lojaDao.index();
		request.setAttribute("lojas", lojas);
		
		lojaDao.close();
		return "forward:Lojas.jsp";
	}

}
