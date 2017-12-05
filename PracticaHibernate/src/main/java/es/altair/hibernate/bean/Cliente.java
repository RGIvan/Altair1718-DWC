package es.altair.hibernate.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="idTienda")
	private Tienda tienda;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String apellidos, int telefono, String email, Tienda tienda) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.tienda = tienda;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", email=" + email + ", tienda=" + tienda + "]";
	}
}