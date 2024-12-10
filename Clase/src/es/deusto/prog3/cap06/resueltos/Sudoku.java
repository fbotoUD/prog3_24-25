package es.deusto.prog3.cap06.resueltos;

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
		int[] casillaVacia = encontrarCasillaVacia(tablero);

		// Caso base: no hay posiciones vacías, el Sudoku está resuelto
		if (casillaVacia == null) {
			return true;
		}

		int fila = casillaVacia[0];
		int columna = casillaVacia[1];

		// Caso recursivo: probar valores del 1 al 9 en la posición vacía
		for (int valor = 1; valor <= 9; valor++) {
			if (esValorValido(tablero, fila, columna, valor)) {
				// Asignar el valor si es válido
				tablero[fila][columna] = valor;

				// Invocación recursiva: analizando el resto de casillas vacías.
				if (resolverSudoku(tablero)) {
					// Si se puede resolver el tablero se termina el proceso.
					return true;
				// Si no se encuentra la solución, se deshace la asignación.
				} else {
					tablero[fila][columna] = 0;
				}
			}
		}

		// Ninguno de los valores es válido para la casilla actual.
		// El proceso debe realizar backtrack para probar un nuevo
		// valor para la casilla asignada previamente.
		return false;
	}

	/**
	 * Busca la posición (fila/columna) de la primera casilla vacía.
	 * @param tablero int[][] con el tablero del Sudoku.
	 * @return int[] con la posición (fila/columna) de la casilla vacía.
	 */
	private static int[] encontrarCasillaVacia(int[][] tablero) {
		for (int fila = 0; fila < tablero[0].length; fila++) {
			for (int columna = 0; columna < tablero.length; columna++) {
				if (tablero[fila][columna] == 0) {
					return new int[] { fila, columna };
				}
			}
		}
		
		return null;
	}

	/**
	 * Comprueva si un valor es válido para una casilla.
	 * @param tablero int[][] con el tablero del Sudoku.
	 * @param fila int con la fila en la que está la casilla.
	 * @param columna int con la columna en la que está la casilla.
	 * @param valor int con el valor que se quier probar.
	 * @return <ul>
	 * 			 <li>true - si el valor es correcto.</li>
	 * 			 <li>false - si el valor NO es correcto.</li>
	 * 		   </ul>
	 */
	private static boolean esValorValido(int[][] tablero, int fila, int columna, int valor) {
		// Verifica si el valor ya estaba en la fila o columna 
		for (int i = 0; i < tablero[0].length; i++) {
			if (tablero[fila][i] == valor || tablero[i][columna] == valor) {
				return false;
			}
		}

		// Se obtiene la primera fila y columna del bloque en el que está la casilla.
		int filaBloque = fila - fila % 3;
		int columnaBloque = columna - columna % 3;
		
		// Verificar si el valor ya estaba en alguna casilla del bloque.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tablero[filaBloque + i][columnaBloque + j] == valor) {
					return false;
				}
			}
		}

		return true;
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
