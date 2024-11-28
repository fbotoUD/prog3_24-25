package es.deusto.prog3.cap06.resueltos;

/**
 * Ejemplo creado a partir de una solución propuesta por ChatGPT (https://chat.openai.com)
 * 
 * Este programa busca la ruta desde la entrada (E) hasta la salida (S) de un laberinto.
 * Las casillas vacías se representan con ".", los muros con "#" y las casilla por la que
 * se ha pasado con "X".
 * 
 */
public class Laberinto {

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
	 * <li>true - si NO se encuentra una ruta desde la entrada a la salida.</li>
	 * </ul>
	 */
	private static boolean buscarSalida(char[][] laberinto, int fila, int columna) {
		
		//Caso básico, si ha encontrado la salida
		if(laberinto[fila][columna]=='S') {
			return true;
		}
		
		//Caso básico si hay muro
		if(laberinto[fila][columna]=='#') {
			return false;
		}
		
		//Caso básico ya está visitada
		if(laberinto[fila][columna]=='X') {
			return false;
		}
		
		laberinto[fila][columna] = 'X';
		
		//Caso recursivo
		//buscar a la derecha
		if(columna+1 < laberinto[fila].length)
			if(buscarSalida(laberinto, fila, columna+1)) return true;
		
		//buscar a la izquierda
		if(columna-1 > 0)
			if(buscarSalida(laberinto, fila, columna-1)) return true;
		
		//buscar hacia abajo
		if(fila+1 < laberinto.length)
			if(buscarSalida(laberinto, fila+1, columna)) return true;
		
		//buscar hacia abajo
		if(fila-1 > 0)
			if(buscarSalida(laberinto, fila-1, columna)) return true;
		
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