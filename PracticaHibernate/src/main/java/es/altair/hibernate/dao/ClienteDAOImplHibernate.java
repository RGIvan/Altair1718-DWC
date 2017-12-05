package es.altair.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Cliente;

public class ClienteDAOImplHibernate implements ClienteDAO {

	public void guardar(Cliente c) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.save(c);
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			sesion.close();
			sf.close();
		}
	}

	public void borrar(Cliente c1) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.delete(c1);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
	}
}