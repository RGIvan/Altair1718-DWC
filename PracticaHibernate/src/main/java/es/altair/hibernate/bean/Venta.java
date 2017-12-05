package es.altair.hibernate.bean;

import java.util.Date;

public class Venta {
	private int idVenta;
	private int idProducto;
	private int idCliente;
	private Date fechaVenta;
	private int cantidadVenta;
	
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(int idProducto, int idCliente, Date fechaVenta, int cantidadVenta) {
		super();
		this.idProducto = idProducto;
		this.idCliente = idCliente;
		this.fechaVenta = fechaVenta;
		this.cantidadVenta = cantidadVenta;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
		return "Venta [idVenta=" + idVenta + ", idProducto=" + idProducto + ", idCliente=" + idCliente + ", fechaVenta="
				+ fechaVenta + ", cantidadVenta=" + cantidadVenta + "]";
	}
}