package es.deusto.prog3.cap06.ejemplos;

public class ImprimirNumDescendente {

    /**
     * Imprime todos los números desde N hasta M (ambos incluidos) en orden descendente.
     * Hace uso de la pila de llamadas para invertir los números generados (se imprimen
     * durante el retorno de las llamadas recursivas).
     * @param n número inferior del rango a imprimir
     * @param m número superior del rango a imprimir.
     */
    public static void printNumDesc(int n, int m) {
    	// Caso recursivo. n <= m
        if (n <= m) {
            //Se hace la llamada recursiva y luego se imprime
            printNumDesc(n + 1, m);
            System.out.println(n);
        }
        
        // Caso base. fuera del rango, el método termina
    }

    public static void main(String[] args) {
        printNumDesc(5, 10);
    }
}