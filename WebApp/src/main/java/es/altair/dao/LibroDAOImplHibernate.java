package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.altair.bean.Libro;
import es.altair.bean.Usuario;
import es.altair.util.SessionProvider;

public class LibroDAOImplHibernate implements LibroDAO {

	public List<Libro> listar(Usuario u) {

		List<Libro> libros = new ArrayList<Libro>();

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			libros = sesion.createQuery("FROM Libro l WHERE usuario=:usu").setParameter("usu", u).list();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		return libros;
	}

	public byte[] obtenerPortadaPorId(int idLibro) {
		byte[] image = null;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			image = (byte[]) sesion.createQuery("Select l.portada From Libro l Where l.idLibro=:id")
					.setParameter("id", idLibro).uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		return image;
	}

	public void borrar(String uuid) {
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			sesion.createQuery("DELETE FROM Libro WHERE uuid=:clave").setParameter("clave", uuid).executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
	}
}