package es.deusto.prog3.cap05.ejemplos;

import java.sql.*;

public class EjemploBD {
	
	public static void main(String[] args) throws ClassNotFoundException {

//		// Carga el sqlite-JDBC driver usando el cargador de clases
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: Driver sqlite para JDBC no encontrado");
			return;
		}

		Connection connection = null;
		try {
			// Crear una conexión de BD
			connection = DriverManager.getConnection("jdbc:sqlite:bd/sample.db");
			// Crear gestores de sentencias
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			
			// Ejecutar sentencias SQL (Delete)
			statement.executeUpdate("drop table if exists person");
			
			// Ejecutar sentencias SQL (Update)
			statement.executeUpdate("create table person (id integer, name string)");
			
			//Ejecutar sentenciass SQL (Insert) insertar registros
			int res = statement.executeUpdate("insert into person values(1, 'leo')");
			res = statement.executeUpdate("insert into person values(2, 'yui')");
			System.out.println( "Número de registros insertados: "+res );
			
			// Ejecutar sentencias SQL (Select)
			ResultSet rs = statement.executeQuery("select * from person");
			while(rs.next()) {
				// Leer el resultset
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if(connection != null)
					connection.close();
			} catch(SQLException e) {
				// Cierre de conexión fallido
				System.err.println(e);
			}
		}
	}
	

}
