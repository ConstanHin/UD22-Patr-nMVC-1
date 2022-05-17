package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaUVid extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldId;
	public JTextField textFieldTitle;
	public JTextField textFieldDirector;
	public JTextField textFieldIdCliente;
	public JButton btnEnviarDatos;
	public JButton btnEliminar;
	public JButton btnBuscar;

	/**
	 * Create the frame.
	 */
	public VistaUVid() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 200, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpgradeTablaVideos = new JLabel("Modificación de la tabla Videos");
		lblUpgradeTablaVideos.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpgradeTablaVideos.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblUpgradeTablaVideos.setBounds(72, 22, 272, 19);
		contentPane.add(lblUpgradeTablaVideos);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(31, 63, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(31, 88, 30, 22);
		contentPane.add(textFieldId);
		
		JLabel lblTitle = new JLabel("Titulo:");
		lblTitle.setBounds(31, 132, 86, 14);
		contentPane.add(lblTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(31, 156, 185, 20);
		contentPane.add(textFieldTitle);
		
		JLabel lblDirector = new JLabel("Director: ");
		lblDirector.setBounds(31, 198, 86, 14);
		contentPane.add(lblDirector);
		
		textFieldDirector = new JTextField();
		textFieldDirector.setColumns(10);
		textFieldDirector.setBounds(31, 223, 185, 20);
		contentPane.add(textFieldDirector);
		
		JLabel lblID_cli = new JLabel("ID Cliente:");
		lblID_cli.setBounds(31, 271, 86, 14);
		contentPane.add(lblID_cli);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setColumns(10);
		textFieldIdCliente.setBounds(31, 296, 185, 20);
		contentPane.add(textFieldIdCliente);
		
		btnEnviarDatos = new JButton("Actualizar");
		btnEnviarDatos.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos.setBounds(28, 378, 89, 23);
		contentPane.add(btnEnviarDatos);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEliminar.setBounds(297, 379, 89, 23);
		contentPane.add(btnEliminar);
		
		btnBuscar = new JButton("🔍︎");
		btnBuscar.setBounds(72, 88, 46, 23);
		contentPane.add(btnBuscar);
	}

}
