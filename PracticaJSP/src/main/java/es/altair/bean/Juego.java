package es.altair.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "juegos")
public class Juego implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idJuego;
	private String titulo;
	private String consola;
	private int ano;
	private String genero;
	private String compañia;
	private byte[] portada;
	private String uuid;

	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Juego(String titulo, String uuid, String consola, int ano, String genero, String compañia, byte[] portada, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.consola = consola;
		this.ano = ano;
		this.genero = genero;
		this.compañia = compañia;
		this.portada = portada;
		this.uuid = uuid;
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo= titulo;
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
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
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Juego [idJuego=" + idJuego + ", titulo=" + titulo + ", consola=" + consola + ", ano=" + ano
				+ ", genero=" + genero + ", compañia=" + compañia + ", portada=" + Arrays.toString(portada) + ", uuid="
				+ uuid + ", usuario=" + usuario + "]";
	}
}