package es.deusto.prog3.cap06.ejemplos;
public class Palindromo {

    /**
     * Determina si un string es palíndromo. 
     * El proceso se realiza comparando, desde cada extremo, los caracteres
     * por parejas. Cuando se encuentra una pareja que no coincide, el string
     * no es un palíndromo.
     * @param str string a comprobar si es o no palíndromo
     * @return devuelve true/false si el string recibido es o no palíndromo, respectivamente.
     */
    private static boolean esPalindromo(String str) {
        // Caso base 1. si el string es vacío o de longitud 1 es palíndromo
        if (str.length() <= 1) return true;

        // Caso base 2. si al comparar el caracter inicial y final del string
        // son distintos, no es palíndromo
        if (str.charAt(0) != str.charAt(str.length() - 1)) return false;

        // Caso recursivo. comrpueba si el string resultante de eliminar el
        // primer y el último caracter es palíndromo
        return esPalindromo(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        String s = "Se es o no se es";
        System.out.format("\"%s\": %b%n", s, esPalindromo(s.toLowerCase().replace(" ", "")));
        
        s = "No deseo yo ese don";
        System.out.format("\"%s\": %b%n", s, esPalindromo(s.toLowerCase().replace(" ", "")));
        
        s = "esta frase no es un palíndromo";
        System.out.format("\"%s\": %b%n", s, esPalindromo(s.toLowerCase().replace(" ", "")));

        s = "a ";
        System.out.format("\"%s\": %b%n", s, esPalindromo(s.toLowerCase().replace(" ", "")));

        s = "";
        System.out.format("\"%s\": %b%n", s, esPalindromo(s.toLowerCase().replace(" ", "")));
    }
}