package Modelo;

public class ConfigConexion {

	// direccion
		private String direccion = "";
		private String user = "";
		private String pass = "";
//		private String direccion = "jdbc:mysql://192.168.1.145:3306";
//		private String user = "remote";
//		private String pass = "Reus_2022";
		
		public ConfigConexion() {
		}

		/**
		 * @return the direccion
		 */
		public String getDireccion() {
			return direccion;
		}

		/**
		 * @return the user
		 */
		public String getUser() {
			return user;
		}

		/**
		 * @return the pass
		 */
		public String getPass() {
			return pass;
		}

		/**
		 * @param direccion the direccion to set
		 */
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		/**
		 * @param user the user to set
		 */
		public void setUser(String user) {
			this.user = user;
		}

		/**
		 * @param pass the pass to set
		 */
		public void setPass(String pass) {
			this.pass = pass;
		}
		
		
}
