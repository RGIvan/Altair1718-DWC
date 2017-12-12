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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;

@Entity
@Table(name="producto")
public class Producto implements Serializable {
	
	@Id
	private int idProducto;
	
	@Max(300)
	private int cantidad;
	
	@Temporal(TemporalType.DATE)
	private Date fechaCad;
	private double precio;
	private String descripcion;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="producto")
	private Set<Venta> venta = new HashSet<Venta>();
	
	public Producto(int cantidad, Date fechaCad, double precio, String descripcion) {
		super();
		this.cantidad = cantidad;
		this.fechaCad = fechaCad;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public Producto() {
		super();
	}
	
	public Set<Venta> getVenta() {
		return venta;
	}

	public void setVenta(Set<Venta> venta) {
		this.venta = venta;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", cantidad=" + cantidad + ", fechaCad=" + fechaCad + ", precio="
				+ precio + ", descripcion=" + descripcion + "]";
	}
}