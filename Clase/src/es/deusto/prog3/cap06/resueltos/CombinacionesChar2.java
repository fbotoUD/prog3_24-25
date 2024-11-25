package es.deusto.prog3.cap06.resueltos;

import java.util.*;

public class CombinacionesChar2 {
    
    /**
     * Genera todas cadenas posibles de tamaño N combinando CON repetición los
     * caracteres almacenados en un array. 
     * @param result List<String> con todas las combinaciones generadas.
     * @param caracteres array con los caracteres a combinar.
     * @param n longitud de las cadenas a construir.
     * @param cadena string auxiliar para ir generando la cadena actual.
     */
    private static void combinacionesConRepeticion(List<String> result, char[] caracteres, int n, String cadena) {
        // Caso base. Si la cadena es vacía se añade al resultado
        if (n == 0) {
            result.add(cadena);
        } else {
            // Caso recursivo. Por cada caracter
            for (char c : caracteres) {
            	//Se añade el carácter a la cadena, se reduce el tamaño y se invoca.
            	combinacionesConRepeticion(result, caracteres, n - 1, cadena + c);
            }
        }
    }
    
	/**
     * Genera todas cadenas posibles de tamaño N combinando CON repetición los
     * caracteres almacenados en un array. 
	 * @param caracteres char[] con los caracteres a combinar.
	 * @param n int con la longitud de la cadena.
	 * @return List<String> con las combinaciones generadas.
	 */
    public static List<String> combinacionesConRepeticion(char[] caracteres, int n) {
    	//Se inicializa la lista con el resultado
    	List<String> result = new ArrayList<>();
    	//Se realiza la invocación al método recursivo
    	combinacionesConRepeticion(result, caracteres, n, "");
    	
    	return result;
    }

    /**
     * Genera todas cadenas posibles de tamaño N combinando SIN repetición los
     * caracteres almacenados en un array. 
     * @param result List<String> con todas las combinaciones generadas.
     * @param caracteres array con los caracteres a combinar.
     * @param n longitud de las cadenas a construir.
     * @param cadena string auxiliar para ir generando la cadena actual.
     */
    private static void combinacionesSinRepeticion(List<String> result, char[] caracteres, int n, String cadena) {
        // Caso base. Si la cadena es vacía se añade al resultado
        if (n == 0) {
            result.add(cadena);
        } else {
            // Caso recursivo. Por cada caracter
            for (char c : caracteres) {
            	//Si el carácter no está en la cadena, se añade, se reduce el tamaño
            	//y se invoca de nuevo el método.
            	if (cadena.indexOf(c) == -1) {
            		combinacionesSinRepeticion(result, caracteres, n - 1, cadena + c);
            	}
            }
        }
    }
    
	/**
     * Genera todas cadenas posibles de tamaño N combinando CON repetición los
     * caracteres almacenados en un array. 
	 * @param caracteres char[] con los caracteres a combinar.
	 * @param n int con la longitud de la cadena.
	 * @return List<String> con las combinaciones generadas.
	 */
    public static List<String> combinacionesSinRepeticion(char[] caracteres, int n) {
    	//Se inicializa la lista con el resultado
    	List<String> result = new ArrayList<>();
    	//Se realiza la invocación al método recursivo
    	combinacionesSinRepeticion(result, caracteres, n, "");
    	
    	return result;
    }
    
    public static void main(String[] args) {
        //Se inicializar el array de caracteres
    	char[] conjunto = new char[]{'A', 'B', 'C', 'D', 'E'};
    	
    	//Se generan las combinaciones con repetición
    	System.out.println("Con repetición:");
    	combinacionesConRepeticion(conjunto, 3).forEach(c -> System.out.format("%s, ", c));
    	
    	//Se generan las combinaciones sin repetción
    	System.out.println("\n\nSin repetición:");
    	combinacionesSinRepeticion(conjunto, 3).forEach(c -> System.out.format("%s, ", c));
    }
}
