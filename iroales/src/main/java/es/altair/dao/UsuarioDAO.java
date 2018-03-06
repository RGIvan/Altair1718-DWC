package es.altair.dao;

import java.util.List;

import es.altair.bean.Juego;
import es.altair.bean.Usuario;

public interface UsuarioDAO {

	int insertar(Usuario usu);

	Usuario comprobarUsuario(String login, String password);

	boolean validarEmail(Usuario usu);

	boolean validarUsuario(Usuario usu);
	
	boolean actualizar(String password, String email, String uuid, Usuario usu);
	
	List<Usuario> listarUsuarios ();
}