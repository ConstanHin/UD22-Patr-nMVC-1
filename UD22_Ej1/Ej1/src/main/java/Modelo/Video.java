package Modelo;

public class Video {

	private Long ID; 
	private String title;
	private String director;
	private Integer id_cli;
	
	
	public Video() {
		
	}
	
	

	public Video(String title, String director) {
		this.title = title;
		this.director = director;
		this.id_cli = null;
	}



	public Video(Long ID, String title, String director, int id_cli) {
		this.ID = ID;
		this.title = title;
		this.director = director;
		this.id_cli = id_cli;
	}

	//Getters & Setters

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public Integer getId_cli() {
		return id_cli;
	}



	public void setId_cli(Integer id_cli) {
		this.id_cli = id_cli;
	}
	
	
	public Long getID() {
		return ID;
	}

	public void setID(Long id) {
		ID = id;
	}



	@Override
	public String toString() {
		return "Video [title=" + title + ", director=" + director + ", id_cli=" + id_cli + "]";
	}
	
	
	
}
