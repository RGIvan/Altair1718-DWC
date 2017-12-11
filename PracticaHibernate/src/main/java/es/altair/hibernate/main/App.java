package es.altair.hibernate.main;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.jboss.jandex.Main;

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

	public static void main(String[] args) {

		boolean salir = true;

		do {

			try {

				// MENÚ DE BIENVENIDA

				UIManager.put("OptionPane.minimumSize", new Dimension(390, 150));
				String var = JOptionPane.showInputDialog(null,
						"1. Tiendas \n" + "2. Clientes \n" + "3. Productos \n" + "4. Ventas \n" + "0) Salir \n" + "\n"
								+ "Introduce un número: ",
						"             BIENVENID@ A SU PROGRAMA DE GESTIÓN DE TIENDAS", JOptionPane.PLAIN_MESSAGE);

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

					// MENU DE GESTIÓN DE TIENDA

					UIManager.put("OptionPane.minimumSize", new Dimension(350, 150));
					String mtienda = JOptionPane.showInputDialog(null,
							"1. Crear una tienda \n" + "2. Listar tiendas \n" + "3. Actualizar una tienda \n"
									+ "4. Borrar una tienda \n" + "0) Salir \n" + "\n" + "Introduce un número: ",
							"                                           MENÚ TIENDAS", JOptionPane.PLAIN_MESSAGE);

					int tienda = Integer.parseInt(mtienda);

					switch (tienda) {

					case 0:

						App.main(null);
						break;
					case 1:

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						String nt = JOptionPane.showInputDialog(null, "Introduzca el nombre de la tienda.", "",
								JOptionPane.QUESTION_MESSAGE);
						
						if (nt != null) {
							
							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							String dir = JOptionPane.showInputDialog(null, "Introduzca la dirección de la tienda.", "",
									JOptionPane.QUESTION_MESSAGE);
							
							Tienda t = new Tienda(nt, dir);

							tDAO.guardar(t);
							
						} else {
							App.main(null);
						}
						
						App.main(null);
						break;
					case 2:
						tiendas = tDAO.listar();

						for (Tienda ts : tiendas) {
							UIManager.put("OptionPane.minimumSize", new Dimension(200, 125));
							JOptionPane.showMessageDialog(null, ts, "          LISTADO DE TIENDAS",
									JOptionPane.INFORMATION_MESSAGE);
						}
						App.main(null);
						break;
					case 3:

						Object[] options = { "Nombre", "Dirección" };

						int elegir = JOptionPane.showOptionDialog(null, "¿Nombre o dirección?", "Elige una opción",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

						if (elegir == JOptionPane.YES_OPTION) {

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							String name = (JOptionPane.showInputDialog(null, "Introduzca un nuevo nombre.", "",
									JOptionPane.QUESTION_MESSAGE));

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							int id = Integer.parseInt((JOptionPane.showInputDialog(null,
									"Introduzca el ID de la tienda.", "", JOptionPane.QUESTION_MESSAGE)));

							Tienda nname = tDAO.get(id);
							nname.setNombre(name);
							tDAO.actualizar(nname);

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							JOptionPane.showMessageDialog(null, "El nombre de la tienda ha sido actualizado.", "",
									JOptionPane.INFORMATION_MESSAGE);

						} else {

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							String direccion = (JOptionPane.showInputDialog(null, "Introduzca una nueva dirección.", "",
									JOptionPane.QUESTION_MESSAGE));

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							int id = Integer.parseInt((JOptionPane.showInputDialog(null,
									"Introduzca el ID de la tienda.", "", JOptionPane.QUESTION_MESSAGE)));

							Tienda ndir = tDAO.get(id);
							ndir.setDireccion(direccion);
							tDAO.actualizar(ndir);

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							JOptionPane.showMessageDialog(null, "La dirección ha sido actualizada.", "",
									JOptionPane.INFORMATION_MESSAGE);
						}
						App.main(null);
						break;
					case 4:

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						int id = Integer.parseInt((JOptionPane.showInputDialog(null, "Introduzca el ID de la tienda.",
								"", JOptionPane.QUESTION_MESSAGE)));
						
						if (id > 0) {
							Tienda ndir = tDAO.get(id);
							tDAO.eliminar(ndir);
							App.main(null);
						} else {
							App.main(null);
						}

						App.main(null);
						break;
					}

				case 2:
					
					// MENU DE GESTIÓN DE CLIENTES

					UIManager.put("OptionPane.minimumSize", new Dimension(350, 150));
					String mcliente = JOptionPane.showInputDialog(null,
							"1. Guardar un cliente \n"
									+ "2. Listar clientes ordenados \n"
									+ "por nombre y apellidos \n"
									+ "3. Actualizar un cliente \n" + "4. Borrar un cliente \n" + "0) Salir \n" + "\n"
									+ "Introduce un número: ",
							"                                        MENÚ CLIENTES", JOptionPane.PLAIN_MESSAGE);

					int cliente = Integer.parseInt(mcliente);

					switch (cliente) {

					case 0:

						App.main(null);
						break;

					case 1:

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre.", "",
								JOptionPane.OK_OPTION);

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						String apellidos = JOptionPane.showInputDialog(null, "Introduzca los apellidos.", "",
								JOptionPane.OK_OPTION);

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						int numTel = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Introduzca el número de teléfono.", "", JOptionPane.OK_OPTION));

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						String email = JOptionPane.showInputDialog(null, "Introduzca un e-mail.", "",
								JOptionPane.OK_OPTION);

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						int id = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Introduzca el ID de la tienda para asignar al cliente.", "",
								JOptionPane.OK_OPTION));

						Tienda t = tDAO.get(id);

						Cliente c = new Cliente(nombre, apellidos, numTel, email, t);

						cDAO.guardarCliente(c);

						App.main(null);
						break;

					case 2:
						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						int pag = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Introduzca un número para mostrar mediante paginación.", "", JOptionPane.OK_OPTION));

						cDAO.mostrarPaginacion(pag);

						App.main(null);
						break;
					}
				}

			} catch (NumberFormatException e) {
				UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
				JOptionPane.showMessageDialog(null, "Introduce un número.", "", JOptionPane.ERROR_MESSAGE);
			}

		} while (salir == true);
	}
}