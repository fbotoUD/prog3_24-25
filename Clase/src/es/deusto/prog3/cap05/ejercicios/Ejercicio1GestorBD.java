package es.deusto.prog3.cap05.ejercicios;

import java.sql.*;

/*
 * Rellena todos los huecos necesarios de la siguiente clase GestorBD. Los métodos
deben ejecutar la sentencia sql que se indica en la variable llamada sql. Finalmente,
escribe en el método main cómo realizarías la llamada a todos los métodos de la
clase que has rellenado: connect(), createTable(), insert(), selectAll().
Con este último, muestra en pantalla los resultados que éste debería de dar.
 * */
public class Ejercicio1GestorBD {
	private Connection conn;
	
	public Ejercicio1GestorBD() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("CORRECTO");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void connect(String name) {
		try {
			conn = DriverManager.getConnection(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void removeTable() {
		
		String sql = "drop table if exists employees";
		//TODO
	}
	
	public void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS employees (\n" + " idinteger PRIMARY KEY,\nname text NOT NULL,\nsalary real\n" + ");";
		//TODO completa
		
	}
	
	public void insert(String name, double salary) throws SQLException {
		String sql = "INSERT INTO employees(name, salary) VALUES(?,?)";
		
		//TODO completa la tabla con usa serie de empleados
		
	}
	
	public ResultSet selectAll() {
		String sql = "SELECT * FROM employees";
		//TODO
		
		return null;
	}
	
	public static void main(String[] args) throws SQLException {
		
		Ejercicio1GestorBD gestor = new Ejercicio1GestorBD();
		//TODO
	
	}

	
	


}
