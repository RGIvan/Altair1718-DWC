package es.altair.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;
	private String nombre;
	private String contrase�a;
	private String email;
	private int tipo;

	@OneToMany(cascade=CascadeType.ALL,mappedBy="usuario",fetch = FetchType.EAGER)
	private Set<Juego> juego = new HashSet<Juego>();
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String contrase�a, String email, int tipo) {
		super();
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.email = email;
		this.tipo = tipo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public Set<Juego> getJuego() {
		return juego;
	}

	public void setJuego(Set<Juego> juego) {
		this.juego = juego;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", contrase�a=" + contrase�a + ", email="
				+ email + ", tipo=" + tipo + ", juego=" + juego + "]";
	}
}