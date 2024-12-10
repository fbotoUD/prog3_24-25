package es.deusto.prog3.cap06.resueltos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class InvertirLista {

    /**
     * Método recursivo que invierte el orden de los objetos de una lista.
     * @param list List<T> con la lista a invertir.
     */
    public static <T> void invertirRecursivo(List<T> list) {
        // Caso base. Si la lista está vacía o el nula, se termina el proceso.
        if (list.isEmpty() || list == null) return;

        //Se elimina el primer elemento de la lista.
        T primerElemento = list.remove(0);
        
        //Caso recursivo. Se invierte la lista después de quitar el primer elemento.
        invertirRecursivo(list);
        
        //Se añade el primer elemento a la lista.
        list.add(primerElemento);        
    }
    
    /**
     * Método recursivo que invierte el orden de los objetos de una lista.
     * @param list List<T> con la lista a invertir.
     */
    public static <T> void invertirIterativo(List<T> list) {
    	T aux;
    	
    	//Se recorre la lista con dos índices y se intercambian los valores
    	// i - desde 0
    	// j - desde n-1
    	for (int i=0, j=list.size()-1; i < j; i++, j--) {
    		aux = list.get(i);
    		list.set(i, list.get(j));
    		list.set(j, aux);
    	}
    }
    
    /**
     * Método que invierte el orden de los objetos de una lista haciendo uso
     * del método reverse() de Collections.
     * @param list List<T> con la lista a invertir.
     */
    public static <T> void invertirReverse(List<T> list) {
    	//Se utiliza el método del API de Collections
    	Collections.reverse(list);
    }
    
    public static void main(String[] args) {    	    	
    	List<String> cadenas = new ArrayList<>(Arrays.asList("ESTO", "ES", "UNA", "PRUEBA", "DE", "ORDENACIÓN"));    	
    	System.out.format("Invertir recursivo\n%s -> ", cadenas.toString());    	
    	invertirRecursivo(cadenas);
    	System.out.println(cadenas);

    	cadenas = new ArrayList<>(Arrays.asList("ESTO", "ES", "UNA", "PRUEBA", "DE", "ORDENACIÓN"));
    	System.out.format("\nInvertir iterativo\n%s -> ", cadenas.toString());    	
    	invertirIterativo(cadenas);
    	System.out.println(cadenas);
    	
    	cadenas = new ArrayList<>(Arrays.asList("ESTO", "ES", "UNA", "PRUEBA", "DE", "ORDENACIÓN"));
    	System.out.format("\nInvertir reverse\n%s -> ", cadenas.toString());    	
    	invertirReverse(cadenas);
    	System.out.println(cadenas);
    	
    	List<Integer> numeros = new ArrayList<>(Arrays.asList(123, 45, 67, 88, 9));    	
    	System.out.format("\nInvertir recursivo\n%s -> ", numeros.toString());
    	invertirRecursivo(numeros);
    	System.out.println(numeros);
    	
    	numeros = new ArrayList<>(Arrays.asList(123, 45, 67, 88, 9));    	
    	System.out.format("\nInvertir iterativo\n%s -> ", numeros.toString());
    	invertirIterativo(numeros);
    	System.out.println(numeros);
    	
    	numeros = new ArrayList<>(Arrays.asList(123, 45, 67, 88, 9));    	
    	System.out.format("\nInvertir reverse\n%s -> ", numeros.toString());
    	invertirReverse(numeros);
    	System.out.println(numeros);
    }
}