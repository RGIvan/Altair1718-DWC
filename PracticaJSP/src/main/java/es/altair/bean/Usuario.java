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
@Table(name="usuarios")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	private String login;
	private String password;
	private String email;
	private int tipo;

	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	private Set<Juego> juego = new HashSet<Juego>();
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String login, String password, String email, int tipo) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.tipo = tipo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setContraseña(String password) {
		this.password = password;
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
		return "Usuario [idUsuario=" + idUsuario + ", login=" + login + ", password=" + password + ", email=" + email
				+ ", tipo=" + tipo + ", juego=" + juego + "]";
	}
}