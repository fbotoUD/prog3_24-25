package es.deusto.prog3.cap05.ejercicios;

public class Ejercicio2Cliente {

	private int id = -1;
	private String name;
	private String email;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return String.format("%2s - %s (%s) - password: %s", 
				String.valueOf(id), name, email, password);
	}
}