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
	private String consola;
	private int a�o;
	private String genero;
	private String estado;
	private String compa�ia;
	private byte[] portada;
	
	@OneToMany(mappedBy = "juego")
	private Set<JuegoUsuario> juegousuario = new HashSet<JuegoUsuario>();
	
	public Juego() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juego(String consola, int a�o, String genero, String estado, String compa�ia, byte[] portada) {
		super();
		this.consola = consola;
		this.a�o = a�o;
		this.genero = genero;
		this.estado = estado;
		this.compa�ia = compa�ia;
		this.portada = portada;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
}