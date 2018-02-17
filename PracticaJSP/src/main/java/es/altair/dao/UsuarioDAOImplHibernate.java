package es.altair.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.bean.Usuario;
import es.altair.util.SessionProvider;

public class UsuarioDAOImplHibernate implements UsuarioDAO {

	private String pass = "Usuario123$%";

	@SuppressWarnings("deprecation")
	public int insertar(Usuario usu) {

		int filas = 0;

		Session sesion = SessionProvider.getSession();
		try {

			sesion.beginTransaction();

			filas = sesion
					.createSQLQuery("INSERT INTO usuario (nombre, contraseña, email, tipo)"
							+ " values (:n, AES_ENCRYPT(:p, :passphrase), :e, :t)")
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

	public Usuario comprobarUsuario(String usuario, String contraseña) {

		Usuario usu = null;

		Session sesion = SessionProvider.getSession();

		try {
			sesion.beginTransaction();

			usu = (Usuario) sesion
					.createQuery(
							"SELECT u FROM Usuario u WHERE nombre=:n " + "AND contraseña=AES_ENCRYPT(:p, :passphrase)")
					.setParameter("n", usuario).setParameter("p", contraseña).setParameter("passphrase", pass)
					.uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}

		return usu;
	}

	public boolean validarEmail(Usuario usu) {

		boolean correcto = true;

		Session sesion = SessionProvider.getSession();

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
		}
		return correcto;
	}

	public boolean validarUsuario(Usuario usu) {
		
		boolean correcto = true;

		Session sesion = SessionProvider.getSession();

		try {
			sesion.beginTransaction();

			if ((Usuario) sesion.createQuery("FROM Usuario WHERE nombre=:n").setParameter("n", usu.getNombre())
					.uniqueResult() != null)
				correcto = false;

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		return correcto;
	}
}