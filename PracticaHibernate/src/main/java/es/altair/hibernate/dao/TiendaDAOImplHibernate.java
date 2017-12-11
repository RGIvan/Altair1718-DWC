package es.altair.hibernate.dao;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

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

			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "La tienda ha sido creada satisfactoriamente.", "",
					JOptionPane.INFORMATION_MESSAGE);

			sesion.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			sesion.getTransaction().rollback();
			for (ConstraintViolation cv : e.getConstraintViolations()) {
				UIManager.put("OptionPane.minimumSize", new Dimension(300, 125));
				JOptionPane.showMessageDialog(null, "Campo: " + cv.getPropertyPath(), "                         CAMPO",
						JOptionPane.ERROR_MESSAGE);
				UIManager.put("OptionPane.minimumSize", new Dimension(300, 125));
				JOptionPane.showMessageDialog(null, "Error: " + cv.getMessage(),
						"                         DESCRIPCIÓN DEL ERROR", JOptionPane.ERROR_MESSAGE);
			}
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

	public void actualizar(Tienda t) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			sesion.update(t);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos.", "", JOptionPane.ERROR_MESSAGE);
		} finally {
			sesion.close();
			sf.close();
		}
	}

	public Tienda get(int i) {
		Tienda t = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			t = sesion.get(Tienda.class, i);

			sesion.getTransaction().commit();
		} catch (Exception ex) {

		} finally {
			sesion.close();
			sf.close();
		}

		return t;
	}

	public void eliminar(Tienda t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			sesion.delete(t);

			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "La tienda ha sido eliminada satisfactoriamente.", "",
					JOptionPane.INFORMATION_MESSAGE);

			sesion.getTransaction().commit();
		} catch (Exception ex) {

		} finally {
			sesion.close();
			sf.close();
		}
	}
}