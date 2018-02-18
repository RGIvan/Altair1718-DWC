package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.altair.bean.Juego;
import es.altair.bean.Usuario;
import es.altair.util.SessionProvider;

public class JuegoDAOImplHibernate implements JuegoDAO {

	public void insertar(Juego j) {

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			sesion.save(j);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
	}

	public List<Juego> listar(Usuario u) {
		List<Juego> juego = new ArrayList<Juego>();

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			juego = sesion.createQuery("FROM Juego j WHERE usuario=:usu").setParameter("usu", u).list();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return juego;
	}

	public byte[] obtenerPortadaPorId(int idJuego) {
		byte[] imagen = null;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			imagen = (byte[]) sesion.createQuery("SELECT j.portada FROM Juego j Where j.idJuego=:id")
					.setParameter("id", idJuego).uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return imagen;
	}
}