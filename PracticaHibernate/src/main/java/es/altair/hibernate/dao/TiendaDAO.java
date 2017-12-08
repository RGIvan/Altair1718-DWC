package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Tienda;

public interface TiendaDAO {
	public void guardar(Tienda t);
	
	public List<Tienda> listar();
}
