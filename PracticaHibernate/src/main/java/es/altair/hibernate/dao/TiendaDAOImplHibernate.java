package es.altair.hibernate.dao;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

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

	public List<Tienda> listar() {
		List<Tienda> tiendas = new ArrayList<Tienda>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			tiendas = sesion.createQuery("FROM Tienda").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "No se pudo mostrar la lista.", "", JOptionPane.ERROR_MESSAGE);
		} finally {
			sesion.close();
			sf.close();
		}

		return tiendas;
	}

	public Tienda obtener(int i) {

		Tienda t = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			t = (Tienda) sesion.createQuery("FROM Tienda WHERE idTienda=:id").setParameter("id", i)
					.uniqueResult();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "El ID o el nombre no coinciden o no existen en la BBDD.", "",
					JOptionPane.ERROR_MESSAGE);
			App.main(null);

		} finally {
			sesion.close();
			sf.close();
		}

		return t;
	}
}