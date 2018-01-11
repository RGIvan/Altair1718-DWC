package es.altair.dao;

import java.util.List;

import es.altair.bean.Libro;
import es.altair.bean.Usuario;

public interface LibroDAO {
	
	List<Libro> listar (Usuario u);
	
	byte[] obtenerPortadaPorId(int idLibro);
	
	void borrar(String uuid);
	
	Libro ObtenerLibroPorUUID(String uuid);
}