package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class VistaU extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldId;
	public JTextField textFieldNombre;
	public JTextField textFieldApellido;
	public JTextField textFieldDireccion;
	public JTextField textFieldDni;
	public JTextField textFieldFecha;
	public JButton btnEnviarDatos;
	public JButton btnEliminar;
	public JButton btnBuscar;

	/**
	 * Create the frame.
	 */
	public VistaU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 200, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpgradeDeValores = new JLabel("Modificación de la tabla Cliente");
		lblUpgradeDeValores.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpgradeDeValores.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblUpgradeDeValores.setBounds(78, 11, 272, 19);
		contentPane.add(lblUpgradeDeValores);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(24, 128, 86, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(24, 153, 185, 20);
		contentPane.add(textFieldNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(24, 194, 86, 14);
		contentPane.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(24, 219, 185, 20);
		contentPane.add(textFieldApellido);
		
		JLabel lblDireccion = new JLabel("Dirección: ");
		lblDireccion.setBounds(24, 261, 86, 14);
		contentPane.add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(24, 286, 185, 20);
		contentPane.add(textFieldDireccion);
		
		JLabel lblDNI = new JLabel("DNI: ");
		lblDNI.setBounds(24, 328, 86, 14);
		contentPane.add(lblDNI);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(24, 353, 185, 20);
		contentPane.add(textFieldDni);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(24, 384, 86, 14);
		contentPane.add(lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(24, 409, 185, 20);
		contentPane.add(textFieldFecha);
		
		btnEnviarDatos = new JButton("Actualizar");
		btnEnviarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviarDatos.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos.setBounds(24, 478, 89, 23);
		contentPane.add(btnEnviarDatos);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(24, 58, 46, 14);
		contentPane.add(lblid);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(24, 83, 30, 22);
		contentPane.add(textFieldId);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEliminar.setBounds(289, 479, 89, 23);
		contentPane.add(btnEliminar);
		
		btnBuscar = new JButton("🔍︎");

		btnBuscar.setBounds(64, 83, 46, 23);
		contentPane.add(btnBuscar);
	}
}
