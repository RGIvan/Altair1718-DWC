package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipo")
public class Equipo implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTecnico;
	private String fabricante;
	private int ubicacion;
	private Date fecha_registro;
	private int precio_compra;
	
	
	
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipo(int idTecnico, String fabricante, int ubicacion, Date fecha_registro, int precio_compra) {
		super();
		this.idTecnico = idTecnico;
		this.fabricante = fabricante;
		this.ubicacion = ubicacion;
		this.fecha_registro = fecha_registro;
		this.precio_compra = precio_compra;
	}

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public int getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(int precio_compra) {
		this.precio_compra = precio_compra;
	}
}
