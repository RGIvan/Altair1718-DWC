package es.altair.dao;

import java.util.List;

import es.altair.bean.Juego;
import es.altair.bean.Usuario;

public interface JuegoDAO {

	void insertar(Juego j);
	
	List<Juego> listar (Usuario u);
	
	byte[] obtenerPortadaPorId(int idJuego);
}
