package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.bin.Loja;

//@WebFilter("/AutenticadoFilter")
@MultipartConfig
public class AutenticadoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		String parametoAcao =  url.split("/").length >= 3 ? url.split("/")[2] : "ListarLojas";
		
		List<String> permitidos = Arrays.asList(
				"ListarLojas","ListarProdutosLoja","FormLogin","Login","estilo.css","Tippa.ttf",
				"FormMensagem","CriaMensagem","FormCadastro","CriaLoja","file","sobre.html");
		
		boolean soAutenticado = !permitidos.contains(parametoAcao);
		
		Loja loja = (Loja) request.getSession().getAttribute("loja");
		
		if(soAutenticado && loja == null) {
			response.sendRedirect("ListarLojas");
			return;
		}

		chain.doFilter(request, response);
	}

}
