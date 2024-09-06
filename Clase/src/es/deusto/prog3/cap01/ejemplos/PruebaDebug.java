package es.deusto.prog3.cap01.ejemplos;

/** Clase de prueba para depurar con Eclipse (Debug = F11)
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class PruebaDebug {

	private static String miMens = "";
	
	private static void mensajeaNumeros(int i) {
		for (int j=0; j<i; j++)
			sacaMens( "Número " + j );
		
		
	}
	
	private static void haceCosas() {
		int a = 5;
        int b = 7;
        
        int suma = a + b;
        int resta = a - b;
        int multiplicacion = a * b;
        int division = a / b;
        
             
        for (int i = 0; i < 10; i++) {
            suma++;
            miMens = null;
            resta--;
        }
	}
	private static void sacaMens( String mens ) {
		System.out.println( "Mensaje: " + mens + " (longitud " + mens.length() + ")" );
	}
	public static void main(String[] args) {
		mensajeaNumeros(7);
		haceCosas();
//		System.out.println(miMens);
		sacaMens(miMens);
	}

}
