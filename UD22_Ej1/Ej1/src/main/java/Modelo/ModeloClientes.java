package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloClientes {

	private ConexionMySQL mysql;

	public ModeloClientes(ConexionMySQL mysql) {
		this.mysql = mysql;
	}

	public void insertar(Cliente cliente) {

		try {
			String sqlQuery = "INSERT INTO clientes (Nombre, Apellido, Direccion, DNI, Fecha) VALUE (\""
					+ cliente.getNombre() + "\",\"" + cliente.getApellido() + "\",\"" + cliente.getDireccion() + "\",\""
					+ cliente.getDNI() + "\",\"" + cliente.getFecha() + "\");";
			mysql.insertQuery("VideoClub", sqlQuery);
		} catch (Exception e) {
			System.out.println("Fallo insercion modelo cliente");
		}
	}

	public void update(Cliente cliente) {

		try {
			String sqlQuery = "UPDATE clientes SET Nombre='"+cliente.getNombre()+"', Apellido='"+cliente.getApellido()+"' , Direccion='"+cliente.getDireccion()+"', DNI='"+ cliente.getDNI()+"', Fecha='"+cliente.getFecha()+"' WHERE ID = "
					+ cliente.getID() + ";";
			mysql.insertQuery("VideoClub", sqlQuery);

		} catch (Exception e) {
			System.out.println("Fallo Update modelo cliente");
		}

	}
	
	public Cliente mostrarPorId(Long id) {
	
		Cliente cliente = new Cliente();
		ResultSet rs = mysql.getRow("clientes", id);
	
		try {
			rs.next();
			cliente.setID(rs.getLong("ID"));
			cliente.setNombre(rs.getString("Nombre"));
			cliente.setApellido(rs.getString("Apellido"));
			cliente.setDireccion(rs.getString("Direccion"));
			cliente.setDNI(rs.getString("DNI"));
			cliente.setFecha(rs.getDate("Fecha"));
	
			return cliente;
		} catch (SQLException e) {
	
			System.out.println("Fallo modelo clientes al buscar por id");
			System.out.println(e);
			
			return new Cliente();
		}
	
	
	}

	public void delete(Long id) {
		mysql.deleteRow("clientes", id);
	}

	public ArrayList<Cliente> mostrarTodos() {
	
		try {
			String sqlQuery = "SELECT * FROM clientes;";
			ResultSet rs = mysql.getAllRows("VideoClub", sqlQuery);
	
			ArrayList<Cliente> arrClientes = new ArrayList<Cliente>();
	
			while (rs.next()) {
				// Crear cliente y anadirlo al array
				Cliente cliente = new Cliente(rs.getLong("ID"), rs.getString("Nombre"), rs.getString("Apellido"),
						rs.getString("Direccion"), rs.getString("DNI"), rs.getDate("Fecha"));
	
				arrClientes.add(cliente);
			}
	
			return arrClientes;
	
		} catch (Exception e) {
			System.out.println("Fallo mostrar registros");
			System.out.println(e);
	
			return new ArrayList<Cliente>();
		}
	
	}
}
