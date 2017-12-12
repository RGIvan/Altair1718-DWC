package es.altair.hibernate.dao;

import java.util.Date;
import java.util.List;

import es.altair.hibernate.bean.Producto;

public interface ProductoDAO {
	
	public void guardarProducto(int cantidad, Date fecha, double precio, String descripcion);
	
	public List<Producto> listarProductosCantidad(int cantidad);
	
	public void actualizarCantidad(int cantidad, int idProducto);
	
	public void actualizarPrecio(double precio, int idProducto);
	
	public void eliminar(int idProducto);
	
	public Producto get(int i);
}