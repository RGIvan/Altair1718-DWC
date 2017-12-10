package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Tienda;
import es.altair.hibernate.main.App;

public class TiendaDAOImplHibernate implements TiendaDAO {

	public void guardar(Tienda t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			sesion.save(t);

			sesion.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			sesion.close();
			sf.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tienda> listar() {
		List<Tienda> tiendas = new ArrayList<Tienda>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			tiendas = sesion.createQuery("FROM Tienda").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("No se pudo mostrar la lista.");
		} finally {
			sesion.close();
			sf.close();
		}

		return tiendas;
	}

	public Tienda obtenerNombre(String n) {

		Tienda t = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			t = (Tienda) sesion.createQuery("FROM Tienda WHERE nombre=:nombre").setParameter("nombre", n)
					.uniqueResult();
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.err.println("El nombre no existe en la BBDD.");
			App.main(null);

		} finally {
			sesion.close();
			sf.close();
		}

		return t;
	}
}
