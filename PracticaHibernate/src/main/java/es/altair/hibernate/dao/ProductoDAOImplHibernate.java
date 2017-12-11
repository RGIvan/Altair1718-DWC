package es.altair.hibernate.dao;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.main.App;

public class ProductoDAOImplHibernate implements ProductoDAO {

	public void guardarProducto(String cantidad, Date fecha, double precio, String descripcion) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			SQLQuery query = sesion.createSQLQuery(
					"INSERT INTO PRODUCTO (cantidad, fecha, precio, descripcion) VALUES (:cantidad, :fecha , :precio, :descripcion)").setParameter(position, val)
			
			query.executeUpdate();

			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "Los datos se han guardado satisfactoriamente.", "",
					JOptionPane.INFORMATION_MESSAGE);

			sesion.getTransaction().commit();
		} catch (ConstraintViolationException ex) {

			for (ConstraintViolation cv : ex.getConstraintViolations()) {
				UIManager.put("OptionPane.minimumSize", new Dimension(300, 125));
				JOptionPane.showMessageDialog(null, "Campo: " + cv.getPropertyPath(), "                         CAMPO",
						JOptionPane.ERROR_MESSAGE);
				UIManager.put("OptionPane.minimumSize", new Dimension(300, 125));
				JOptionPane.showMessageDialog(null, "Error: " + cv.getMessage(),
						"                         DESCRIPCIÓN DEL ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}

		catch (Exception exx) {
			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "No se pudieron actualizar los datos.", "", JOptionPane.ERROR_MESSAGE);
			App.main(null);

		} finally {
			sesion.close();
			sf.close();
		}
	}
}