package es.deusto.prog3.cap06.ejemplos;

public class InvertirString {

    /**
     * Método que recibe un string y devuelve un string invertido carácter a carácter.
     * @param str string a invertir
     * @return string invertido carácter a carácter
     */
    public static String invertirRecursivo(String str) {
        // Caso base. Si es el string vacío devolvemos directamente el string vacío.
        if (str.isEmpty()) return "";
        // Caso recursivo. Invertir el string actual menos el primer caracter + primer carácter
        return invertirRecursivo(str.substring(1)) + str.charAt(0);
    }
    
    /**
     * Método que recibe un string y devuelve un string invertido carácter a carácter.
     * @param str string a invertir
     * @return string invertido carácter a carácter
     */
    public static String invertirIterativo(String str) {
    	StringBuffer buffer = new StringBuffer();
    	    	
    	for (int i=str.length()-1; i>0; i--) {
    		buffer.append(str.charAt(i));    	
    	}
    	
    	return buffer.toString();
    }
        
    /**
     * Método que recibe un string y devuelve un string invertido
     * @param str string a invertir
     * @return string invertido carácter a carácter
     */
    //UNA IMPLEMENTACIÓN NO RECURSIVA
    public static String invertirReverse(String str) {
    	StringBuffer builder = new StringBuffer(str);
    	builder.reverse();
    	return builder.toString();
    }
    
    
    public static void main(String[] args) {
        String s = "a"; // string longitud 1
        System.out.format("\"%s\" -> \"%s\"%n", s, invertirRecursivo(s));
                
        s = "Hola, esto es una prueba"; // string general
        System.out.format("\"%s\" -> \"%s\"%n", s, invertirRecursivo(s));        
    }
}
