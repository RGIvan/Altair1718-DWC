package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.List;

import es.altair.bean.Juego;
import es.altair.bean.Usuario;

public interface JuegoDAO {

	void insertar(Juego j);
	
	List<Juego> listar (Usuario u);
	
	byte[] obtenerPortadaPorId(int idJuego);

	public void actualizar(String titulo, String uuid, String consola, int ano, String genero, String compañia,
			ByteArrayOutputStream os, Usuario usuario);
}