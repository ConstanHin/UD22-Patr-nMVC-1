package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaC_vid extends JFrame {

	public JPanel contentPane;
	public JTextField txtField_Title;
	public JTextField txtField_Director;
	public JTextField txtField_ID_Cli;
	public JButton btnEnviarDatos;

	/**
	 * Creacion de la vista Creación Tabla.
	 */
	public VistaC_vid() {
		setTitle("Insertar valores ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 200, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Introduce los valores de la tabla Videos");
		lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(78, 11, 272, 19);
		contentPane.add(lblTitulo);
		
		JLabel lblTitle = new JLabel("Titulo:");
		lblTitle.setBounds(20, 45, 86, 14);
		contentPane.add(lblTitle);
		
		txtField_Title = new JTextField();
		txtField_Title.setBounds(20, 69, 185, 20);
		contentPane.add(txtField_Title);
		txtField_Title.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director: ");
		lblDirector.setBounds(20, 111, 86, 14);
		contentPane.add(lblDirector);
		
		txtField_Director = new JTextField();
		txtField_Director.setColumns(10);
		txtField_Director.setBounds(20, 136, 185, 20);
		contentPane.add(txtField_Director);
		
		JLabel lblID_cli = new JLabel("ID Cliente:");
		lblID_cli.setBounds(20, 184, 86, 14);
		contentPane.add(lblID_cli);
		
		txtField_ID_Cli = new JTextField();
		txtField_ID_Cli.setColumns(10);
		txtField_ID_Cli.setBounds(20, 209, 185, 20);
		contentPane.add(txtField_ID_Cli);
		
		btnEnviarDatos = new JButton("Aceptar");
		btnEnviarDatos.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnEnviarDatos.setBounds(20, 273, 89, 23);
		contentPane.add(btnEnviarDatos);
	}
}
