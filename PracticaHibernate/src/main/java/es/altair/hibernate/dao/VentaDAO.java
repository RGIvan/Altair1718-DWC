package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Venta;

public interface VentaDAO {
	
	public void guardarVenta(Venta v);
	
	public void eliminar(int idVenta);
}