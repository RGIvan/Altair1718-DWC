<%@page import="java.io.OutputStream"%><%@page import="es.altair.dao.JuegoDAOImplHibernate"%><%@page import="es.altair.dao.JuegoDAO"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%
try {
	String idJuego = request.getParameter("imag");
	JuegoDAO jDAO = new JuegoDAOImplHibernate();
	byte[] imagen = jDAO.obtenerPortadaPorId(Integer.parseInt(idJuego));
	try {
		if (imagen != null) {
			response.setContentType("image/jpeg");
			response.setHeader("Content-Disposition", "attachment");
			OutputStream o = response.getOutputStream();
			o.write(imagen);
			o.flush();
			o.close();
			return;
		}
	} catch (IllegalStateException e) {	
	}
} catch (Exception e) {	
}
%>