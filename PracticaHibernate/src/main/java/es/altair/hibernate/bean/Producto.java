package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements Serializable {
	
	@Id
	private int idProducto;
	private String cantidad;
	private Date fechaCad;
	private double precio;
	private String descripcion;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="producto")
	private Set<Venta> venta = new HashSet<Venta>();
	
	public Producto() {
		super();
	}
	
	public Set<Venta> getVenta() {
		return venta;
	}

	public void setVenta(Set<Venta> venta) {
		this.venta = venta;
	}

	public Producto(String cantidad, Date fechaCad, double precio, String descripcion) {
		super();
		this.cantidad = cantidad;
		this.fechaCad = fechaCad;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(Date fechaCad) {
		this.fechaCad = fechaCad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", cantidad=" + cantidad + ", fechaCad=" + fechaCad + ", precio="
				+ precio + ", descripcion=" + descripcion + "]";
	}
}