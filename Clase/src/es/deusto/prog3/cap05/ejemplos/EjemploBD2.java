package es.deusto.prog3.cap05.ejemplos;

import java.sql.*;

/**
 * Ejemplo de cómo usar PreparedStatement
 */

public class EjemploBD2 {
	
	private Connection conn = null;

    public static void main(String[] args) throws SQLException {
    	
    	EjemploBD2 bd = new EjemploBD2();
    	//inicializar la base de datos
    	bd.inicializarDB();
    	
        //crear conexión a las base de datos
    	//si el fichero existe carga la BD a partir de ese archivo
    	//si no existe crea un archivo en esa ubicación
    	bd.crearConexion();
        
    	if (bd.getConn() != null) {
	        //Crear la tabla Persona
	        bd.crearTabla();
	        
	        //Insertar personas
	        bd.insertarPersonas();
	        
	        //Verificar los registros introducidos
	        bd.verificarRegistros();
		 } else {
			 System.out.println("No hay conexión a la BD");
		 }
    }

	public void inicializarDB() {
    	// Carga el sqlite-JDBC driver usando el cargador de clases
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: Driver sqlite para JDBC no encontrado");
			return;
		}
    }
	
	public Connection crearConexion() throws SQLException {
		String url = "jdbc:sqlite:bd/bd2.db";
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Error al crear la conexión");
			throw new SQLException();
		}
		
		return conn;
		
	}
	
	public void crearTabla() {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS Persona (id INTEGER PRIMARY KEY, Nombre TEXT NOT NULL)";
		
        try {
        	Statement stmt = conn.createStatement();
			stmt.execute(createTableSQL);
		} catch (SQLException e) {
			System.err.println("Error al crear la tabla");
		}
        System.out.println("Tabla creada.");
		
	}
	
	private void insertarPersonas() {
		String insertSQL = "INSERT INTO Persona (id, Nombre) VALUES (?, ?)";
		// Insertar varios registros usando PreparedStatement
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            String[] nombres = {"Ana", "Luis", "María", "Juan"};
            for (int i = 0; i < nombres.length; i++) {
                pstmt.setInt(1, i + 1);         // ID
                pstmt.setString(2, nombres[i]); // Nombre
                pstmt.executeUpdate();
            }
            System.out.println("Registros insertados.");
        } catch (SQLException e) {
			System.err.println("Error al insertar registros");
		}
	}
	
	private void verificarRegistros() {
		String selectSQL = "SELECT * FROM Persona";
		// Verificar los registros
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("Nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }
        } catch (SQLException e) {
			System.err.println("Error en la sentencia SELECT");
		}
		
	}
	
	public Connection getConn() {
		return conn;
	}
	
	
}

