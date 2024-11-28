package es.deusto.prog3.cap06.ejercicios;

public class Recursion {
	
	/**
	 * Representa las tres operaciones posibles a aplicar.
	 *
	 */
	enum Operation {
		PLUS_FIVE("+5"), // +5
		MINUS_THREE("-3"), // -3
		TIMES_TWO("x2"); // x2
		
		private String text;
		
		private Operation(String text) {
			this.text = text;
		}
		
		@Override
		public String toString() {
			return text; 
		}
	}
	
	/**
	 * Aplica la operación sobre el valor pasado como parámetro.
	 * @param op operación a aplicar
	 * @param value valor sobre el que aplicar la operación
	 * @return resultado de aplicar la operación indicada sobre el valor pasado
	 */
	public static int applyOperation(Operation op, int value) {
		switch (op) {
			case PLUS_FIVE: return value + 5;
			case MINUS_THREE: return value - 3;
			case TIMES_TWO: return value * 2;
			default: return value;
		}
	}
	
	public static void main(String[] args) {
		searchSequence(5, 29);
		searchSequence(3, 18);
		searchSequence(5, 38);
		searchSequence(2, -8);
		searchSequence(5, 5);
		searchSequence(4, 100);
	}
	
	// T4 //////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Busca e imprime por pantalla la secuencia (o secuencias) que transforman desde el número inicial al final.
	 * @param start número inicial desde el que transformar
	 * @param end número a obtener al aplicar las operaciones
	 */
	private static void searchSequence(int start, int end) {
		
	}
	
}
