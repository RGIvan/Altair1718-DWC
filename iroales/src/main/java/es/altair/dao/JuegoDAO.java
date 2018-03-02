package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.List;

import es.altair.bean.Juego;
import es.altair.bean.Usuario;

public interface JuegoDAO {

	void insertar(Juego j);
	
	List<Juego> listar (Usuario u);
	
	byte[] obtenerPortadaPorId(int idJuego);
	
	void actualizar(String titulo, String consola, int ano, ByteArrayOutputStream os, String uuid, String genero, String compania, Usuario usuario);
	
	void borrar(String uuid);
}