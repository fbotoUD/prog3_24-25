package es.deusto.prog3.cap04.resueltos;

/**
 * Clase que implementa un hilo básico.
 * En el programa/hilo principal se cuenta dsde 0 hasta MAX_INT
 * imprimiendo los valores por pantalla. Antes de empezar a contar,
 * se crea e inicia un hilo que va a contar desde MAX_INT hasta 0.
 * Puedes detener el programa pulsando Ctrl+C y observar la salida
 * por consola que se van alternando de manera aleatoria para cada hilo.
 */
public class Ej1 {

    public static void main(String[] args) {
        // Hilo que cuenta desde 0 hasta MAX_VALUE
        Thread hilo = new Thread() {
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println("Hilo: " + i);
                }

                System.out.println("Hilo terminado");
            }
        };
        
        // se inicia el hilo
        hilo.start();

        // Hilo principal que cuenta desde MAX_VALUE hasta 0
        for (int i = Integer.MAX_VALUE; i >= 0; i--) {
            System.out.println("Hilo principal: " + i);
        }

        System.out.println("Programa terminado");
    }
}