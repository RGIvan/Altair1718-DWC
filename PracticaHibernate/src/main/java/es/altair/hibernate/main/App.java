package es.altair.hibernate.main;

import java.util.ArrayList;
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
		String nTienda;

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

				int menu = Integer.parseInt(var);

				switch (menu) {

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
					
					System.out.println("");
					System.out.println("Introduzca el nombre de la tienda.");
					
					nTienda = Leer.dato();
					
					tDAO.obtenerNombre(nTienda);
					
					System.out.println("╔══════════════════════════════════════════════════════════════╗");
					System.out.println("                BIENVENID@ A LA TIENDA: " + nTienda+ "          ");                            
					System.out.println("╠══════════════════════════════════════════════════════════════╣");
					System.out.println("║                                                              ║");
					System.out.println("║  1.- Clientes.                                               ║");
					System.out.println("║                                                              ║");
					System.out.println("║  2.- Productos.                                              ║");
					System.out.println("║                                                              ║");
					System.out.println("║  3.- Ventas.                                                 ║");
					System.out.println("║                                                              ║");
					System.out.println("║  0) Salir.                                                   ║");
					System.out.println("║                                                              ║");
					System.out.println("╚══════════════════════════════════════════════════════════════╝");
					
					System.out.println("");
					System.out.print("Seleccione una de las opciones: ");
					String dato = Leer.dato();

					int submenu = Integer.parseInt(dato);
					
					switch (submenu) {
					
					case 0:
						App.main(null);
						System.out.println("");
					
					case 1:
						System.out.println("╔══════════════════════════════════════════════════════════════╗");
						System.out.println("               	         MENÚ CLIENTES                          ");                            
						System.out.println("╠══════════════════════════════════════════════════════════════╣");
						System.out.println("║                                                              ║");
						System.out.println("║  1.- Guardar un cliente.                                     ║");
						System.out.println("║                                                              ║");
						System.out.println("║  2.- Listar clientes.                                        ║");
						System.out.println("║                                                              ║");
						System.out.println("║  3.- Actualizar datos de un cliente.                         ║");
						System.out.println("║                                                              ║");
						System.out.println("║  0) Volver.                                                  ║");
						System.out.println("║                                                              ║");
						System.out.println("╚══════════════════════════════════════════════════════════════╝");
						
						System.out.println("");
						System.out.print("Seleccione una de las opciones: ");
						String cliente = Leer.dato();
						
					case 2:
						System.out.println("╔══════════════════════════════════════════════════════════════╗");
						System.out.println("               	        MENÚ PRODUCTOS                          ");                            
						System.out.println("╠══════════════════════════════════════════════════════════════╣");
						System.out.println("║                                                              ║");
						System.out.println("║  1.- Clientes.                                               ║");
						System.out.println("║                                                              ║");
						System.out.println("║  2.- Productos.                                              ║");
						System.out.println("║                                                              ║");
						System.out.println("║  3.- Ventas.                                                 ║");
						System.out.println("║                                                              ║");
						System.out.println("║  0) Volver.                                                  ║");
						System.out.println("║                                                              ║");
						System.out.println("╚══════════════════════════════════════════════════════════════╝");
						
						System.out.println("");
						System.out.print("Seleccione una de las opciones: ");
						String producto = Leer.dato();
						
					case 3:
						System.out.println("╔══════════════════════════════════════════════════════════════╗");
						System.out.println("               	        MENÚ VENTAS                             ");                            
						System.out.println("╠══════════════════════════════════════════════════════════════╣");
						System.out.println("║                                                              ║");
						System.out.println("║  1.- Clientes.                                               ║");
						System.out.println("║                                                              ║");
						System.out.println("║  2.- Productos.                                              ║");
						System.out.println("║                                                              ║");
						System.out.println("║  3.- Ventas.                                                 ║");
						System.out.println("║                                                              ║");
						System.out.println("║  0) Volver.                                                  ║");
						System.out.println("║                                                              ║");
						System.out.println("╚══════════════════════════════════════════════════════════════╝");
						
						System.out.println("");
						System.out.print("Seleccione una de las opciones: ");
						String venta = Leer.dato();
					}
					
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