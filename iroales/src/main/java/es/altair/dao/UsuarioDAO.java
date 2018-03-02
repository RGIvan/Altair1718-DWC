package es.altair.dao;

import java.util.List;

import es.altair.bean.Juego;
import es.altair.bean.Usuario;

public interface UsuarioDAO {

	int insertar(Usuario usu);

	Usuario comprobarUsuario(String login, String password);
	
	Usuario getUsuario(String email);

	boolean validarEmail(Usuario usu);

	boolean validarUsuario(Usuario usu);
	
	boolean actualizar(Usuario usu);
	
	List<Usuario> listarUsuarios ();
}