package es.deusto.prog3.cap03.ejercicios.superheroes;

import java.util.Objects;

public class Personaje {

	public enum Editorial {
		MARVEL, DC;
	}

	private int id;
	private String nombre;
	private String email;
	private Editorial editorial;
		
	public Personaje(int id, String nombre, String email, Editorial editorial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.editorial = editorial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	@Override
	public String toString() {
		return String.format("[%-6s] %d - %s (%s)", editorial, id, nombre, email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return id == other.id;
	}
}