package es.altair.hibernate.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.altair.hibernate.bean.Tienda;
import es.altair.hibernate.dao.ClienteDAO;
import es.altair.hibernate.dao.ClienteDAOImplHibernate;
import es.altair.hibernate.dao.TiendaDAO;
import es.altair.hibernate.dao.TiendaDAOImplHibernate;

public class App {

	public static ClienteDAO cDAO = new ClienteDAOImplHibernate();
	public static TiendaDAO tDAO = new TiendaDAOImplHibernate();
	public static List<Tienda> tiendas = new ArrayList<Tienda>();

	public static void main(String[] args) {

		boolean salir = true;

		do {

			try {

				System.out.println("╔══════════════════════════════════════════════════════════════╗");
				System.out.println("║        BIENVENID@ AL PROGRAMA DE GESTIÓN DE TIENDAS          ║");
				System.out.println("╠══════════════════════════════════════════════════════════════╣");
				System.out.println("║                                                              ║");
				System.out.println("║  1.- Crear una tienda.                                       ║");
				System.out.println("║                                                              ║");
				System.out.println("║  2.- Ingresar en una tienda.                                 ║");
				System.out.println("║                                                              ║");
				System.out.println("║  3.- Listar tiendas.                                         ║");
				System.out.println("║                                                              ║");
				System.out.println("║  0) Salir.                                                   ║");
				System.out.println("║                                                              ║");
				System.out.println("╚══════════════════════════════════════════════════════════════╝");

				System.out.println("");
				System.out.print("Seleccione una de las opciones: ");
				String var = Leer.dato();

				int opcion = Integer.parseInt(var);

				switch (opcion) {

				case 0:
					salir = false;
					System.out.println("");
					System.out.println("Gracias por usar nuestro programa.");
					System.out.println("");
					break;

				case 1:

					System.out.println("");
					System.out.println("Introduzca el nombre de la tienda.");
					System.out.println("");

					String tienda = Leer.dato();

					System.out.println("");
					System.out.println("Introduzca la dirección de la tienda.");
					System.out.println("");

					String direccion = Leer.dato();

					Tienda t = new Tienda(tienda, direccion);

					tDAO.guardar(t);

				case 2:
					break;

				case 3:
					tiendas = tDAO.listar();
					
					for (Tienda ts : tiendas) {
						System.out.println(ts);
					}
				}

			} catch (NumberFormatException e) {
				System.out.println("");
				System.err.println("Introduce un número.");
			}

		} while (salir == true);
	}
}