package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamdori.model.MensagemDao;

public class ExcluirMensagem implements Acao{
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idMensagem = Long.parseLong(request.getParameter("idMensagem"));
	
	
		MensagemDao mensagemDao = new MensagemDao();
		
		mensagemDao.excluir(idMensagem);
		
		mensagemDao.close();
		return "redirect:ListaMensagens";
	}

	
	
}
