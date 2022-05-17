package Controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Config;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.ConexionMySQL;
import Modelo.ConfigConexion;
import Modelo.ModeloClientes;
import Modelo.ModeloVideos;
import Modelo.Video;
import Vista.VistaC_cli;
import Vista.VistaC_vid;
import Vista.VistaConexion;
import Vista.VistaPrincipal;
import Vista.VistaU;
import Vista.VistaUVid;

public class Controlador {

	// Attributes
	private VistaConexion vistaConexion;
	private VistaPrincipal vistaPrincipal;
	private VistaC_cli vistaC_cli;
	private VistaC_vid vistaC_vid;
	private VistaU vistaU;
	private VistaUVid vistaUVid;
	private ConexionMySQL conexionMySQL;
	private ModeloClientes modeloClientes;
	private ModeloVideos modeloVideos;
	private ConfigConexion configConexion;

	// Constructors
	public Controlador() {
	}

	/**
	 * @return the vistaPrincipal
	 */
	public VistaPrincipal getVistaPrincipal() {
		return vistaPrincipal;
	}

	/**
	 * @param vistaPrincipal the vistaPrincipal to set
	 */
	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	/**
	 * @return the conexionMySQL
	 */
	public ConexionMySQL getConexionMySQL() {
		return conexionMySQL;
	}

	/**
	 * @param conexionMySQL the conexionMySQL to set
	 */
	public void setConexionMySQL(ConexionMySQL conexionMySQL) {
		this.conexionMySQL = conexionMySQL;
	}

	/**
	 * @return the modeloClientes
	 */
	public ModeloClientes getModeloClientes() {
		return modeloClientes;
	}

	/**
	 * @param modeloClientes the modeloClientes to set
	 */
	public void setModeloClientes(ModeloClientes modeloClientes) {
		this.modeloClientes = modeloClientes;
	}

	/**
	 * Inicializar la vista principal
	 */
	public void init() {

		// Inicializar vista Conexion mysql
		vistaConexion = new VistaConexion();
		vistaConexion.setVisible(true);

		listenerConectarBtn();

	}

	/**
	 * Accion boton "Actualizar"
	 */
	public void listenerActualziarBtn() {
		vistaPrincipal.actualizarBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int selItem = vistaPrincipal.desplegable.getSelectedIndex();

				switch (selItem) {
				case 0:
					modeloClientes = new ModeloClientes(conexionMySQL);
					ArrayList<Cliente> clientes = modeloClientes.mostrarTodos();

					vistaPrincipal.getTextArea().setText("");
					for (int i = 0; i < clientes.size(); i++) {
						Cliente cliente = clientes.get(i);
						String stringCliente = cliente.getID() + ".   " + cliente.getNombre() + ",   "
								+ cliente.getApellido() + ",   " + cliente.getDireccion() + ",   " + cliente.getDNI()
								+ ",   " + cliente.getFecha() + ",   " + "\n";
						vistaPrincipal.getTextArea().append(stringCliente);

					}
					break;
				case 1:
					modeloVideos = new ModeloVideos(conexionMySQL);
					ArrayList<Video> videos = modeloVideos.mostrarTodos();

					vistaPrincipal.getTextArea().setText("");
					for (int i = 0; i < videos.size(); i++) {
						Video video = videos.get(i);
						vistaPrincipal.getTextArea().append(video.getID() + ". " + video.getTitle() + ", "
								+ video.getDirector() + ", " + video.getId_cli() + "\n");

					}
					break;

				default:

					break;
				}

			}
		});
	}

	/**
	 * Listener boton "Conectar"
	 */
	public void listenerConectarBtn() {
		vistaConexion.btnConectar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Conectar");
				configConexion = new ConfigConexion();
				configConexion.setDireccion(vistaConexion.textFieldIP.getText());
				configConexion.setUser(vistaConexion.textFieldUser.getText());
				configConexion.setPass(vistaConexion.passwordField.getText());

				System.out.println(vistaConexion.textFieldIP.getText());
				System.out.println(vistaConexion.textFieldUser.getText());
				System.out.println(vistaConexion.passwordField.getText());

				conexionMySQL = new ConexionMySQL();
				conexionMySQL.conectar(configConexion);

				if (conexionMySQL.conexionEstablecida) {
					JOptionPane dialog = new JOptionPane();
					dialog.showMessageDialog(null, "Conectado a la base de datos con exito");
					vistaConexion.dispose();
					// Abrir vistaPrincipal
					abrirVistaPrincipal();

					// Crear base de datos si no existe
					conexionMySQL.dropDB("VideoClub");
					conexionMySQL.createDB("VideoClub");
					Conexion conexion = new Conexion(conexionMySQL);
					conexion.crearTablaClientes();
					conexion.crearTablaVideos();
					conexion.insertarRegistrosClientes();
					conexion.insertarRegistrosVideos();

					// Instanciar Modelos
					modeloClientes = new ModeloClientes(conexionMySQL);
					modeloVideos = new ModeloVideos(conexionMySQL);

				} else {
					JOptionPane dialog = new JOptionPane();
					dialog.showMessageDialog(null, "Conexión fallida");

				}

			}
		});
	}

	public void abrirVistaPrincipal() {
		// Inicializar la vista principal
		vistaPrincipal = new VistaPrincipal();
		vistaPrincipal.setVisible(true);
		listenerActualziarBtn();
		listenerNuevoClienteMenu();
		listenerNuevoVideoMenu();
		listenerBuscarClienteMenu();
		listenerBuscarVideoMenu();
	}

	private void listenerNuevoClienteMenu() {
		vistaPrincipal.nuevoClienteMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vistaC_cli = new VistaC_cli();
				vistaC_cli.setVisible(true);
				vistaC_cli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				vistaC_cli.btnEnviarDatos.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Cliente cliente = new Cliente();
							cliente.setNombre(vistaC_cli.txtField_Nombre.getText());
							cliente.setApellido(vistaC_cli.txtField_Apellido.getText());
							cliente.setDireccion(vistaC_cli.txtField_Direccion.getText());
							cliente.setDNI(vistaC_cli.txtField_DNI.getText());
							cliente.setFecha(Date.valueOf(vistaC_cli.txtField_Fecha.getText()));

							modeloClientes.insertar(cliente);
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Registro cliente insertado correctamente!");
						} catch (Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Error al insertar registro cliente");
						}

					}
				});
			}
		});

	}

	/**
	 * Accion al pulsar el boton Menu->nuevo->video
	 */
	private void listenerNuevoVideoMenu() {
		vistaPrincipal.nuevoVideoMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				vistaC_vid = new VistaC_vid();
				vistaC_vid.setVisible(true);
				vistaC_vid.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				vistaC_vid.btnEnviarDatos.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						try {
							Video video = new Video();
							video.setTitle(vistaC_vid.txtField_Title.getText());
							video.setDirector(vistaC_vid.txtField_Director.getText());
							video.setId_cli(Integer.parseInt(vistaC_vid.txtField_ID_Cli.getText()));

							modeloVideos.insertar(video);
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Registro video insertado correctamente!");
						} catch (Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Error al insertar registro video");
						}
					}
				});
			}
		});

	}

	/**
	 * Menu boton buscar cliente
	 */
	private void listenerBuscarClienteMenu() {
		vistaPrincipal.buscarClienteMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vistaU = new VistaU();
				vistaU.setVisible(true);
				vistaU.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				// Buscar cliente
				vistaU.btnBuscar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Cliente cliente = modeloClientes.mostrarPorId(Long.parseLong(vistaU.textFieldId.getText()));

							vistaU.textFieldNombre.setText(cliente.getNombre());
							vistaU.textFieldApellido.setText(cliente.getApellido());
							vistaU.textFieldDireccion.setText(cliente.getDireccion());
							vistaU.textFieldDni.setText(cliente.getDNI());
							vistaU.textFieldFecha.setText(String.valueOf(cliente.getFecha()));

						} catch (Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "No se ha encontrado el registro.");
						}

					}
				});

				// Actualizar Cliente
				vistaU.btnEnviarDatos.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						try {
							Cliente cliente = new Cliente();
							cliente.setID(Long.parseLong(vistaU.textFieldId.getText()));
							cliente.setNombre(vistaU.textFieldNombre.getText());
							cliente.setApellido(vistaU.textFieldApellido.getText());
							cliente.setDireccion(vistaU.textFieldDireccion.getText());
							cliente.setDNI(vistaU.textFieldDni.getText());
							cliente.setFecha(Date.valueOf(vistaU.textFieldFecha.getText()));

							modeloClientes.update(cliente);
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Registro actualizado con éxito!");
						} catch (Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "No se ha podido actualizar el registro.");
						}

					}
				});
				vistaU.btnEliminar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							modeloClientes.delete(Long.parseLong(vistaU.textFieldId.getText()));
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Se ha eliminado el registro!");
						} catch (Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "No se ha podido eliminar el registro.");
						}

					}
				});
			}
		});

	}

	/**
	 * Menu boton buscar video
	 */
	private void listenerBuscarVideoMenu() {

		vistaPrincipal.buscarVideoMenu.addActionListener(new ActionListener() {

			// Accion click boton menu -> buscar -> video
			@Override
			public void actionPerformed(ActionEvent e) {
				vistaUVid = new VistaUVid();
				vistaUVid.setVisible(true);
				vistaUVid.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				// Buscar Video
				vistaUVid.btnBuscar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						try {
							Video video = modeloVideos.mostrarPorId(Long.parseLong(vistaUVid.textFieldId.getText()));

							vistaUVid.textFieldTitle.setText(video.getTitle());
							vistaUVid.textFieldDirector.setText(video.getDirector());
							vistaUVid.textFieldIdCliente.setText(String.valueOf(video.getId_cli()));
						} catch (Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "No se ha encontrado el registro del video.");
						}

					}
				});

				// Actualizar Video
				vistaUVid.btnEnviarDatos.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Video video = new Video();
							video.setID(Long.parseLong(vistaUVid.textFieldId.getText()));
							video.setTitle(vistaUVid.textFieldTitle.getText());
							video.setDirector(vistaUVid.textFieldDirector.getText());
							video.setId_cli(Integer.valueOf(vistaUVid.textFieldIdCliente.getText()));

							modeloVideos.update(video);

							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Se ha actualizado el registro!");
						} catch (Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "No se ha podido actualizar el registro.");
						}

					}
				});
				// Delete Video
				vistaUVid.btnEliminar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							modeloVideos.delete(Long.parseLong(vistaUVid.textFieldId.getText()));
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "Se ha eliminado el registro.");
						} catch (Exception e2) {
							JOptionPane dialog = new JOptionPane();
							dialog.showMessageDialog(null, "No se ha podido eliminar el registro.");
						}

					}
				});
			}
		});

	}

}
