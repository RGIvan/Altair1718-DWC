package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="grupos")
public class Grupo implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupo;
	private String nombre;
	
	// asociación 1:N desde la tabla usuarios a la tabla usuariosgrupos
	@OneToMany(mappedBy= "primaryKey.grupo", cascade=CascadeType.ALL)
	private Set<UsuarioGrupo> usuarioGrupos = new HashSet<UsuarioGrupo>();
	
	public Grupo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grupo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<UsuarioGrupo> getUsuarioGrupos() {
		return usuarioGrupos;
	}

	public void setUsuarioGrupos(Set<UsuarioGrupo> usuarioGrupos) {
		this.usuarioGrupos = usuarioGrupos;
	}
}