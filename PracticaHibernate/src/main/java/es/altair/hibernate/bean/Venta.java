package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	
	@Temporal(TemporalType.DATE)
	private Date fechaVenta;
	private int cantidadVenta;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idProducto")
	private Producto producto;
	
	public Venta() {
		super();
	}
	
	public Venta(Date fechaVenta, int cantidadVenta, Cliente cliente, Producto producto) {
		super();
		this.fechaVenta = fechaVenta;
		this.cantidadVenta = cantidadVenta;
		this.cliente = cliente;
		this.producto = producto;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
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

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fechaVenta=" + fechaVenta + ", cantidadVenta=" + cantidadVenta
				+ ", producto=" + producto + "]";
	}
}