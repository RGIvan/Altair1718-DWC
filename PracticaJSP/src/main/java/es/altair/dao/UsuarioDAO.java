package es.altair.dao;

import es.altair.bean.Usuario;

public interface UsuarioDAO {

	int insertar(Usuario usu);

	Usuario comprobarUsuario(String usuario, String contraseņa);

	boolean validarEmail(Usuario usu);
}
