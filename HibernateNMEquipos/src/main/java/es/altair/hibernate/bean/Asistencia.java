package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asistencia")
public class Asistencia implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEquipo;
	private int idTecnico;
	private Date fecha_hora;
	private String motivo;
	
	public Asistencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asistencia(int idEquipo, int idTecnico, Date fecha_hora, String motivo) {
		super();
		this.idEquipo = idEquipo;
		this.idTecnico = idTecnico;
		this.fecha_hora = fecha_hora;
		this.motivo = motivo;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
