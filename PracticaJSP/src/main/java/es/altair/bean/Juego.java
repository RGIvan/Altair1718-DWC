package es.altair.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String compañia;
	private byte[] portada;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Juego() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juego(String nombre, String consola, int año, String genero, String compañia, byte[] portada, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.consola = consola;
		this.año = año;
		this.genero = genero;
		this.compañia = compañia;
		this.portada = portada;
		this.usuario = usuario;
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Juego [idJuego=" + idJuego + ", nombre=" + nombre + ", consola=" + consola
				+ ", año=" + año + ", genero=" + genero + ", compañia=" + compañia + ", portada="
				+ Arrays.toString(portada) + ", usuario=" + usuario + "]";
	}
}