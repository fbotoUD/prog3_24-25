package es.deusto.prog3.cap06.resueltos;

import java.util.ArrayList;
import java.util.List;

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
	
	private final static int MAX_OPS = 5;
	
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
	 * @param end número a obtener al aplicar las transformaciones
	 */
	private static void searchSequence(int start, int end) {
		searchSequenceRecursive(start, end, start, new ArrayList<>());
	}
	
	private static void searchSequenceRecursive(int start, int end, int value, List<Operation> operations) {
		if (value == end) { // case base. se ha encontrado la solución
			System.out.format("%d -> %d: %s%n", start, end, operations);
		} else if (operations.size() < MAX_OPS) {
			// caso recursivo
			// se prueba cada una de las posibles operaciones en orden
			for (Operation op : Operation.values()) {
				operations.add(op); // se añade la operacion y se aplica en la llamada recursiva
				searchSequenceRecursive(start, end, applyOperation(op, value), operations);
				// se elimina la última operación probada de la lista de operaciones
				operations.remove(operations.size() - 1);
			}
		} // caso base. si se ha alcanzado el número máximo de operaciones permitidas MAX_OPS no se hace nada
	}
}
