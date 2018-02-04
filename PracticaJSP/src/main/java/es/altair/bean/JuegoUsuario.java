package es.altair.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import es.altair.bean.Usuario;
import es.altair.bean.Juego;

@Entity
@Table(name="juegousuario")
public class JuegoUsuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJuegoUsuario;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idJuego")
	private Juego juego;

	public JuegoUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JuegoUsuario(Usuario usuario, Juego juego) {
		super();
		this.usuario = usuario;
		this.juego = juego;
	}

	public int getIdJuegoUsuario() {
		return idJuegoUsuario;
	}

	public void setIdJuegoUsuario(int idJuegoUsuario) {
		this.idJuegoUsuario = idJuegoUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
}