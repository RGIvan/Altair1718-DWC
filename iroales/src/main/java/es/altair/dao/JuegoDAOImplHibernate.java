package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.bean.Juego;
import es.altair.bean.Usuario;

public class JuegoDAOImplHibernate implements JuegoDAO {

	public void insertar(Juego j) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			sesion.save(j);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Juego> listar(Usuario u) {
		List<Juego> juego = new ArrayList<Juego>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			juego = sesion.createQuery("FROM Juego j WHERE usuario=:usu").setParameter("usu", u).list();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

		return juego;
	}

	public byte[] obtenerPortadaPorId(int idJuego) {
		byte[] imagen = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			imagen = (byte[]) sesion.createQuery("SELECT j.portada FROM Juego j Where j.idJuego=:id")
					.setParameter("id", idJuego).uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

		return imagen;
	}

	public void actualizar(String titulo, String consola, int ano, ByteArrayOutputStream os, String uuid, String genero,
			String compania, Usuario usuario) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			if (os != null) {
				sesion.createQuery("UPDATE Juego SET titulo=:t, consola=:c, ano=:a, "
						+ "portada=:p, genero=:g, compania=:i WHERE uuid=:clave").setParameter("t", titulo)
						.setParameter("c", consola).setParameter("a", ano).setParameter("p", os.toByteArray())
						.setParameter("clave", uuid).setParameter("g", genero).setParameter("i", compania)
						.executeUpdate();
			} else {
				sesion.createQuery(
						"UPDATE Juego SET titulo=:t, consola=:c, ano=:a, genero=:g, compania=:i" + " WHERE uuid=:clave")
						.setParameter("t", titulo).setParameter("c", consola).setParameter("a", ano)
						.setParameter("g", genero).setParameter("i", compania).setParameter("clave", uuid)
						.executeUpdate();
			}

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
	}

	public void borrar(String uuid) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();

			sesion.createQuery("DELETE FROM Juego WHERE uuid=:clave").setParameter("clave", uuid).executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
	}
}