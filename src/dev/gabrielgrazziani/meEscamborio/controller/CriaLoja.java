package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamdori.model.LojaDao;

public class CriaLoja implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeLogista = request.getParameter("nomeLogista");
		String nomeLoja = request.getParameter("nomeLoja");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Loja loja = new Loja(nomeLoja, email, senha);
		loja.setLogista(nomeLogista);
		
		LojaDao lojaDao = new LojaDao();
		
		lojaDao.save(loja);
		
		lojaDao.close();
		
		return "redirect:FormLogin";
	}

}
