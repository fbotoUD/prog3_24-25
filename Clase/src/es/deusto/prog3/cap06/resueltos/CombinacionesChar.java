package es.deusto.prog3.cap06.resueltos;

import java.util.*;

public class CombinacionesChar {

    /**
     * Genera todas cadenas posibles de tamaño N combinando SIN repetición los
     * caracteres almacenados en un array. 
     * @param result List<String> con todas las combinaciones generadas.
     * @param caracteres array con los caracteres a combinar.
     * @param n longitud de las cadenas a construir.
     * @param cadena string auxiliar para ir generando la cadena actual.
     * @param caracter donde empezar en el bucle recursivo
     */
    private static void combinacionesSinRepeticion(List<String> result, char[] caracteres, int n, String cadena, int start) {
        // Caso base. Si la cadena es vacía se añade al resultado
        if (n == 0) {
        	result.add(cadena);
        } else {
            // Caso recursivo. Empezando por un caracter que no se ha tratado
            for (int i = start; i < caracteres.length; i++) {
            	//Si el carácter no está en la cadena, se añade, se reduce el tamaño
            	//y se invoca de nuevo el método.
            	if(cadena.indexOf(caracteres[i])==-1)
            	combinacionesSinRepeticion(result, caracteres, n - 1, cadena + caracteres[i],start+1);
            	
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
    	combinacionesSinRepeticion(result, caracteres, n, "",0);
    	
    	return result;
    }
    
    public static void main(String[] args) {
        //Se inicializar el array de caracteres
    	char[] conjunto = new char[]{'A', 'B', 'C', 'D', 'E'};
    	
    	//Se generan las combinaciones sin repetción
    	System.out.println("\n\nSin repetición:");
    	combinacionesSinRepeticion(conjunto, 3).forEach(c -> System.out.format("%s, ", c));
    }
}
