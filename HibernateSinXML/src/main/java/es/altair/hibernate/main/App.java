package es.altair.hibernate.main;

import org.hibernate.Session;

import es.altair.hibernate.util.SessionProvider;
import es.altair.hibernate.bean.Profesor;

public class App 
{
    public static void main( String[] args )
    {
        Profesor p = new Profesor(1234785, "ProfeProfe", "ApeProfe1", "ApeProfe2");
        
        Session session = SessionProvider.getSession();
        
        session.beginTransaction();
        
        session.save(p);
        
        session.getTransaction().commit();
    }
}
