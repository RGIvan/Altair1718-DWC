package es.altair.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.altair.bean.Usuario;
import es.altair.dao.UsuarioDAO;
import es.altair.dao.UsuarioDAOImplHibernate;

/**
 * Servlet implementation class EditarUsuario
 */
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String password = request.getParameter("password");
		String email = request.getParameter("email");
<<<<<<< HEAD
		String uuid = UUID.randomUUID().toString();
=======
>>>>>>> 0fa411028690f9b62b5bb4cc464488e61df2105f

		UsuarioDAO uDAO = new UsuarioDAOImplHibernate();

		HttpSession sesion = request.getSession();

		String msg = "";

		if (uDAO.actualizar(password, email, uuid, ((Usuario) sesion.getAttribute("usuLogeado")))) {

			msg = "Cambio de datos realizado.";

			response.sendRedirect("jsp/inicioUsuario.jsp?mensaje=" + msg);

		} else {

			msg = "No se pudieron actualizar los datos.";

			response.sendRedirect("jsp/inicioUsuario.jsp?mensaje=" + msg);
		}
	}
}