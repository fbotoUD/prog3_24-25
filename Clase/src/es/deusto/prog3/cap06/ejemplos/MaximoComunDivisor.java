package es.deusto.prog3.cap06.ejemplos;

public class MaximoComunDivisor {

	/**
	 * Calcula el máximo común divisor de dos números.
	 * @param n long con el priemr número.
	 * @param m long con el segundo número.
	 * @return long con el número más grande entre el que que son
	 *         divisibles los dos números.
	 */
	public static long maximoComunDivisor(long n, long m) {
		//Caso base: los número son iguales
		if (n == m) {
			return n;
		}
		
		//Invocaciones recursivas: se resta el valor menor al mayor
		//y se invoca de nuevo al método.
		if (n > m) {
			return maximoComunDivisor(n-m, m);
		} else {
			return maximoComunDivisor(n, m-n);
		}
	}
		
	public static void main(String[] args) {
		System.out.println(String.format("El máximo común divisor de 7 y 4 es %d", MaximoComunDivisor.maximoComunDivisor(7, 4)));
		System.out.println(String.format("El máximo común divisor de 75 y 45 es %d", MaximoComunDivisor.maximoComunDivisor(75, 45)));
	}
}