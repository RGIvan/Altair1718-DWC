package dao;

import java.util.List;

import bean.Artista;
import bean.Canciones;
import bean.Estilo;

public interface InterfazDAO {
	
	public List<Artista> listadoArtistas();

	public List<Estilo> listadoEstilo();
	
	public List<Canciones> listadoCanciones();

	public boolean añadirArtista(Artista a);

	public boolean añadirCancion(Canciones c);

	public boolean añadirEstilo(Estilo e);

	public List<Artista> listarEstiloDeterminado(int idEstilo);

	public Artista encontrarArtista(int idArtista);
	
	public Canciones encontrarCancion(int idArtista);

	public List<Canciones> listarCancionesArtista(int idArtista);

	public boolean actualizarEdad(Artista a);

	public boolean actualizarCancion(Canciones c);
	
	public boolean borrarCanciones(int idArtista);
	
	public Canciones paisDistinto(String pais);
}