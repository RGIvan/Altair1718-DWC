package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Cliente;

public interface ClienteDAO {
	
	public void guardar(Cliente c);
	
	public void borrar(Cliente c1);
}

