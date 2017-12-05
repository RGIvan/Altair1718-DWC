package es.altair.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import es.altair.hibernate.bean.Cliente;
import es.altair.hibernate.bean.Tienda;
import es.altair.hibernate.dao.ClienteDAO;
import es.altair.hibernate.dao.ClienteDAOImplHibernate;
import es.altair.hibernate.dao.TiendaDAO;
import es.altair.hibernate.dao.TiendaDAOImplHibernate;

public class App 
{
    public static void main( String[] args ){
    	
    	ClienteDAO cDAO = new ClienteDAOImplHibernate();
    	TiendaDAO tDAO = new TiendaDAOImplHibernate();
    	
    	Tienda t1 = new Tienda("tienda S.L", "C/ tienda1");
    	
//    	Cliente c1 = new Cliente("Pepe", "García", 123456789, "pepe@gmail.com", t1);
//    	Cliente c2 = new Cliente("Paco", "García", 123456789, "paco@gmail.com", t1);
//    	Cliente c3 = new Cliente("Marta", "García", 123456789, "marta@gmail.com", t1);
//    	
//    	Set<Cliente> clientes = new HashSet<Cliente>();
//    	
//    	clientes.add(c1);
//    	clientes.add(c2);
//    	clientes.add(c3);
//    	t1.setClientes(clientes);
    	
    	System.out.println("----- GUARDAR TIENDA ------");
    	
    	tDAO.guardar(t1);
    }
}