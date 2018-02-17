package es.altair.dao;

import es.altair.bean.Usuario;

public interface UsuarioDAO {

	int insertar(Usuario usu);

	Usuario comprobarUsuario(String usuario, String contrase�a);

	boolean validarEmail(Usuario usu);

	boolean validarUsuario(Usuario usu);
}
