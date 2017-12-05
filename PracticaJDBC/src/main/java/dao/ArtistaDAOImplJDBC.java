package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Artista;
import bean.Canciones;
import bean.Estilo;

public class ArtistaDAOImplJDBC implements InterfazDAO {

	public List<Artista> listadoArtistas() {

		List<Artista> artistas = new ArrayList<Artista>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ARTISTA";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Artista a = new Artista(resultado.getInt("idArtista"), resultado.getString("nombre"),
						resultado.getString("apellidos"), resultado.getInt("idEstilo"), resultado.getInt("edad"),
						resultado.getString("pais"));
				artistas.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return artistas;
	}

	public List<Estilo> listadoEstilo() {

		List<Estilo> estilo = new ArrayList<Estilo>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ESTILO";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Estilo e = new Estilo(resultado.getInt("idEstilo"), resultado.getString("tipoEstilo"));
				estilo.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return estilo;
	}

	public List<Canciones> listadoCanciones() {

		List<Canciones> cancion = new ArrayList<Canciones>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM CANCIONES";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Canciones a = new Canciones(resultado.getInt("idCanciones"), resultado.getString("nombre"),
						resultado.getInt("duracion"), resultado.getInt("idArtista"));
				cancion.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return cancion;
	}

	public boolean añadirArtista(Artista a) {
		int num_filas = 0;
		ConexionDAO.abrirConexion();
		String query = "INSERT INTO ARTISTA VALUES(null, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, a.getNombre());
			sentencia.setString(2, a.getApellidos());
			sentencia.setInt(3, a.getIdEstilo());
			sentencia.setInt(4, a.getEdad());
			sentencia.setString(5, a.getPais());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public boolean añadirCancion(Canciones c) {

		int num_filas = 0;
		ConexionDAO.abrirConexion();
		String query = "INSERT INTO CANCIONES VALUES(null, ?, ?, ?)";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, c.getNombre());
			sentencia.setInt(2, c.getDuracion());
			sentencia.setInt(3, c.getIdArtista());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public boolean añadirEstilo(Estilo e) {
		int num_filas = 0;
		ConexionDAO.abrirConexion();
		String query = "INSERT INTO ESTILO VALUES(null, ?)";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, e.getTipoEstilo());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException err) {
			err.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public List<Artista> listarEstiloDeterminado(int idEstilo) {

		List<Artista> artistas = new ArrayList<Artista>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ARTISTA WHERE idEstilo = ?";
		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idEstilo);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Artista a = new Artista(resultado.getInt("idArtista"), resultado.getString("nombre"),
						resultado.getString("apellidos"), resultado.getInt("idEstilo"), resultado.getInt("edad"),
						resultado.getString("pais"));
				artistas.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return artistas;
	}

	public List<Canciones> listarCancionesArtista(int idArtista) {

		List<Canciones> cancion = new ArrayList<Canciones>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM CANCIONES WHERE idArtista = ?";
		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idArtista);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Canciones a = new Canciones(resultado.getInt("idCanciones"), resultado.getString("nombre"),
						resultado.getInt("duracion"), resultado.getInt("idArtista"));
				cancion.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return cancion;
	}

	public boolean actualizarEdad(Artista a) {

		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "UPDATE ARTISTA SET edad = ? WHERE idArtista = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, a.getEdad());
			sentencia.setInt(2, a.getIdArtista());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public boolean actualizarCancion(Canciones c) {

		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "UPDATE CANCIONES SET duracion=duracion+1 WHERE idArtista = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, c.getIdArtista());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public Artista encontrarArtista(int idArtista) {
		Artista u = null;

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ARTISTA WHERE idArtista = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idArtista);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				u = new Artista(resultado.getInt("idArtista"), resultado.getString("nombre"),
						resultado.getString("apellidos"), resultado.getInt("idEstilo"), resultado.getInt("edad"),
						resultado.getString("pais"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return u;
	}

	public Canciones encontrarCancion(int idArtista) {
		Canciones u = null;

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM CANCIONES WHERE idArtista = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idArtista);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				u = new Canciones(resultado.getInt("idCanciones"), resultado.getString("nombre"),
						resultado.getInt("duracion"), resultado.getInt("idArtista"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return u;
	}

	public boolean borrarCanciones(int idArtista) {

		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "DELETE FROM CANCIONES WHERE idArtista = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idArtista);

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public Canciones paisDistinto(String pais) {
		Canciones u = null;

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM CANCIONES WHERE idArtista IN (SELECT idArtista FROM ARTISTA WHERE pais = ?)";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, pais);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				u = new Canciones(resultado.getInt("idCanciones"), resultado.getString("nombre"),
						resultado.getInt("duracion"), resultado.getInt("idArtista"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return u;
	}
}