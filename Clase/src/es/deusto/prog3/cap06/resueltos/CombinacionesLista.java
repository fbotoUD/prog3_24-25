package es.deusto.prog3.cap06.resueltos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinacionesLista {
	
    /**
     * Genera listas de combinaciones CON REPETICIÓN de n elementos de una lista de elementos. 
     * @param <T> el método es genérico y puede aplicarse a cualquier tipo de dato.
     * @param result List<List<T>> lista con las combinaciones. Cada una es una lista de elemntos.
     * @param elementos List<T> con los elementos a combinar.
     * @param n int con el número de elementos de cada combinación.
     * @param temp List<T> lista temporal utilizada para crer cada combinación.
     */
    private static <T> void combinaciones(List<List<T>> result, List<T> elementos, int n, List<T> temp) {
        // Caso base. n=0 
        if (n == 0) {
        	//Se añade la lista temporal a la lista de resultados
            result.add(new ArrayList<>(temp));            
        } else {
            // Caso recursivo. Por cada elemento        	
        	for(T e : elementos) {
        		if(!temp.contains(e)) {
	        		//Se añade el elemento a la lista temporal
	        		temp.add(e);
	        		//Se realiza la invocación recursiva para n-1 elementos y una lista temporal
	        		combinaciones(result, elementos, n-1, temp);
	        		//Se elimina el último de la lista temporal
	        		temp.remove(temp.size()-1);
        		}
        	}
        }
    }
    
    /**
     * Genera listas de combinaciones CON REPETICIÓN de n elementos de una lista de elementos. 
     * @param <T> el método es genérico y puede aplicarse a cualquier tiempo de dato.
     * @param elementos List<T> con los elementos a combinar.
     * @param n int con el número de elementos de cada combinación.
     * @return List<List<T>> lista con las combinaciones. Cada una es una lista de elemntos.
     */
    public static <T> List<List<T>> combinaciones(List<T> elementos, int n) {
    	//Se inicializa la lista de combinaciones que se devolverá como resultado.
    	List<List<T>> result = new ArrayList<>();
    	//Se invoca al método recursivo
    	combinaciones(result, elementos, n, new ArrayList<>());
    	//Se devuelve el resultado.
    	return result;
    }
    


    public static void main(String[] args) {
    	//Prueba con caracteres
    	List<Integer> numeros = Arrays.asList(1, 2, 3);    	
    	List<List<Integer>> resultNum = combinaciones(numeros, 2);
    	System.out.format("Combinaciones de %d elementos de %s: %d\n", 2, numeros.toString(), resultNum.size());
    	resultNum.forEach(r -> System.out.println(r));
    	
    	//Prueba con cadenas de texto
    	List<String> cadenas = Arrays.asList("AZUL", "ROJO", "VERDE");    	
    	List<List<String>> resultStr = combinaciones(cadenas, 3);
    	System.out.format("\nCombinaciones de %d elementos de %s: %d\n", 3, cadenas.toString(), resultStr.size());
    	resultStr.forEach(r -> System.out.println(r));
    	
    }
}