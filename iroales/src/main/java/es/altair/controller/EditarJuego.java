package es.altair.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import es.altair.bean.Usuario;
import es.altair.dao.JuegoDAO;
import es.altair.dao.JuegoDAOImplHibernate;

/**
 * Servlet implementation class AnadirJuego
 */
@MultipartConfig
public class EditarJuego extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarJuego() {
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

		String titulo = request.getParameter("titulo");

		String consola = request.getParameter("consola");

		int ano = Integer.parseInt(request.getParameter("ano"));

		String genero = request.getParameter("genero");

		String compania = request.getParameter("compania");

		String uuid = request.getParameter("uuid");

		Part filePart = request.getPart("portada");

		InputStream inputS = null;
		ByteArrayOutputStream os = null;
		if (!getFileName(filePart).equals("")) {
			inputS = filePart.getInputStream();

			// Escalar la imagen
			BufferedImage imageBuffer = ImageIO.read(inputS);
			Image tmp = imageBuffer.getScaledInstance(640, 640, BufferedImage.SCALE_FAST);
			BufferedImage buffered = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
			buffered.getGraphics().drawImage(tmp, 0, 0, null);

			os = new ByteArrayOutputStream();
			ImageIO.write(buffered, "jpg", os);
		}

		HttpSession sesion = request.getSession();

		JuegoDAO jDAO = new JuegoDAOImplHibernate();

		String msg = "";

		if (jDAO.actualizar(titulo, consola, ano, os, uuid, genero, compania,
				((Usuario) sesion.getAttribute("usuLogeado")))) {

			msg = "Cambio de datos realizado.";

			response.sendRedirect("jsp/inicioUsuario.jsp?mensaje=" + msg);

		} else {

			msg = "No se pudieron actualizar los datos.";

			response.sendRedirect("jsp/inicioUsuario.jsp?mensaje=" + msg);
		}
	}

	private String getFileName(Part filePart) {
		for (String content : filePart.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
		}
		return null;
	}
}