package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Cliente;

public interface ClienteDAO {
	
	public void guardarCliente(Cliente c);
	
	public void mostrarPaginacion(int pagina);
	
	public void actualizarEmail(String email, int idCliente);
	
	public void actualizarTel(int numTel, int idCliente);
	
	public Cliente get(int i);
	
	public void eliminar(int i);
}