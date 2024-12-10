package es.deusto.prog3.cap06.resueltos;

public class EscaleraInfinita {
	
	/**
	 * Caso base: Si el peldaño es 1, el tesoro es 1. Esto detiene la recursión.
	 * Caso recursivo para peldaños pares: Se calcula el tesoro como el doble del peldaño anterior.
	 * Caso recursivo para peldaños impares: Se calcula el tesoro sumando 1 al peldaño anterior.
	 * Lógica del programa principal: Se solicita un número al usuario,
	 * y el método recursivo calcula el valor del tesoro en ese peldaño.
	 */

    // Método recursivo para calcular el valor del tesoro en el peldaño dado
    public static int calcularTesoro(int peldaño) {
        if (peldaño == 1) {
            return 1; // Caso base: el primer peldaño siempre tiene tesoro 1
        } else if (peldaño % 2 == 0) {
            return 2 * calcularTesoro(peldaño - 1); // Si es par, el tesoro es el doble del anterior
        } else {
            return calcularTesoro(peldaño - 1) + 1; // Si es impar, el tesoro es el anterior más 1
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Introduce el número del peldaño: ");
        int peldaño = scanner.nextInt();

        if (peldaño <= 0) {
            System.out.println("El número del peldaño debe ser mayor que 0.");
        } else {
            int tesoro = calcularTesoro(peldaño);
            System.out.println("El tesoro en el peldaño " + peldaño + " es: " + tesoro);
        }

        scanner.close();
    }
}

