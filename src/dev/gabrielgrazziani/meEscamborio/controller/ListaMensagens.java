package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamdori.model.LojaDao;

public class ListaMensagens implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Loja loja = (Loja) request.getSession().getAttribute("loja");
		
		LojaDao lojaDao = new LojaDao();
		
		loja = lojaDao.getLoja(loja.getId());
		
		request.setAttribute("loja", loja);
		
		lojaDao.close();
		return "forward:listaMensagens.jsp";
	}

}
