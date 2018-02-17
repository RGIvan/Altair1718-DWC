package es.altair.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstado;
	private int idJuego;
	private String completado;
	private String enproceso;
	private String nocompletado;
	private String finalizado;
	
	@ManyToOne
	@JoinColumn(name="idJuego")
	private Juego juego;
	
	public Estado(int idJuego, String completado, String enproceso, String nocompletado, String finalizado) {
		super();
		this.idJuego = idJuego;
		this.completado = completado;
		this.enproceso = enproceso;
		this.nocompletado = nocompletado;
		this.finalizado = finalizado;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public String getCompletado() {
		return completado;
	}

	public void setCompletado(String completado) {
		this.completado = completado;
	}

	public String getEnproceso() {
		return enproceso;
	}

	public void setEnproceso(String enproceso) {
		this.enproceso = enproceso;
	}

	public String getNocompletado() {
		return nocompletado;
	}

	public void setNocompletado(String nocompletado) {
		this.nocompletado = nocompletado;
	}

	public String getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(String finalizado) {
		this.finalizado = finalizado;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", idJuego=" + idJuego + ", completado=" + completado + ", enproceso="
				+ enproceso + ", nocompletado=" + nocompletado + ", finalizado=" + finalizado + ", juego=" + juego
				+ "]";
	}
}
