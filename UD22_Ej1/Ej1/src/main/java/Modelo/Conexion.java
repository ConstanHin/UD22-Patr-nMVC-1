package Modelo;

public class Conexion {

	private ConexionMySQL mysql;
	private String sqlQuery;
	private String nombreDB = "clientesDB_team6";

	public Conexion(ConexionMySQL conexionMySQL) {
		this.mysql = conexionMySQL;
	}

	public void crearTablaClientes() {

		/* Crear tabla cliente */

		sqlQuery = "CREATE TABLE IF NOT EXISTS clientes (" + "ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "Nombre VARCHAR(100) DEFAULT NULL ," + "Apellido VARCHAR(100) DEFAULT NULL,"
				+ "Direccion VARCHAR(100) DEFAULT NULL," + "DNI INT(11) DEFAULT NULL," + "Fecha date DEFAULT NULL);";

		mysql.insertQuery(nombreDB, sqlQuery);

	}

	
	 /* Insertar registros en la tabla clientes */
	
	public void insertarRegistrosClientes() {
		
		sqlQuery = "INSERT INTO clientes (Nombre, Apellido, Direccion, DNI, Fecha) VALUE"
				+ "(\"Manolo\",\"Garcia\",\"Calle Francia Nº4\",\"39324562\",\"1994/09/05\"),"
				+ "(\"Maria\",\"Ramirez\",\"Calle Argentera Nº7\",\"39247289\",\"1989/08/15\"),"
				+ "(\"Juan\",\"Garcia\",\"Calle Larios Nº1\",\"39183471\",\"1995/11/25\"),"
				+ "(\"Belen\",\"Gutierrez\",\"Calle Palacios Nº32\",\"39183948\",\"1990/05/17\"),"
				+ "(\"Azucena\",\"Monte\",\"Calle Nueve Nº10\",\"39192398\",\"1998/11/12\");";
		mysql.insertQuery(nombreDB, sqlQuery);
	}

}
