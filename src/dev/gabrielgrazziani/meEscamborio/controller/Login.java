package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;

public class Login implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select l from Loja l where l.email = :email";
		TypedQuery<Loja> typedQuery = em.createQuery(jpql, Loja.class);
		typedQuery.setParameter("email", email);
		
		Optional<Loja> lojaOp = typedQuery.getResultStream().findFirst();
		
		boolean dadoCorretos = lojaOp.isPresent() && lojaOp.get().senhaCorreta(senha); 
		
		if(dadoCorretos) {
			
			Loja loja = lojaOp.get();
			
			request.getSession()
				.invalidate();
			
			request.getSession()
				.setAttribute("loja", loja);
			
			return "redirect:HomeLoja";
		}
		
		return "redirect:ListarLojas";
	}

}
