package main;

import java.util.List;
import java.util.Scanner;
import bean.Artista;
import bean.Canciones;
import bean.Estilo;
import dao.InterfazDAO;
import dao.ArtistaDAOImplJDBC;

public class Principal {

	private static Scanner sc = new Scanner(System.in);

	public static InterfazDAO aDAO = new ArtistaDAOImplJDBC();

	public static void main(String[] args) {

		int opcion;

		do {
			System.out.println("╔══════════════════════════════════════════════════════════════╗");
			System.out.println("║                            MENÚ                              ║");
			System.out.println("╠══════════════════════════════════════════════════════════════╣");
			System.out.println("║                                                              ║");
			System.out.println("║  1.- Añadir.                                                 ║");
			System.out.println("║                                                              ║");
			System.out.println("║  2.- Listar.                                                 ║");
			System.out.println("║                                                              ║");
			System.out.println("║  3.- Actualizar.                                             ║");
			System.out.println("║                                                              ║");
			System.out.println("║  4.- Borrar todas las canciones de un determinado artista.   ║");
			System.out.println("║                                                              ║");
			System.out.println("║  5.- Mostrar todo. (artista y sus canciones)                 ║");
			System.out.println("║                                                              ║");
			System.out.println("║  0) Salir.                                                   ║");
			System.out.println("║                                                              ║");
			System.out.println("╚══════════════════════════════════════════════════════════════╝");

			System.out.print("Seleccione una de las opciones: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 0:

				break;
			case 1:

				try {

					System.out.println("");
					System.out.println("¿Qué desea añadir?");
					System.out.println("");
					System.out.println("1. Artista.");
					System.out.println("2. Canción.");
					System.out.println("3. Estilo.");

					String num = sc.next();

					int artista = Integer.parseInt(num);
					int cancion = Integer.parseInt(num);
					int estilo = Integer.parseInt(num);

					if (artista > 3) {
						System.out.println("");
						System.err.println("Introduce un número del uno al tres.");
						System.out.println("");
					}

					if (artista == 1) {

						System.out.println("");
						System.out.println("Introduzca un nombre: ");
						System.out.println("");

						String nombre = sc.next();

						System.out.println("");
						System.out.println("Introduzca un apellido: ");
						System.out.println("");

						String apellidos = sc.next();

						listadoEstilo();

						System.out.println("");
						System.out.println("Introduzca un estilo para el artista: (código) ");
						System.out.println("");

						int estiloArtista = sc.nextInt();

						System.out.println("");
						System.out.println("Introduzca la edad del artista: ");
						System.out.println("");

						int edad = sc.nextInt();

						System.out.println("");
						System.out.println("Introduzca su país: ");
						System.out.println("");

						String pais = sc.next();

						Artista a = new Artista(0, nombre, apellidos, estiloArtista, edad, pais);

						if (aDAO.añadirArtista(a)) {
							System.out.println("");
							System.out.println("El artista ha sido añadido correctamente.");
							System.out.println("");
						} else {
							System.out.println("");
							System.err.println("El artista no ha podido ser añadido. Verifique de nuevo los datos.");
							System.out.println("");
						}
					}

					if (cancion == 2) {

						System.out.println("");
						System.out.println("Introduzca un nombre para la canción: ");
						System.out.println("");

						String nombreCancion = sc.next();

						System.out.println("");
						System.out.println("Introduzca la duración de la canción: (min) ");
						System.out.println("");

						int duracion = sc.nextInt();

						listadoArtistas();

						System.out.println("");
						System.out.println("Seleccione el artista con un número: (código) ");
						System.out.println("");

						String id = sc.next();
						int idArtista = Integer.parseInt(id);

						Canciones c = new Canciones(0, nombreCancion, duracion, idArtista);

						if (aDAO.añadirCancion(c)) {
							System.out.println("");
							System.out.println("La canción ha sido añadida correctamente.");
							System.out.println("");
						} else {
							System.err.println("La canción no ha podido ser añadida. Verifique de nuevo los datos.");
							System.out.println("");
							System.err.println("Número de artista introducido: " + idArtista);
							System.out.println("");
						}
					}

					if (estilo == 3) {
						System.out.println("");
						System.out.println("Introduzca un nuevo estilo: ");
						System.out.println("");

						String nuevoEstilo = sc.next();

						Estilo es = new Estilo(0, nuevoEstilo);

						if (aDAO.añadirEstilo(es)) {
							System.out.println("");
							System.out.println("El nuevo estilo se ha añadido correctamente.");
							System.out.println("");
						} else {
							System.out.println("");
							System.err.println("El estilo no ha sido añadido. Verifique de nuevo los datos.");
							System.out.println("");
						}
					}

				} catch (NumberFormatException e) {
					System.out.println("");
					System.err.println("No has introducido un número.");
					System.out.println("");
				}

				break;

			case 2:

				try {

					System.out.println("");
					System.out.println("¿Qué desea hacer?");
					System.out.println("");
					System.out.println("1. Listar todos los artistas de un determinado estilo.");
					System.out.println("2. Listar todas las canciones de un artista.");

					String num = sc.next();

					int artistaEstilo = Integer.parseInt(num);

					if (artistaEstilo > 2) {
						System.out.println("");
						System.err.println("Introduce un número del uno al tres.");
						System.out.println("");
					}

					if (artistaEstilo == 1) {

						listadoEstilo();

						System.out.println("");
						System.out.println("Introduce un estilo: (código) ");
						System.out.println("");

						String estilo = sc.next();

						int idEstilo = Integer.parseInt(estilo);

						List<Artista> artista = aDAO.listarEstiloDeterminado(idEstilo);

						for (Artista lista : artista) {
							System.out.println("");
							System.out.println("Nombre: " + lista.getNombre() + "\nApellidos: " + lista.getApellidos());
							System.out.println("");
						}
					}

					if (artistaEstilo == 2) {

						listadoArtistas();

						System.out.println("");
						System.out.println("Introduce un artista: (código) ");
						System.out.println("");

						String artista = sc.next();

						int idArtista = Integer.parseInt(artista);

						List<Canciones> canciones = aDAO.listarCancionesArtista(idArtista);

						System.out.println("---------------------");
						System.out.println("CANCIONES DEL ARTISTA");
						System.out.println("---------------------");
						System.out.println("");

						for (Canciones lista : canciones) {
							System.out.println(lista.getNombre());
						}
						System.out.println("");
					}

				} catch (NumberFormatException e) {
					System.out.println("");
					System.err.println("No has introducido un número.");
					System.out.println("");
				}
				break;

			case 3:

				try {
					System.out.println("");
					System.out.println("¿Qué desea hacer?");
					System.out.println("");
					System.out.println("1. Actualizar la edad de un artista.");
					System.out.println("2. Actualizar la duración de las canciones a un minuto de un artista.");
					System.out.println(
							"3. Actualizar la duración de las canciones a un minuto de los artistas de un determinado país.");

					String num = sc.next();

					int actualizar = Integer.parseInt(num);

					if (actualizar > 3) {
						System.out.println("");
						System.err.println("Introduce un número del uno al tres.");
						System.out.println("");
					}

					if (actualizar == 1) {

						listadoArtistasEdad();

						System.out.println("");
						System.out.println("Introduce un artista para actualizar su edad: (código) ");
						System.out.println("");

						String id = sc.next();

						int idArtista = Integer.parseInt(id);

						Artista art = aDAO.encontrarArtista(idArtista);

						if (art != null) {

							System.out.println("");
							System.out.println("Introduce la edad del artista: ");
							System.out.println("");

							String ed = sc.next();

							int edad = Integer.parseInt(ed);

							art.setEdad(edad);

							Artista artistas = aDAO.encontrarArtista(idArtista);

							if (aDAO.actualizarEdad(art)) {
								System.out.println("");
								System.out.println("Nombre: " + artistas.getNombre() + "\nApellidos: "
										+ artistas.getApellidos() + "\nEdad actualizada: " + edad);
								System.out.println("");
							} else {
								System.out.println("");
								System.out.println("La edad no ha sido actualizada.");
								System.out.println("");
							}
						}
					}

					if (actualizar == 2) {

						listadoArtistas();

						System.out.println("");
						System.out.println("Introduce un artista: (código) ");
						System.out.println("");

						String idArtista = sc.next();

						int art = Integer.parseInt(idArtista);

						Canciones cancion = aDAO.encontrarCancion(art);

						if (aDAO.actualizarCancion(cancion)) {
							System.out.println("");
							System.out.println("Las canciones han sido actualizadas.");
							System.out.println("");
						} else {
							System.out.println("");
							System.out.println("Las canciones no han sido actualizadas.");
							System.out.println("");
						}
					}

					if (actualizar == 3) {

						System.out.println("");
						System.out.println("Introduce un país: ");
						System.out.println("");
						
						String pais = sc.next();

						Canciones u = aDAO.paisDistinto(pais);
						
						if(aDAO.actualizarCancion(u)) {
							System.out.println("");
							System.out.println("Las canciones han sido actualizadas.");
							System.out.println("");
						}else {
							System.out.println("");
							System.out.println("Las canciones no han sido actualizadas.");
							System.out.println("");
						}
						
					}

				} catch (NumberFormatException e) {
					System.out.println("");
					System.err.println("No has introducido un número.");
					System.out.println("");
				}
				break;
			case 4:

				try {
					
					listadoArtistas();
					
					System.out.println("");
					System.out.println("Introduce un artista: (código) ");
					System.out.println("");

					String idArtista = sc.next();

					int art = Integer.parseInt(idArtista);
					
					if (aDAO.borrarCanciones(art)) {
						System.out.println("");
						System.out.println("Las canciones del artista han sido eliminadas.");
						System.out.println("");
					} else {
						System.out.println("");
						System.out.println("Las canciones no han sido eliminadas.");
						System.out.println("");
					}

				} catch (NumberFormatException e) {
					System.out.println("");
					System.err.println("No has introducido un número.");
					System.out.println("");
				}
				break;
			case 5:
				listarTodo();
				break;
			}

		} while (opcion != 0);
	}

	private static void listadoArtistas() {
		List<Artista> artistas = aDAO.listadoArtistas();
		for (Artista artista : artistas) {
			System.out.println("");
			System.out.println("Nombre: " + artista.getNombre() + "\nApellidos: " + artista.getApellidos()
					+ "\nCódigo: " + artista.getIdArtista());
		}
	}

	private static void listarTodo() {
		List<Artista> artistas = aDAO.listadoArtistas();
		List<Canciones> cancion = aDAO.listadoCanciones();

		System.out.println("");
		System.out.println("------------------------------------");
		System.out.println("------------CANCIONES---------------");
		System.out.println("------------------------------------");
		System.out.println("");

		for (Canciones canciones : cancion) {
			if (aDAO.listadoCanciones() != null) {
				System.out.println("Nombre de la canción: " + canciones.getNombre() + "\nDuración de la canción: "
						+ canciones.getDuracion() + " minuto(s)");
				System.out.println("\n");
			}
		}

		System.out.println("------------------------------------");
		System.out.println("-------------ARTISTAS---------------");
		System.out.println("------------------------------------");
		System.out.println("");

		for (Artista artista : artistas) {
			if (aDAO.listadoArtistas() != null) {
				System.out.println("Nombre del artista: " + artista.getNombre() + "\nApellidos del artista: "
						+ artista.getApellidos());
				System.out.println("");
			}
		}
	}

	private static void listadoArtistasEdad() {
		List<Artista> artistas = aDAO.listadoArtistas();
		for (Artista artista : artistas) {
			System.out.println("");
			System.out.println("Nombre del artista: " + artista.getNombre() + " " + artista.getApellidos()
					+ "\nCódigo: " + artista.getIdArtista() + "\nEdad: " + artista.getEdad());
		}
	}

	private static void listadoEstilo() {
		List<Estilo> estilos = aDAO.listadoEstilo();
		for (Estilo estilo : estilos) {
			System.out.println("");
			System.out.println("Tipo de estilo: " + estilo.getTipoEstilo() + "\nCódigo: " + estilo.getIdEstilo());
		}
	}
}