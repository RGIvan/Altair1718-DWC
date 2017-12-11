package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Venta implements Serializable {
	
	@Id
	private int idVenta;
	private Date fechaVenta;
	private int cantidadVenta;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="venta", 
			joinColumns = { @JoinColumn(name="idProducto") }, 
			inverseJoinColumns = { @JoinColumn(name="idCliente") })
	private Set<Producto> producto = new HashSet<Producto>();
	
	public Venta() {
		super();
	}
	
	public Venta(int idVenta, Date fechaVenta, int cantidadVenta) {
		super();
		this.idVenta = idVenta;
		this.fechaVenta = fechaVenta;
		this.cantidadVenta = cantidadVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getCantidadVenta() {
		return cantidadVenta;
	}

	public void setCantidadVenta(int cantidadVenta) {
		this.cantidadVenta = cantidadVenta;
	}

	public Set<Producto> getProducto() {
		return producto;
	}

	public void setProducto(Set<Producto> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fechaVenta=" + fechaVenta + ", cantidadVenta=" + cantidadVenta
				+ ", producto=" + producto + "]";
	}
}