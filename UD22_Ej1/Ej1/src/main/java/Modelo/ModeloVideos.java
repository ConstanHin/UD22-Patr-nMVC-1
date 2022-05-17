package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloVideos {

	private ConexionMySQL mysql;

	public ModeloVideos(ConexionMySQL mysql) {
		this.mysql = mysql;
	}

	public void insertar(Video video) {

		try {
			String sqlQuery = "INSERT INTO videos (Title, Director, ID_cli) VALUE (\""
					+ video.getTitle() + "\",\"" + video.getDirector() + "\"," + video.getId_cli() + ");";
			mysql.insertQuery("VideoClub", sqlQuery);
		} catch (Exception e) {
			System.out.println("Fallo insercion modelo video");
		}
	}

	public void update(Video video) {

		try {
			String sqlQuery = "UPDATE videos SET Title='"+ video.getTitle() +"', Director='" + video.getDirector() +"', ID_cli='"+ video.getId_cli() +"' WHERE ID = "
					+ video.getID() + ";";
			mysql.insertQuery("VideoClub", sqlQuery);

		} catch (Exception e) {
			System.out.println("Fallo Update modelo video");
		}

	}
	
	public Video mostrarPorId(Long id) {
		
		Video video = new Video();
		ResultSet rs = mysql.getRow("videos", id);
	
		try {
			rs.next();
			video.setID(rs.getLong("ID"));
			video.setTitle(rs.getString("Title"));
			video.setDirector(rs.getString("Director"));
			video.setId_cli(rs.getInt("ID_cli"));
	
			return video;
		} catch (SQLException e) {
	
			System.out.println("Fallo modelo clientes al buscar por id");
			System.out.println(e);
			
			return new Video();
		}
	
	
	}

	public void delete(Long id) {
		mysql.deleteRow("videos", id);
	}

	public ArrayList<Video> mostrarTodos() {
	
		try {
			String sqlQuery = "SELECT * FROM videos;";
			ResultSet rs = mysql.getAllRows("VideoClub", sqlQuery);
	
			ArrayList<Video> arrvideos = new ArrayList<Video>();
	
			while (rs.next()) {
				// Crear video y anadirlo al array
				Video video = new Video(rs.getLong("ID"), rs.getString("Title"), rs.getString("Director"), rs.getInt("ID_cli"));
	
				arrvideos.add(video);
			}
	
			return arrvideos;
	
		} catch (Exception e) {
			System.out.println("Fallo mostrar registros");
			System.out.println(e);
	
			return new ArrayList<Video>();
		}
	
	}
}
