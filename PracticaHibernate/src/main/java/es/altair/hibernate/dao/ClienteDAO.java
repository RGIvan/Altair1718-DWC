package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Cliente;

public interface ClienteDAO {
	
	public void guardarCliente(Cliente c);
	
	public void mostrarPaginacion(int pagina);
}