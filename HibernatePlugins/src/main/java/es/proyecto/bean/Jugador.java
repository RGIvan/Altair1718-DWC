package es.proyecto.bean;
// Generated 21-nov-2017 10:39:12 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Jugador generated by hbm2java
 */
@Entity
@Table(name = "jugador", catalog = "hibernate2")
public class Jugador implements java.io.Serializable {

	private Integer idJugador;
	private Equipo equipo;
	private String nombre;
	private String posicion;

	public Jugador() {
	}

	public Jugador(Equipo equipo, String nombre, String posicion) {
		this.equipo = equipo;
		this.nombre = nombre;
		this.posicion = posicion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idJugador", unique = true, nullable = false)
	public Integer getIdJugador() {
		return this.idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEquipo", nullable = false)
	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "posicion", nullable = false, length = 45)
	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

}
