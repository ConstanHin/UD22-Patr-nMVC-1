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
import javax.swing.JPasswordField;

public class VistaConexion extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldIP;
	public JTextField textFieldUser;
	public JPasswordField passwordField;
	public JButton btnConectar;

	/**
	 * Create the frame.
	 */
	public VistaConexion() {
		setTitle("CRUD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 200, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEfectueSuConexin = new JLabel("Efectue su conexión");
		lblEfectueSuConexin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEfectueSuConexin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblEfectueSuConexin.setBounds(87, 35, 261, 22);
		contentPane.add(lblEfectueSuConexin);
		
		JLabel ipLabel = new JLabel("IP:");
		ipLabel.setBounds(23, 82, 86, 14);
		contentPane.add(ipLabel);
		
		textFieldIP = new JTextField();
		textFieldIP.setText("192.168.1.145");
		textFieldIP.setColumns(10);
		textFieldIP.setBounds(23, 107, 185, 20);
		contentPane.add(textFieldIP);
		
		JLabel userLabel = new JLabel("User:");
		userLabel.setBounds(23, 149, 86, 14);
		contentPane.add(userLabel);
		
		textFieldUser = new JTextField();
		textFieldUser.setText("remote");
		textFieldUser.setColumns(10);
		textFieldUser.setBounds(23, 174, 185, 20);
		contentPane.add(textFieldUser);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(23, 224, 86, 14);
		contentPane.add(passwordLabel);
		
		btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnConectar.setBounds(23, 314, 89, 23);
		contentPane.add(btnConectar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(23, 249, 185, 20);
		contentPane.add(passwordField);
	}
}
