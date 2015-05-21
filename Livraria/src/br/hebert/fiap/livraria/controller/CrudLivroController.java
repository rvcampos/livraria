package br.hebert.fiap.livraria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.hebert.fiap.livraria.dao.LivroDAO;
import br.hebert.fiap.livraria.dao.impl.CategoriaDAO;

/**
 * Servlet implementation class LivroController
 */
public class CrudLivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivroDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudLivroController() {
        super();
        try {
        	dao = new LivroDAO();
		} catch (Exception e) {
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String livroId = request.getParameter("livroId");
		if(livroId != null)
		{
			// Atualizando um livro
		}
		else
		{
			// Criando um livro
		}
		request.getParameterMap().clear();
	}

}
