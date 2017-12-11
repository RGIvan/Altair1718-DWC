package es.altair.hibernate.dao;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import es.altair.hibernate.bean.Cliente;

public class ClienteDAOImplHibernate implements ClienteDAO {

	public void guardarCliente(Cliente c) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			sesion.save(c);

			JOptionPane.showMessageDialog(null, "El cliente se ha guardado satisfactoriamente.", "",
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

	public void mostrarPaginacion(int pagina) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			long numClientes = (Long) sesion.createQuery("SELECT count(*) FROM Cliente").uniqueResult();
			int numPaginas = (int) Math.ceil(numClientes / pagina);

			Query query = (Query) sesion.createQuery("FROM Cliente ORDER BY nombre, apellidos").setMaxResults(pagina);

			for (int i = 0; i < numPaginas; i++) {
				UIManager.put("OptionPane.minimumSize", new Dimension(0, 0));
				JOptionPane.showMessageDialog(null, "", "        PÁGINA: " + (i + 1), JOptionPane.DEFAULT_OPTION);
				query.setFirstResult(i * pagina);
				List<Cliente> clientes = query.list();
				for (Cliente cliente : clientes) {
					UIManager.put("OptionPane.minimumSize", new Dimension(150, 100));
					JOptionPane.showMessageDialog(null, cliente, "", JOptionPane.INFORMATION_MESSAGE);
				}
			}

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

	}
}