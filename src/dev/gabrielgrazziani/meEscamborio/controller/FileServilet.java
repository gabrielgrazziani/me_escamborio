package dev.gabrielgrazziani.meEscamborio.controller;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.gabrielgrazziani.meEscamborio.infra.Arquivo;

@WebServlet("/file/*")
public class FileServilet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getRequestURI().split("/file")[1];

		path = !path.equals("/") ? path : "/ProdutoImagem/No-image.png";
		
		Path source = Paths.get(Arquivo.SERVER_PATH + "/" + path);
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String contentType = fileNameMap.getContentTypeFor("file:" + source);

		res.reset();
		res.setContentType(contentType);
		try {
			res.setHeader("Content-Length", String.valueOf(Files.size(source)));
		} catch (NoSuchFileException e) {
			res.sendRedirect("No-image.png");
			return;
		}
		res.setHeader("Content-Disposition", "filename=\"" + source.getFileName().toString() + "\"");
		Arquivo arquivo = new Arquivo();
		arquivo.transfer(source, res.getOutputStream());
	}
}
