package br.hebert.fiap.livraria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object usuarioSession = request.getSession().getAttribute("usuarioId");
		if (usuarioSession != null) {
			request.getSession().setAttribute("usuarioId", null);
			request.getSession().setAttribute("usuario", null);
			request.getSession().setAttribute("isAdmin", null);
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("usuarioId", 1);
		request.getSession().setAttribute("usuario",
				request.getParameter("usuario"));
		request.getSession().setAttribute("isAdmin", Boolean.TRUE);
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request,
				response);
	}

}
