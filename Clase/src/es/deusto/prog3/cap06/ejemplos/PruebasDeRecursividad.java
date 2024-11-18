package es.deusto.prog3.cap06.ejemplos;

public class PruebasDeRecursividad {
	
	private static long numLlamadas;
	
	public static void main(String[] args) {
		numLlamadas = 0;
		 int varPrueba = 7;
		 f( varPrueba );
		// conteo( 1 );
		// System.out.println( numLlamadas );
		// hanoi( 10, 'a', 'c', 'b' );
//		int[] vector = { 1, 3, 7, 11, 15, 19, 21, 23, 31, 35, 39, 42, 48, 51 };
//		System.out.println( buscarValor( vector, 0, vector.length-1, 21 ) );
	}
	
	// Devuelvo la posición si se encuentra, -1 si no se encuentra
	// ¿Qué es buscarValor recursivo del vector desde inicio hasta fin?
	// - calcular mitad
	//   - comparar elemento en la mitad con el que busco:
	//     - si son iguales, caso base de éxito: devuelvo la posición mitad
	//     - si buscado > elemento de la mitad, devuelvo buscarValor desde mitad+1 hasta fin
	//     - si buscado < elemento de la mitad, devuelvo buscarValor desde inicio hasta mitad-1
	// - caso base de fracaso: inicio > fin  [vector vacío]
	private static int buscarValor( int[] vector, int inicio, int fin, int buscado ) {
		System.out.println( "Buscando valor " + buscado + " entre " + inicio + " y " + fin );
		if (inicio > fin) {
			return -1;
		} else {
			int mitad = (inicio + fin) / 2;
			if (buscado == vector[mitad]) {
				return mitad;
			} else if (buscado > vector[mitad]) {
				return buscarValor( vector, mitad+1, fin, buscado );
			} else {
				return buscarValor( vector, inicio, mitad-1, buscado );
			}
		}
	}
	
	
	
	private static void hanoi( int numDiscos, char origen, char destino, char auxiliar ) {
		if (numDiscos==1) {
			System.out.println( "Mover disco 1 de " + origen + " a " + destino );
		} else {
			hanoi( numDiscos-1, origen, auxiliar, destino );
			System.out.println( "Mover disco " + numDiscos + " de " + origen + " a " + destino );
			hanoi( numDiscos-1, auxiliar, destino, origen );
		}
	}
	

	// Contar (sacar a consola) de i a 4000:
	//    - Caso recursivo:
	//      - sacar a consola i
	//      - Contar de i+1 a 4000
	//    - Caso base: si i==4000
	//      - sacar a consola 4000
	private static void conteo( int i ) {
		if (i==5) {
			System.out.println( i );
		} else {
			System.out.println( i );
			conteo( i+1 );
			System.out.println( i );
		}
	}
	
	@SuppressWarnings("unused")
	private static void f( long param ) {
		param = param + numLlamadas;
		numLlamadas++;
		System.out.println( "soy f en la llamada " + numLlamadas + " cálculo " + param );
		f( param );
	}
}
