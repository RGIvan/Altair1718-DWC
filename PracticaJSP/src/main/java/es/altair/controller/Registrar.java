package es.altair.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.altair.bean.Usuario;
import es.altair.dao.UsuarioDAO;
import es.altair.dao.UsuarioDAOImplHibernate;

/**
 * Servlet implementation class Registrar
 */
public class Registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registrar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String contraseña = request.getParameter("contraseña");
		String email = request.getParameter("email");

		Usuario usu = new Usuario(nombre, contraseña, email, 1);

		UsuarioDAO uDAO = new UsuarioDAOImplHibernate();

		int filas = 0;
		String msg = "";

		filas = uDAO.insertar(usu);
		if (filas == 1) {

			msg = "¡Usuario registrado con éxito!";

			response.sendRedirect("index.jsp?mensaje=" + msg);
			
		} else {
			
			msg = "¡El usuario no ha sido registrado!";

			response.sendRedirect("index.jsp?mensaje=" + msg);
		}
	}
}