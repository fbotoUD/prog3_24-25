package es.deusto.prog3.cap06.ejemplos;

public class ImprimirNumAscendente {

    /**
     * Imprime todos los números desde N hasta M (ambos incluidos) en orden ascendente.
     * @param n número inferior del rango a imprimir
     * @param m número superior del rango a imprimir
     */
    public static void printNumAsc(int n, int m) {
        // Caso recursivo. n <= m
        if (n <= m) {
            //Se imprime el número y se hace la invocación recursiva
            System.out.println(n);
            printNumAsc(n + 1, m);
        }
        
        // Caso base. fuera del rango, el método termina
    }

    public static void main(String[] args) {
        printNumAsc(5, 10);
    }
 }