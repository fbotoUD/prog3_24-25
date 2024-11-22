package es.deusto.prog3.cap06.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * El problema está inspirado en el metro de Londres. El objetivo es encontrar todas las
 * rutas existentes entre las estaciones de "King's Cross" y "Waterloo" con 5 paradas 
 * intermedias como máximo.
 * 
 * El plano del mapa está almacenado en un mapa Map<String, List<String>> que indexa las
 * estaciones a las que se puede llegar desde cada estación.
 */
public class MetroLondres {

	public static void main(String[] args) {
		// Simulación de conexiones entre estaciones de metro en Londres
		Map<String, List<String>> conexiones = new HashMap<>();

		conexiones.put("King's Cross", Arrays.asList("Euston", "Angel"));
		conexiones.put("Euston", Arrays.asList("King's Cross", "Holborn", "Warren Street"));
		conexiones.put("Holborn", Arrays.asList("Euston", "Covent Garden"));
		conexiones.put("Angel", Arrays.asList("King's Cross", "Old Street"));
		conexiones.put("Warren Street", Arrays.asList("Euston", "Oxford Circus"));
		conexiones.put("Covent Garden", Arrays.asList("Holborn", "Leicester Square"));
		conexiones.put("Old Street", Arrays.asList("Angel", "Moorgate"));
		conexiones.put("Oxford Circus", Arrays.asList("Warren Street", "Green Park"));
		conexiones.put("Leicester Square", Arrays.asList("Covent Garden", "Piccadilly Circus"));
		conexiones.put("Moorgate", Arrays.asList("Old Street", "Bank"));
		conexiones.put("Green Park", Arrays.asList("Oxford Circus", "Westminster"));
		conexiones.put("Piccadilly Circus", Arrays.asList("Leicester Square", "Charing Cross"));
		conexiones.put("Bank", Arrays.asList("Moorgate", "Waterloo"));
		conexiones.put("Westminster", Arrays.asList("Green Park", "Waterloo"));
		conexiones.put("Charing Cross", Arrays.asList("Piccadilly Circus", "Waterloo"));
		conexiones.put("Waterloo", Arrays.asList("Bank", "Westminster", "Charing Cross"));		
		
		String inicio = "King's Cross";
		String destino = "Waterloo";

		//Llamada a buscar rutas
	}


}