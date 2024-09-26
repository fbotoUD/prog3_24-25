package es.deusto.prog3.cap01.ecosistemas;

import java.util.ArrayList;

public class Herbivoro extends Animal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<Planta> alimentacion;
	
	public Herbivoro(String especie, ArrayList<Clima> climas, double edadMin, double edadMax, int reproduccion,
			ArrayList<Planta> alimentacion) {
		super(especie, climas, edadMin, edadMax, reproduccion);
		this.alimentacion = alimentacion;
	}
	public Herbivoro(Herbivoro herb) {
		super(herb);
		this.alimentacion = herb.alimentacion;
	}

	public ArrayList<Organismo> getAlimentacion() {
		// Hacemos esto para cumplir con el método abstracto, 
		// pero puede provocar problemas porque se devuelve una copia de la lista, no la propiedad alimentación en sí
		return new ArrayList<Organismo>(alimentacion);
	}

	public void setAlimentacion(ArrayList<Planta> alimentacion) {
		this.alimentacion = alimentacion;
	}

	@Override
	public String toString() {
		return "Herbivoro [alimentacion=" + alimentacion + ", especie=" + especie + ", climas=" + climas + ", edad="
				+ edad + ", edadMin=" + edadMin + ", edadMax=" + edadMax + ", reproduccion=" + reproduccion + "]";
	}
	
}
