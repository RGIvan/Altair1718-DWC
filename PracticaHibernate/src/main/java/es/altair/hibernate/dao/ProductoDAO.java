package es.altair.hibernate.dao;

import java.util.Date;

public interface ProductoDAO {
	
	public void guardarProducto(int cantidad, Date fecha, double precio, String descripcion);
}