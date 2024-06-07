
	package conexion;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	public class ConexionBD {

		
		private static String database="biblioteca";
		private static String usuario="root";
		private static String contrasena="";
		private static String url="jdbc:mariadb://localhost/"+database;
		
		private Connection conexion= null;
		
		/**
		 * Método de la clase que devuellve el objeto
		 * Connection necesario para operaar con la base de 
		 * datos.
		 * @return el objeto Connection
		 */
		
		public Connection getConexion() {
			if (this.conexion!=null) {
				//Ya esstá la conexión creada, la devuelvo
				return this.conexion;
			}
			//Inicializamos la conexión a la base de datos
			try {
			//Registrar el drive. Previamente habrá que habert 
			//añadido el drive al proyecto(Build Path)
			Class.forName("org.mariadb.jdbc.Driver");
			
			//Obtenemos el objeto Connection de la clase
			//DriverManager. Lanzará ina excepción
			//SQLExceptio  si no se puede conectar
			this.conexion = DriverManager.getConnection(url,usuario,contrasena);
			System.out.println("Conexion a base de datos correcta");
			
		}catch (ClassNotFoundException e) {
			System.out.println("error al registrar el driver");
		} catch (SQLException e) {
			System.out.println("No se puede conectar con la base de datos" +e.getLocalizedMessage());
		}
			return this.conexion;
		}
		/** 
		 * Metodo de la clase que libera los recursos asociados a la
		 * conexion
		 */
		 public void desconectar () {
			 if(this.conexion!=null) {
				 try {
					 this.conexion.close();
				 }catch(SQLException e) {
				 	System.out.println("Error, no se puede liberal la conexion");
				 	
			 }
		 }
	}
	}

