package es.deusto.prog3.cap06.ejercicios;

/**
 * Ejemplo creado a partir de una solución propuesta por ChatGPT (https://chat.openai.com)
 * 
 * Este programa resuelve tableros de Sodoku de manera recursiva. El proceso básico
 * de resolución consiste en intentar asignar valor a las casillas vacías. Para ello
 * se busca la siguiente casilla vacía y se intenta asignar cada uno de los valores.
 * Antes de confirmar la asignación, se valida que el valor es correcto con el método
 * esValorValido().
 */ 
public class Sudoku {

	public static void main(String[] args) {
		int[][] tablero = { 
				{ 5, 3, 0, 0, 7, 0, 0, 0, 0 }, 
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
				{ 4, 0, 0, 8, 0, 3, 0, 0, 1 }, 
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		System.out.println("Sudoku a resolver:");
		imprimirTablero(tablero);
		
		if (resolverSudoku(tablero)) {
			System.out.println("\nSudoku solucionado:");			
			imprimirTablero(tablero);
		} else {
			System.out.println("\nNo hay solución para el Sudoku.");
		}
	}

	/**
	 * Resuelve el Soduku de manera recursiva.
	 * @param tablero int[][] con el tablero del Sudoku.
	 * @return <ul>
	 * 			 <li>true - si se puede resolver el Sudoku.</li>
	 * 			 <li>false - si el Sudoku NO tiene solución.</li>
	 * 		   </ul>
	 */
	private static boolean resolverSudoku(int[][] tablero) {

		return false;
	}
	


	/**
	 * Imprime en la consola el tablero.
	 * @param tablero int[][] con el tablero.
	 */
	private static void imprimirTablero(int[][] tablero) {
		for (int[] fila : tablero) {
			for (int valor : fila) {
				System.out.print(valor + " ");
			}
			
			System.out.println();
		}
	}
}
