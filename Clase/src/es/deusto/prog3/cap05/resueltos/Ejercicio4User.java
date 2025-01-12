package es.deusto.prog3.cap05.resueltos;

import java.util.Scanner;

public class Ejercicio4User {

	private String username;
	private String identifier;
	private String firstName;
	private String lastName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return String.format("[%s - %-9s] %s, %s", 
				identifier, username, lastName, firstName);
	}
	
	/**
	 * Crea un objeto User a partir de una cadena de texto searado
	 * por comas con los 4 atributos del usuario.
	 * @param linea String con la cadena de texto con los atributos del usuario
	 * @return User con el nuevo usuario creado
	 */
	public static Ejercicio4User parseCSV(String linea) {
		//Alternativamente se puede usar la clase StringTokenizer o String.split()
		
		try (Scanner scanner = new Scanner(linea).useDelimiter(",")) {		
			Ejercicio4User user = new Ejercicio4User();
			
			user.setUsername(scanner.next());
			user.setIdentifier(scanner.next());
			user.setFirstName(scanner.next());
			user.setLastName(scanner.next());
			
			return user;
		} catch (Exception ex) {
			System.err.println(String.format("Error parseando User: %s", ex.getMessage()));
			return null;
		}
	}
}