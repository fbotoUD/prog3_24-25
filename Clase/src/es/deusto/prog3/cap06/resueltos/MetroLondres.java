package es.deusto.prog3.cap06.resueltos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ejemplo creado a partir de una solución propuesta por ChatGPT (https://chat.openai.com)
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

		buscarRutas(conexiones, inicio, destino, new ArrayList<>(Arrays.asList(inicio)));
	}

	/**
	 * Busca las rutas alternativa entre origen y destino con un máximo de 5 paradas
	 * intermedias.
	 * @param conexiones Map<String, List<String>> con el plano del metro.
	 * @param origen String con el nombre de la estación origen.
	 * @param destino String con el nombre de la estación destino.
	 * @param rutaParcial List<String> con la ruta parcial que se va creando poco a poco.
	 */
	private static void buscarRutas(Map<String, List<String>> conexiones, String origen, String destino, List<String> rutaParcial) {
		if (rutaParcial.size() > 7) {
			// Límite de paradas alcanzado, abandonar esta ruta
			return;
		}

		// Si el origen actual es igual al destino, hemos encontrado una ruta.
		if (origen.equals(destino)) {
			System.out.format("\nRuta de %d paradas: ", rutaParcial.size());
			
			for (int i=0; i<rutaParcial.size(); i++) {
				System.out.format("%s%s", rutaParcial.get(i), i == rutaParcial.size() - 1 ? "" : " -> ");
			}
			
			return;
		}

		// Se analizan todas las estaciones destino desde la actual
		for (String estacionActual : conexiones.get(origen)) {

			// Evitar repeticiones de paradas
			if (!rutaParcial.contains(estacionActual)) {	
				// Se añade la estación a la ruta parcial
				rutaParcial.add(estacionActual);

				// Llamar recursivamente 
				buscarRutas(conexiones, estacionActual, destino, rutaParcial);

				// Eliminar la última estación para generar probar una nueva ruta
				rutaParcial.remove(rutaParcial.size() - 1);
			}
		}
	}
}