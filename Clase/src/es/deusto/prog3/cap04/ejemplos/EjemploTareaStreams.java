package es.deusto.prog3.cap04.ejemplos;

import java.util.stream.LongStream;

/**
 * En este ejemplo se realiza se paraleliza la tarea de sumar los números de 1 a
 * 1_000_000_000 pero el proceso se hace utilizando el API de streams de Java.
 * Usa esta configuración para lanzar el programa y ver cómo le afecta el número
 * de threads disponibles para la tarea paralela: 
 * -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
 */
public class EjemploTareaStreams {

    // el número máximo hasta el que sumar desde cero
    private static final int MAX_NUM = 1000_000_000;

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        
        long suma = 0;
        
        for( int i = 0; i<=MAX_NUM;i++) {
        	suma+=i;
        }
        long fin = System.currentTimeMillis();
        System.out.println("La suma es: " + suma);
        System.out.println("Tiempo: " + (fin - inicio) + " ms");
        
        inicio = System.currentTimeMillis();
        // utilizando el API de streams de Java para sumar todos los números de 1 a 1_000_000_000
        suma = LongStream.rangeClosed(0, MAX_NUM).parallel().sum();
        
        fin = System.currentTimeMillis();
        System.out.println("La suma es: " + suma);
        System.out.println("Tiempo: " + (fin - inicio) + " ms");
    }
}
