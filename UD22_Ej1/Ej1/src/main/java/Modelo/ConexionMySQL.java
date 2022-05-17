package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionMySQL {

	public Connection connectionObj;
	public boolean conexionEstablecida = false;
	
	//Constructor
	public ConexionMySQL() {
	}

	public void conectar(ConfigConexion config) {
		try {
			System.out.println("Intentando conectar con la base de datos...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + config.getDireccion() + ":3306", config.getUser(), config.getPass());
			this.connectionObj = conexion;
			System.out.println("Conectado a la base de datos con exito");
			conexionEstablecida = true;
		} catch (Exception e) {
			System.out.println("Fallo conexion con la base de datos");
			System.out.println(e);
			conexionEstablecida = false;
		}
	}
	
	
	public void desconectar() {
		try {
			this.connectionObj.close();
			System.out.println("Desconectado de la base de datos.");
		} catch (Exception e) {
			System.out.println("Fallo al cerrar la conexion");
			System.out.println(e);
		}
	}
	
	
	/*Create a database*/
	
	public void createDB(String name) {
		try {
			String query = "CREATE DATABASE IF NOT EXISTS " + name;
			Statement st = this.connectionObj.createStatement();
			st.executeUpdate(query);
			System.out.println("Database created!");

		} catch (Exception e) {
			System.out.println("Creating database fail");
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
	
	/*Delete a database*/
	
	public void dropDB(String name) {
		try {
			String query = "DROP DATABASE IF EXISTS " + name;
			Statement st = this.connectionObj.createStatement();
			st.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Drop database fail");
			System.out.println(e);
		}
	}
	
	
	/*Delete a Table*/
	
	public void dropTable(String dbName, String tableName) {
		try {
			// Database statement

			String queryDb = "USE " + dbName + ";";
			Statement stdb = this.connectionObj.createStatement();
			stdb.executeUpdate(queryDb);

			// Drop table Statement
			String query = "DROP TABLE " + tableName + ";";

			Statement st = this.connectionObj.createStatement();
			stdb.executeUpdate(query);

			st.executeUpdate(query);
			System.out.println("Table deleted!");

		} catch (Exception e) {
			System.out.println("Deleting table fail");
			System.out.println(e);
		}
	}
	
	/*Insert a Query*/
	
	public void insertQuery(String dbName, String insertQuery) {
		try {
			// Database use statement

			String queryDb = "USE " + dbName + ";";

			Statement stdb = this.connectionObj.createStatement();
			stdb.executeUpdate(queryDb);

			// Insert into the table statement
			String query = insertQuery;

			Statement st = this.connectionObj.createStatement();

			st.executeUpdate(query);
			System.out.println("Query suceesfully!");

		} catch (Exception e) {
			System.out.println("Inserting row/s fail");
			System.out.println(e);
		}
	}
	
	
	/*Delete a Row*/
	
	public void deleteRow(String tableName, Long id) {
		try {

			// Insert into the table statement
			String query = "DELETE FROM " + tableName + " WHERE ID=" + id + ";";

			Statement st = this.connectionObj.createStatement();

			st.executeUpdate(query);
			
			System.out.println("Deleted row with id: " + id);

		} catch (Exception e) {
			System.out.println("Deleting row/s fail");
			System.out.println(e);
		}
	}
	
	/*Show a Row*/
	
	public ResultSet getRow(String tableName, Long id) {
		try {
			// Insert into the table statement
			String query = "SELECT * FROM " + tableName + " WHERE ID=" + id + ";";
			
			Statement st = this.connectionObj.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			return rs;
			
		}catch (Exception e) {
			System.out.println("Showing row/s fail");
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Devuelve el result set de todos los registros
	 * @param dbName
	 * @param id
	 * @return
	 */
	public ResultSet getAllRows(String dbName, String query) {
		try {
			// Database use statement
			
			String queryDb = "USE " + dbName + ";";
			
			Statement stdb = this.connectionObj.createStatement();
			stdb.executeUpdate(queryDb);
			
			Statement st = this.connectionObj.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			return rs;
			
		}catch (Exception e) {
			System.out.println("Showing row/s fail");
			System.out.println(e);
			return null;
		}
	}
	
}
