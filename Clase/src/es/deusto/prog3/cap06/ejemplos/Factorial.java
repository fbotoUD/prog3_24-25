package es.deusto.prog3.cap06.ejemplos;

public class Factorial {
	
	/**
	 * Calcula el factorial de un número.
	 * @param long número para el que se quiere calcular el factorial.
	 * @return long con el valor del factorial
	 */
	public static long factorial(long n) {
		//Caso base: 0! = 1
		if (n == 0) {
			return 1;
		//Invocación recursiva: n! = n * (n - 1)!
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {
		System.out.format("1! = %d", Factorial.factorial(1));
		System.out.format("4! = %d", Factorial.factorial(4));
		System.out.format("7! = %d", Factorial.factorial(7));
		System.out.format("10! = %d", Factorial.factorial(10));
	}
}