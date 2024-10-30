package es.deusto.prog3.cap05.ejercicios;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2GestorBDClientes {

	protected static final String DRIVER_NAME = "org.sqlite.JDBC";
	protected static final String DATABASE_FILE = "db/database.db";
	protected static final String CONNECTION_STRING = "jdbc:sqlite:" + DATABASE_FILE;
	
	public Ejercicio2GestorBDClientes() {		
		try {
			//Cargar el diver SQLite
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException ex) {
			System.err.println(String.format("* Error al cargar el driver de BBDD: %s", ex.getMessage()));
			ex.printStackTrace();
		}
	}
		
	public void crearBBDD() {
		//Se abre la conexión y se obtiene el Statement
		//Al abrir la conexión, si no existía el fichero, se crea la base de datos
		
		String sql = "CREATE TABLE IF NOT EXISTS CLIENTE (\n"
                + " ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " NAME TEXT NOT NULL,\n"
                + " EMAIL TEXT NOT NULL,\n"
                + " PASSWORD TEXT NOT NULL\n"
                + ");";
		//TODO implementa lo necesario para crear la BD
	}
	
	public void borrarBBDD() {
		//Se abre la conexión y se obtiene el Statement
		//Saca por consola si se ha borrado correctamente
		String sql = "DROP TABLE IF EXISTS CLIENTE";
		
		//TODO
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE));
			System.out.println("- Se ha borrado el fichero de la BBDD");
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar el archivo de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}
	}
	
	public void insertarDatos(Ejercicio2Cliente... clientes ) {
		//Se abre la conexión y se obtiene el Statement
		String sql = "INSERT INTO CLIENTE (NAME, EMAIL, PASSWORD) VALUES ('%s', '%s', '%s');";
		//Puedes usar String.format(sql, c.getName(), c.getEmail(), c.getPassword())
		
		
		//Se recorren los clientes y se insertan uno a uno
		//Saca mensaje por consola si el cliente no está
						
	}
	
	public List<Ejercicio2Cliente> obtenerDatos() {
		List<Ejercicio2Cliente> clientes = new ArrayList<>();
		
		//TODO obten todos los clientes en una lista de clientes		
		
		return clientes;
	}

	public void actualizarPassword(Ejercicio2Cliente cliente, String newPassword) {
		//Se abre la conexión y se obtiene el Statement
		String sql = "UPDATE CLIENTE SET PASSWORD = '%s' WHERE ID = %d;";
		//TODO actualizar password	
	}
	
	public void borrarDatos() {
		//Se abre la conexión y se obtiene el Statement
		String sql = "DELETE FROM CLIENTE;";
		
		//System.out.println(String.format("- Se han borrado %d clientes", result));
		
		//TODO borra todos los clientes y comprueba cuántos
				
	}	
}