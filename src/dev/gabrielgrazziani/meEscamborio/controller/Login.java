package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;
import dev.gabrielgrazziani.meEscamdori.model.LojaDao;

public class Login implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		LojaDao lojaDao = new LojaDao();
		
		Optional<Loja> lojaOp = lojaDao.getLoja(email);
		
		boolean dadoCorretos = lojaOp.isPresent() && lojaOp.get().senhaCorreta(senha); 
		
		lojaDao.close();
		
		if(dadoCorretos) {
			
			Loja loja = lojaOp.get();
			
			request.getSession()
				.invalidate();
			
			request.getSession()
				.setAttribute("loja", loja);
			
			return "redirect:HomeLoja";
		}
		
		return "redirect:FormLogin";
	}

}
