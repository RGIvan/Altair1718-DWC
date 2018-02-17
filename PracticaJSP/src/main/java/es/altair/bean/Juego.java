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
	private int a�o;
	private String genero;
	private String compa�ia;
	private byte[] portada;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Juego() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juego(String nombre, String consola, int a�o, String genero, String compa�ia, byte[] portada, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.consola = consola;
		this.a�o = a�o;
		this.genero = genero;
		this.compa�ia = compa�ia;
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

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompa�ia() {
		return compa�ia;
	}

	public void setCompa�ia(String compa�ia) {
		this.compa�ia = compa�ia;
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
				+ ", a�o=" + a�o + ", genero=" + genero + ", compa�ia=" + compa�ia + ", portada="
				+ Arrays.toString(portada) + ", usuario=" + usuario + "]";
	}
}