package es.altair.hibernate.main;

import java.awt.Dimension;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import es.altair.hibernate.bean.Cliente;
import es.altair.hibernate.bean.Tienda;
import es.altair.hibernate.dao.ClienteDAO;
import es.altair.hibernate.dao.ClienteDAOImplHibernate;
import es.altair.hibernate.dao.ProductoDAO;
import es.altair.hibernate.dao.ProductoDAOImplHibernate;
import es.altair.hibernate.dao.TiendaDAO;
import es.altair.hibernate.dao.TiendaDAOImplHibernate;
import es.altair.hibernate.dao.VentaDAO;
import es.altair.hibernate.dao.VentaDAOImplHibernate;

public class App {

	public static ClienteDAO cDAO = new ClienteDAOImplHibernate();
	public static TiendaDAO tDAO = new TiendaDAOImplHibernate();
	public static ProductoDAO pDAO = new ProductoDAOImplHibernate();
	public static VentaDAO vDAO = new VentaDAOImplHibernate();
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

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						String dir = JOptionPane.showInputDialog(null, "Introduzca la dirección de la tienda.", "",
								JOptionPane.QUESTION_MESSAGE);

						Tienda t = new Tienda(nt, dir);

						tDAO.guardar(t);
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

						Tienda ndir = tDAO.get(id);
						tDAO.eliminar(ndir);
						App.main(null);
						break;
					}

				case 2:

					// MENU DE GESTIÓN DE CLIENTES

					UIManager.put("OptionPane.minimumSize", new Dimension(350, 150));
					String mcliente = JOptionPane.showInputDialog(null,
							"1. Guardar un cliente \n" + "2. Listar clientes ordenados \n" + "por nombre y apellidos \n"
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
								JOptionPane.QUESTION_MESSAGE);

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						String apellidos = JOptionPane.showInputDialog(null, "Introduzca los apellidos.", "",
								JOptionPane.QUESTION_MESSAGE);

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						int numTel = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Introduzca el número de teléfono.", "", JOptionPane.QUESTION_MESSAGE));

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						String email = JOptionPane.showInputDialog(null, "Introduzca un e-mail.", "",
								JOptionPane.QUESTION_MESSAGE);

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						int id = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Introduzca el ID de la tienda para asignar al cliente.", "",
								JOptionPane.QUESTION_MESSAGE));

						Tienda t = tDAO.get(id);

						Cliente c = new Cliente(nombre, apellidos, numTel, email, t);

						cDAO.guardarCliente(c);

						App.main(null);
						break;

					case 2:
						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						int pag = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Introduzca un número para mostrar mediante paginación.", "",
								JOptionPane.QUESTION_MESSAGE));

						cDAO.mostrarPaginacion(pag);

						App.main(null);
						break;

					case 3:

						Object[] options = { "Teléfono", "E-mail" };

						int elegir = JOptionPane.showOptionDialog(null, "¿Teléfono o e-mail?", "Elige una opción",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

						if (elegir == JOptionPane.YES_OPTION) {

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							String num = (JOptionPane.showInputDialog(null, "Introduzca un nuevo teléfono.", "",
									JOptionPane.QUESTION_MESSAGE));

							int tel = Integer.parseInt(num);

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							int idCliente = Integer.parseInt((JOptionPane.showInputDialog(null,
									"Introduzca el ID del cliente.", "", JOptionPane.QUESTION_MESSAGE)));

							cDAO.actualizarTel(tel, idCliente);

						} else {

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							String nemail = (JOptionPane.showInputDialog(null, "Introduzca un nuevo e-mail.", "",
									JOptionPane.QUESTION_MESSAGE));

							UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
							int idCliente = Integer.parseInt((JOptionPane.showInputDialog(null,
									"Introduzca el ID del cliente.", "", JOptionPane.QUESTION_MESSAGE)));

							cDAO.actualizarEmail(nemail, idCliente);
						}
						App.main(null);
						break;

					case 4:
						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						int idCliente = Integer.parseInt((JOptionPane.showInputDialog(null,
								"Introduzca el ID del cliente.", "", JOptionPane.QUESTION_MESSAGE)));

						cDAO.eliminar(idCliente);
						App.main(null);
						break;
					}

				case 3:
					// MENU DE GESTIÓN DE PRODUCTOS

					UIManager.put("OptionPane.minimumSize", new Dimension(350, 150));
					String mproducto = JOptionPane.showInputDialog(null,
							"1. Guardar un producto \n" + "2. Listar productos \n" + "3. Actualizar un producto \n"
									+ "4. Borrar un producto \n" + "0) Salir \n" + "\n" + "Introduce un número: ",
							"                                        MENÚ PRODUCTOS", JOptionPane.PLAIN_MESSAGE);

					int producto = Integer.parseInt(mproducto);

					switch (producto) {
					case 0:
						App.main(null);
						break;

					case 1:
						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca una cantidad.",
								"", JOptionPane.QUESTION_MESSAGE));

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						String fechaCad = JOptionPane.showInputDialog(null, "Inserta una fecha (dd/MM/yy)", "", JOptionPane.QUESTION_MESSAGE); 

						DateFormat inputFormat = new SimpleDateFormat("dd/MM/yy");
						Date date = inputFormat.parse(fechaCad);

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						double precio = Double.parseDouble((JOptionPane.showInputDialog(null, "Introduzca un precio.",
								"", JOptionPane.QUESTION_MESSAGE)));

						UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
						String descripcion = JOptionPane.showInputDialog(null, "Introduzca una descripción.", "",
								JOptionPane.QUESTION_MESSAGE);

						pDAO.guardarProducto(cantidad, date, precio, descripcion);
						break;
					}
					break;
				}

			} catch (NumberFormatException e) {
				UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
				JOptionPane.showMessageDialog(null, "Introduce un número.", "", JOptionPane.ERROR_MESSAGE);

			} catch (ParseException e) {
				UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
				JOptionPane.showMessageDialog(null, "La fecha no tiene un formato correcto.", "",
						JOptionPane.ERROR_MESSAGE);
			}

		} while (salir == true);
	}
}