package es.altair.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Tienda;

public class TiendaDAOImplHibernate implements TiendaDAO {

	public void guardar(Tienda t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.save(t);
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
	}
}
