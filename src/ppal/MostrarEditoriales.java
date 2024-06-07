package ppal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBD;

public class MostrarEditoriales {

	public static void main(String[] args) {
	
				ConexionBD conexion = new ConexionBD();
				
				System.out.println("Conectando a la base de datos...");
				Connection con = conexion.getConexion();
				//Objetos necesarios para hacer una consulta
				Statement sentencia= null;
				ResultSet resultado=null;
				
				// Algún procesamiento con la base de datos...
				
				try {
				// TODO Auto-generated method stub
				//Paso 2. Obtener el Statement
				sentencia = con.createStatement();
				//Paso 3. Ejecujtar la sentencia
				resultado=sentencia.executeQuery("select *from editoriales");
				System.out.println("codigo Editoria\t año\t Nombre");		
				//Paso 4.Recorrer el resultado
				while(resultado.next()) {
					 int codEditorial = resultado.getInt("codEditorial");
					int anio = resultado.getInt("anio");
					String nombre = resultado.getString("nombre");
					System.out.println(codEditorial+"\t"+anio+"\t"+nombre);
				}
			} catch (SQLException e) {
				System.out.println("Error al consultar los datos."+e.getMessage());
			}finally{
				try {
					resultado.close();
					sentencia.close();
				}catch (SQLException e) {
				System.out.println("Error al liberar los recurssos");
				
			}
			// Liberamos la conexión
			System.out.println("Desconectando de la base de datos.");
			conexion.desconectar();
			
		}

		}
			
		

	}


