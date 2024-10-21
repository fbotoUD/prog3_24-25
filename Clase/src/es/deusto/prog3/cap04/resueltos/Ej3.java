package es.deusto.prog3.cap04.resueltos;

/**
 * En este ejemplo, los hilos van a contar hasta 10
 * pero van a esperar un segundo entre cada número.
 * En este caso, el hilo principal va a interrumpir
 * al hilo que hemos creado para que deje de contar.
 */
public class Ej3 {

    public static void main(String[] args) {
        // Hilo que cuenta desde 0 hasta 10
        Thread hilo = new Thread() {
            public void run() {
                for (int i = 0; i < 10 & !Thread.interrupted(); i++) {
                    System.out.println("Hilo: " + i);
                    try {
                        // espera 1 segundo
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Me han interrumpido");
                        break; // salimos del bucle
                    }
                }

                System.out.println("Hilo terminado");
            }
        };
        
        // se inicia el hilo
        hilo.start();

        // Hilo principal que cuenta desde 10 hasta 0
        for (int i = 5; i >= 0; i--) {
            System.out.println("Hilo principal: " + i);
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// 
			}
        }

        // vamos a interrumpir el hilo que hemos creado
        // para que deje de contar cuando pueda
        hilo.interrupt();

        System.out.println("Hilo principal terminado");
    }
}