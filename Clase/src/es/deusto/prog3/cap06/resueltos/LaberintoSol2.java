package es.deusto.prog3.cap06.resueltos;

/**
 * Ejemplo creado a partir de una solución propuesta por ChatGPT (https://chat.openai.com)
 * 
 * Este programa busca la ruta desde la entrada (E) hasta la salida (S) de un laberinto.
 * Las casillas vacías se representan con ".", los muros con "#" y las casilla por la que
 * se ha pasado con "X".
 * 
 */
public class LaberintoSol2 {

	public static void main(String[] args) {
		char[][] laberinto = {
                { 'E', '.', '.', '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.' },
                { '.', '#', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#', '.', '.', '.' },
                { '.', '.', '.', '#', '.', '#', '#', '#', '.', '#', '.', '#', '.', '.', '.' },
                { '.', '.', '.', '#', '.', '.', '.', '.', '.', '#', '.', '#', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.' },
                { '.', '.', '.', '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '#', '.', '.', '.', '#', '#', '#', '#', '.', '.', '.', '.' },
                { '.', '.', '.', '#', '#', '#', '.', '#', '.', '.', '.', '#', '#', '#', '#' },
                { '.', '.', '.', '.', '.', '#', '.', '#', '.', '.', '.', '.', '.', '.', '#' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', 'S' }
        };
		
		if (buscarSalida(laberinto, 0, 0)) {
			System.out.println("Laberinto resuelto:\n");
			imprimirLaberinto(laberinto);
		} else {
			System.out.println("No hay solución para el laberinto.");
		}
	}

	/**
	 * Busca la salida del laberinto desde una posición (fila/columna).
	 * @param laberinto char[][] con el laberinto.
	 * @param fila int con la fila actual.
	 * @param columna int con la columna actual
	 * @return <ul>
	 * <li>true - si se encentra una ruta desde la entrada a la salida.</li>
	 * <li>true - si NO se encentra una ruta desde la entrada a la salida.</li>
	 * </ul>
	 */
	private static boolean buscarSalida(char[][] laberinto, int fila, int columna) {
		int filas = laberinto.length;
		int columnas = laberinto[0].length;
		
		// Caso Base: Sobrepasamos los límite o estamos sobre un muro o retrocedemos
		if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas || 
		    laberinto[fila][columna] == '#' || laberinto[fila][columna] == 'X') {			
			return false;
		}
		
		// Caso Base: Estamos en la salida		
		if (laberinto[fila][columna] == 'S') {
			return true;
		}
		
		// Actualizamos la casilla actual
		laberinto[fila][columna] = 'X';

		// Caso recursivo: se busca la salida hacia la ABAJO (fila + 1)
		if (buscarSalida(laberinto, fila + 1, columna)) {
			return true;
		}

		// Caso recursivo: se busca la salida hacia la ARRIBA (fila - 1)
		if (buscarSalida(laberinto, fila - 1, columna)) {
			return true;
		}
		
		// Caso recursivo: se busca la salida hacia la DERECHA (columna + 1)			
		if (buscarSalida(laberinto, fila, columna + 1)) {
			return true;			
		}
		
		// Caso recursivo: se busca la salida hacia la IZQUIERDA (columna - 1)
		if (buscarSalida(laberinto, fila, columna - 1)) {
			return true;
		}
					
		// Si no hemos encontrado la salida desacemos el movimiento 
		laberinto[fila][columna] = '.';
		
		//Se para la recursividad
		return false;
	}
	
	/**
	 * Imprime el laberinto en la consola.
	 * @param laberinto char[][] con el laberinto.
	 */
	private static void imprimirLaberinto(char[][] laberinto) {
		for (char[] fila : laberinto) {
			for (char celda : fila) {
				System.out.print(celda + " ");
			}
			
			System.out.println();
		}
	}
}