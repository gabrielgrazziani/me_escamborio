package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebFilter("/*")
public class ControladorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		request.setCharacterEncoding("UTF-8");
		
		String url = request.getRequestURI();
		String parametoAcao = url.split("/").length >= 3 ? url.split("/")[2] : "ListarLojas";
		
		if(parametoAcao.equals("CriaProduto") ||
				parametoAcao.equals("file") ||
				parametoAcao.equals("EditaProduto") ||
				parametoAcao.equals("estilo.css") ||
				parametoAcao.equals("sobre.html")){
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		
		String nomeClasse = "dev.gabrielgrazziani.meEscamborio.controller." + parametoAcao;

		Class classe;
		String endereco = "";
		try {
			classe = Class.forName(nomeClasse);
			Acao acao = (Acao) classe.newInstance();
			endereco = acao.executa(request, response);
			
			String[] tipoEEndereco = endereco.split(":");
			if(tipoEEndereco[0].equals("redirect")) {
				response.sendRedirect(tipoEEndereco[1]);			
			}
			else {		
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
				requestDispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			response.sendError(404);
			e.printStackTrace();
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
