package es.deusto.prog3.cap06.ejemplos;

public class Fibonacci {

	/**
	 * Calcula el la secuencia de Fibonacci para un número.
	 * @param n long con el número para el que se quiere calcular la serie de Fibonacci
	 * @return
	 */
	public static long fibonacci(long n) {
		//Caso base 1: fibonacci(0) = 0
		if (n == 0) {
			return 0;
		}
		
		//Caso base 2: fibonacci(1) = 1
		if (n == 1) {
			return 1;
		}
				
		//Invocación recursiva: fibonaci(n) = fibonacci(n-1) + fibonacci(n-2)
		return (fibonacci(n-1) + fibonacci(n-2));
	}
	
	public static String serieFibonacci(long n) {
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i<n-1; i++) {
			buffer.append(Fibonacci.fibonacci(i));
			buffer.append(", ");
		}
		
		buffer.append(Fibonacci.fibonacci(n));
		
		return buffer.toString();
	}
	
	public static void main(String[] args) {		
		System.out.format("Secuencia de Fibonacci (%d): %s", 3, Fibonacci.serieFibonacci(3));		
		System.out.format("\nSecuencia de Fibonacci (%d): %s", 5, Fibonacci.serieFibonacci(5));
		System.out.format("\nSecuencia de Fibonacci (%d): %s", 10, Fibonacci.serieFibonacci(10));
	}
}