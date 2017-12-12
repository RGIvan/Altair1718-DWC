package es.altair.hibernate.dao;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import es.altair.hibernate.bean.Producto;
import es.altair.hibernate.main.App;

public class ProductoDAOImplHibernate implements ProductoDAO {

	public void guardarProducto(int cantidad, Date fecha, double precio, String descripcion) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			SQLQuery query = (SQLQuery) sesion.createSQLQuery(
					"INSERT INTO PRODUCTOS (cantidad, fechaCad, precio, descripcion) VALUES (:cantidad, :fecha , :precio, :descripcion)")
					.setParameter("cantidad", cantidad).setParameter("fecha", fecha).setParameter("precio", precio)
					.setParameter("descripcion", descripcion);
			query.executeUpdate();

			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente.", "",
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
			JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos.", "", JOptionPane.ERROR_MESSAGE);
			App.main(null);

		} finally {
			sesion.close();
			sf.close();
		}
	}

	public List<Producto> listarProductosCantidad(int cantidad) {

		List<Producto> productos = new ArrayList<Producto>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			productos = sesion.createCriteria(Producto.class).add(Restrictions.gt("cantidad", cantidad))
					.addOrder(Order.asc("cantidad")).list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "No se pudieron mostrar los datos.", "", JOptionPane.ERROR_MESSAGE);
		} finally {
			sesion.close();
			sf.close();
		}

		return productos;
	}

	public void actualizarCantidad(int cantidad, int idProducto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			SQLQuery query = (SQLQuery) sesion
					.createSQLQuery("UPDATE PRODUCTOS SET cantidad=:cantidad WHERE idProducto=:idProducto")
					.setParameter("cantidad", cantidad).setParameter("idProducto", idProducto);
			query.executeUpdate();

			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "La cantidad se ha actualizado correctamente.", "",
					JOptionPane.INFORMATION_MESSAGE);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "No se pudieron actualizar los datos.", "", JOptionPane.ERROR_MESSAGE);
		} finally {
			sesion.close();
			sf.close();
		}
	}

	public void actualizarPrecio(double precio, int idProducto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			SQLQuery query = (SQLQuery) sesion
					.createSQLQuery("UPDATE PRODUCTOS SET precio=:precio WHERE idProducto=:idProducto")
					.setParameter("precio", precio).setParameter("idProducto", idProducto);
			query.executeUpdate();

			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "El precio se actualizó correctamente.", "",
					JOptionPane.INFORMATION_MESSAGE);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "No se pudieron actualizar los datos.", "", JOptionPane.ERROR_MESSAGE);
		} finally {
			sesion.close();
			sf.close();
		}
	}

	public void eliminar(int idProducto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			SQLQuery query = (SQLQuery) sesion.createSQLQuery("DELETE FROM PRODUCTOS WHERE idProducto=:idProducto")
					.setParameter("idProducto", idProducto);

			query.executeUpdate();

			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "El producto ha sido eliminado.", "", JOptionPane.INFORMATION_MESSAGE);

			sesion.getTransaction().commit();
		}

		catch (Exception exx) {
			UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto.", "", JOptionPane.ERROR_MESSAGE);
			App.main(null);

		} finally {
			sesion.close();
			sf.close();
		}
	}

	public Producto get(int i) {

		Producto p = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {

			sesion.beginTransaction();

			p = (Producto) sesion.createQuery("FROM Producto WHERE idProducto=:id").setParameter("id", i)
					.uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}
		return p;
	}
}