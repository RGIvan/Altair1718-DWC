package bean;

public class Canciones {
	private int idCanciones;
	private String nombre;
	private int duracion;
	private int idArtista;

	public Canciones() {
		super();
	}

	public Canciones(int idCanciones, String nombre, int duracion, int idArtista) {
		super();
		this.idCanciones = idCanciones;
		this.nombre = nombre;
		this.duracion = duracion;
		this.idArtista = idArtista;
	}

	public int getIdCanciones() {
		return idCanciones;
	}

	public void setIdCanciones(int idCanciones) {
		this.idCanciones = idCanciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	@Override
	public String toString() {
		return "Canciones [idCanciones=" + idCanciones + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", idArtista=" + idArtista + "]";
	}
}