package es.altair.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "juego")
public class Juego implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idJuego;
	private String nombre;
	private String consola;
	private int año;
	private String genero;
	private String estado;
	private String compañia;
	private byte[] portada;
	
	@OneToMany(mappedBy = "juego")
	private Set<JuegoUsuario> juegousuario = new HashSet<JuegoUsuario>();
	
	public Juego() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juego(String nombre, String consola, int año, String genero, String estado, String compañia, byte[] portada) {
		super();
		this.nombre = nombre;
		this.consola = consola;
		this.año = año;
		this.genero = genero;
		this.estado = estado;
		this.compañia = compañia;
		this.portada = portada;
	}

	public Set<JuegoUsuario> getJuegousuario() {
		return juegousuario;
	}

	public void setJuegousuario(Set<JuegoUsuario> juegousuario) {
		this.juegousuario = juegousuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public String getConsola() {
		return consola;
	}

	public void setConsola(String consola) {
		this.consola = consola;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public byte[] getPortada() {
		return portada;
	}

	public void setPortada(byte[] portada) {
		this.portada = portada;
	}
}