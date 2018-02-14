package es.altair.dao;

import org.hibernate.Session;

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
}