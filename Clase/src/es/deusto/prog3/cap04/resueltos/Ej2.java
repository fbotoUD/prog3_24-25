package es.deusto.prog3.cap04.resueltos;

/**
 * En este ejemplo, los hilos van a contar hasta 10
 * pero van a esperar un segundo entre cada número.
 */
public class Ej2 {

    public static void main(String[] args) {
        // Hilo que cuenta desde 0 hasta 10
        Thread hilo = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hilo: " + i);
                    try {
                        // espera 1 segundo
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // no hacemos nada ahora mismo
                    }
                }

                System.out.println("Hilo terminado");
            }
        };
        
        // se inicia el hilo
        hilo.start();

        // Hilo principal que cuenta desde 10 hasta 0
        for (int i = 10; i >= 0; i--) {
            System.out.println("Hilo principal: " + i);
        }

        System.out.println("Hilo principal terminado");
    }
}