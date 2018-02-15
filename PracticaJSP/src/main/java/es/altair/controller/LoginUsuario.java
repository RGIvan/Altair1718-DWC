package es.altair.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.altair.bean.Usuario;
import es.altair.dao.UsuarioDAO;
import es.altair.dao.UsuarioDAOImplHibernate;

/**
 * Servlet implementation class LoginUsuario
 */
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String contraseña = request.getParameter("contraseña");
		
		UsuarioDAO uDAO = new UsuarioDAOImplHibernate();
		
		Usuario usu = uDAO.comprobarUsuario(nombre, contraseña);
		if (usu!=null) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuLogeado", usu);
			
			switch (usu.getTipo()) {
			case 0:
				response.sendRedirect("jsp/inicioAdmin.jsp");
				break;
			case 1:
				response.sendRedirect("jsp/inicioUsuario.jsp");
				break;

			default:
				break;
			}
			System.out.println(usu);
		} else {
			response.sendRedirect("index.jsp?mensaje=Usuario o contraseña incorrectos.");
		}
	}
}
