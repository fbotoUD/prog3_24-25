package es.deusto.prog3.cap04.resueltos;

/**
 * En este ejemplo, la tarea se descompone en varios hilos que se ejecutan
 * y suman los resultados parciales entre dos límites. Cuando todos los hilos
 * han terminado se suman estos resultados parciales para obtener el resultado
 * final.
 * La solución a este ejecicio con synchronized
 * Tiene un rendimiento bastante malo
 */
public class Ej6_1 {

	//El resultado se deja en la misma variable, hay que controlar el acceso concurrente
	static long resultado = 0;
	static Thread[] hilos = new Thread[4];
	
	static synchronized void suma(int valor) {
		resultado+=valor;
	}

   
    public static void main(String[] args) {
        // creamos un array de hilos
        
        hilos[0] = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i<=250000000; i++) {
					suma(i);
	        	}
				
			}
		});
        
        hilos[1] = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 250000001; i<=500000000; i++) {
	        		suma(i);
	        	}
				
			}
		});
        hilos[2] = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 500000001; i<=750000000; i++) {
					suma(i);
	        	}
				
			}
		});
        
        hilos[3] = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 750000001; i<=1000000000; i++) {
					suma(i);
	        	}
				
			}
		});
        
        long instanteInicial = System.currentTimeMillis();

        // creamos las tareas, los hilos y los lanzamos
        for (int i = 0; i < 4; i++) {
            hilos[i].start();
        }

        // esperamos a que todos los hilos terminen
        for (int i = 0; i < 4; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("El resultado de la suma es: " + resultado);

        // imprimimos por pantalla el tiempo total que ha tardado en ejecutarse
        System.out.println("Tiempo total: " + (System.currentTimeMillis() - instanteInicial) + " ms");
    }
}
