package es.deusto.prog3.cap06.ejemplos;

public class InvertirPalabras {

    /**
     * Método recursivo que invierte las palabras de una frase.
     * @param frase string al que aplicar la inversión palabra a palabra.
     * @return string invertido palabra a palabra.
     */
    private static String invertirPalabras(String frase) {
        // Caso base 1. Si no hay palabras se devuelve una cadena vacía.
        if (frase.isEmpty()) return "";
        
        //Dividimos la frase en dos fragmentos cortando por el primer espacio en blanco.
        String[] partes = frase.split(" ", 2);

        // Caso base 2. Si sólo hay una palabra, se devuelve es palabra
        if (partes.length < 2) {
            return partes[0];
        }

        // Caso recusivo.
        //Invertimos el segundo fragmento de la frase, y el primero va al final.
        return invertirPalabras(partes[1]) + " " + partes[0];
    }
    
    public static void main(String[] args) {
        String s = ""; // string vacío
        System.out.format("\"%s\" -> \"%s\"%n", s, invertirPalabras(s));

        s = "prueba"; // string con una única palabra
        System.out.format("\"%s\" -> \"%s\"%n", s, invertirPalabras(s));

        s = "Hola, esto es una prueba. Vamos a invertir la frase."; // string con varias palabras
        System.out.format("\"%s\" -> \"%s\"%n", s, invertirPalabras(s));
    }
}
