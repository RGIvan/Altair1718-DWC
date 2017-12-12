package es.altair.hibernate.dao;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import es.altair.hibernate.bean.Venta;
import es.altair.hibernate.main.App;

public class VentaDAOImplHibernate implements VentaDAO {

	public void guardarVenta(Venta v) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();

			sesion.save(v);

			JOptionPane.showMessageDialog(null, "La venta se ha guardado correctamente.", "",
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
			
		} catch (Exception e) {
			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos.", "", JOptionPane.ERROR_MESSAGE);
			App.main(null);
		}
		
		finally {
			sesion.close();
			sf.close();
		}
	}
}