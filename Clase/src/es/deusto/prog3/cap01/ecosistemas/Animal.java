package es.deusto.prog3.cap01.ecosistemas;

import java.util.ArrayList;

public abstract class Animal extends Organismo {

	public Animal(String especie, ArrayList<Clima> climas, double edadMin, double edadMax, int reproduccion) {
		super(especie, climas, edadMin, edadMax, reproduccion);
	}
	public Animal(Animal animal) {
		super(animal);
	}
	
	public abstract ArrayList<Organismo> getAlimentacion();
}
