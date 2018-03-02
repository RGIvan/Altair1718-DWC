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
					.createSQLQuery("INSERT INTO usuarios (login, password, email, tipo)"
							+ " values (:n, AES_ENCRYPT(:p, :passphrase), :e, :t)")
					.setParameter("n", usu.getLogin()).setParameter("p", usu.getPassword())
					.setParameter("passphrase", pass).setParameter("e", usu.getEmail()).setParameter("t", usu.getTipo())
					.executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}
		return filas;
	}

	
	public Usuario comprobarUsuario(String login, String password) {

		Usuario usu = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			usu = (Usuario) sesion
					.createQuery(
							"SELECT u FROM Usuario u WHERE login=:l " + "AND password=AES_ENCRYPT(:p, :passphrase)")
					.setParameter("l", login).setParameter("p", password).setParameter("passphrase", pass)
					.uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

		return usu;
	}

	public boolean validarEmail(Usuario usu) {

		boolean correcto = true;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			if ((Usuario) sesion.createQuery("FROM Usuario WHERE email=:e").setParameter("e", usu.getEmail())
					.uniqueResult() != null)
				correcto = false;

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}
		return correcto;
	}

	public boolean validarUsuario(Usuario usu) {
		
		boolean correcto = true;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			if ((Usuario) sesion.createQuery("FROM Usuario WHERE login=:n").setParameter("n", usu.getLogin())
					.uniqueResult() != null)
				correcto = false;

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sf.close();
		}
		return correcto;
	}
}