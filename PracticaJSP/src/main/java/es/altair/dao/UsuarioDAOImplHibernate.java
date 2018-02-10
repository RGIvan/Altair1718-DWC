package es.altair.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.bean.Usuario;

public class UsuarioDAOImplHibernate implements UsuarioDAO {

	private String pass = "Usuario123$%";

	public int insertar(Usuario usu) {

		int filas = 0;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			
			sesion.beginTransaction();

			filas = sesion
					.createSQLQuery("INSERT INTO usuario (nombre, contraseña, email, tipo)"
							+ "values (:n, AES_ENCRYPT(:p, :passphrase), :e, :t)")
					.setParameter("n", usu.getNombre()).setParameter("p", usu.getContraseña())
					.setParameter("passphrase", pass).setParameter("e", usu.getEmail()).setParameter("t", usu.getTipo())
					.executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		return filas;
	}
}