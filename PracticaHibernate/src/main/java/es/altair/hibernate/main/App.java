package es.altair.hibernate.main;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import es.altair.hibernate.bean.Cliente;
import es.altair.hibernate.bean.Tienda;
import es.altair.hibernate.dao.ClienteDAO;
import es.altair.hibernate.dao.ClienteDAOImplHibernate;
import es.altair.hibernate.dao.TiendaDAO;
import es.altair.hibernate.dao.TiendaDAOImplHibernate;

public class App {

	public static ClienteDAO cDAO = new ClienteDAOImplHibernate();
	public static TiendaDAO tDAO = new TiendaDAOImplHibernate();
	public static List<Tienda> tiendas = new ArrayList<Tienda>();
	public static Tienda t = new Tienda();
	public static Cliente c1 = new Cliente();

	public static void main(String[] args) {

		boolean salir = true;

		do {

			try {

				// MENÚ DE BIENVENIDA

				UIManager.put("OptionPane.minimumSize", new Dimension(350, 150));
				String var = JOptionPane.showInputDialog(null,
						"1. Crear una tienda \n" + "2. Ingresar en una tienda \n" + "3. Listar tiendas \n"
								+ "0) Salir \n" + "\n" + "Introduce un número: ",
						"             Bienvenid@ a su programa de gestión de tiendas", JOptionPane.NO_OPTION);

				int menu = Integer.parseInt(var);

				switch (menu) {

				case 0:

					// SALIDA

					UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
					JOptionPane.showMessageDialog(null, "Gracias por usar nuestro programa.", "",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
					break;

				case 1:

					// CREACIÓN DE TIENDA

					UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
					String tienda = JOptionPane.showInputDialog(null, "Introduzca el nombre de la tienda.", "",
							JOptionPane.QUESTION_MESSAGE);

					UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
					String direccion = JOptionPane.showInputDialog(null, "Introduzca la dirección de la tienda.", "",
							JOptionPane.QUESTION_MESSAGE);

					t = new Tienda(tienda, direccion);

					tDAO.guardar(t);
					break;

				case 2:

					// MENÚ DE LA TIENDA

					// UIManager.put("OptionPane.minimumSize", new Dimension(350, 150));
					// String dato = JOptionPane.showInputDialog(null, "1. Guardar un cliente \n" +
					// "2. Listar clientes \n"
					// + "3. Actualizar datos de un cliente \n" + "4. Guardar un producto \n"
					// + "5. Listar productos \n" + "6. Actualizar datos de un producto \n"
					// + "7. Comprobar la fecha de un producto \n" + "8. Comprobar las ventas de un
					// producto \n"
					// + "9. Comprobar la fecha de todos los productos \n"
					// + "10. Comprobar las ventas de todos los productos \n" + "0) Volver \n" +
					// "\n"
					// + "Introduce un número: ", " Bienvenid@ a " + nTienda,
					// JOptionPane.NO_OPTION);
					// int submenu = Integer.parseInt(dato);

					UIManager.put("OptionPane.minimumSize", new Dimension(350, 150));
					String dato = JOptionPane.showInputDialog(null,
							"1. Clientes \n" + "2. Productos \n" + "3. Ventas \n" + "0) Volver \n" + "\n"
									+ "Introduce un número: ",
							"                               Bienvenid@ a su tienda", JOptionPane.NO_OPTION);
					int submenu = Integer.parseInt(dato);

					switch (submenu) {

					case 0:
						App.main(null);

					case 1:

						UIManager.put("OptionPane.minimumSize", new Dimension(350, 150));
						String c = JOptionPane.showInputDialog(null,
								"1. Guardar cliente \n" + "2. Listar clientes \n" + "3. Borrar clientes \n"
										+ "4. Actualizar datos de un cliente \n" + "0) Volver \n" + "\n"
										+ "Introduce un número: ",
								"                                   Menú cliente", JOptionPane.NO_OPTION);

						int clientes = Integer.parseInt(c);

						switch (clientes) {
						case 0:
							App.main(null);

						case 1:

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							String nombre = JOptionPane.showInputDialog(null, "Introduzca un nombre.", "",
									JOptionPane.QUESTION_MESSAGE);

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							String apellidos = JOptionPane.showInputDialog(null, "Introduzca los apellidos.", "",
									JOptionPane.QUESTION_MESSAGE);

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							int numTel = Integer.parseInt(JOptionPane.showInputDialog(null,
									"Introduzca un número de teléfono.", "", JOptionPane.QUESTION_MESSAGE));

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							String email = JOptionPane.showInputDialog(null, "Introduzca un email.", "",
									JOptionPane.QUESTION_MESSAGE);

							c1 = new Cliente(nombre, apellidos, numTel, email, t);

							Set<Cliente> cliente = new HashSet<Cliente>();

							cliente.add(c1);

							t.setClientes(cliente);
							cDAO.guardarCliente(c1);
						}

						break;
					}

				case 3:
					tiendas = tDAO.listar();

					for (Tienda ts : tiendas) {
						UIManager.put("OptionPane.minimumSize", new Dimension(200, 125));
						JOptionPane.showMessageDialog(null, ts, "          LISTADO DE TIENDAS",
								JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				}

			} catch (NumberFormatException e) {
				UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
				JOptionPane.showMessageDialog(null, "Introduce un número.", "", JOptionPane.ERROR_MESSAGE);
			}

		} while (salir == true);
	}
}