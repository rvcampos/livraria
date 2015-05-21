package br.hebert.fiap.livraria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.hebert.fiap.livraria.dao.CategoriaDAOInterface;
import br.hebert.fiap.livraria.dao.DAOFactory;
import br.hebert.fiap.livraria.model.Categoria;

/**
 * Servlet implementation class CategoriaController
 */
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAOInterface dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriaController() {
		super();
		try {
			dao = DAOFactory.getCategoriaDAO();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if("POST".equals(request.getMethod()))
		{
			response.sendRedirect("../categoria");
		}
		else
		{
			request.setAttribute("categorias", dao.listarCategorias());
			request.getRequestDispatcher("WEB-INF/categorias/listarCategorias.jsp")
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (pathInfo != null) {

			switch (pathInfo.replace("/", "")) {
			case "delete":
				dao.deleteCategoria(Integer.valueOf(request
						.getParameter("id_categoria")));
				request.removeAttribute("categorias");
				break;
			default:
				System.out.println("Passei por aqui");
			}
		}
		doGet(request, response);
	}

}
