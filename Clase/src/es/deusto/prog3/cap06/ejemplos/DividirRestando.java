package es.deusto.prog3.cap06.ejemplos;

public class DividirRestando {

    /**
     * Calcula el cociente de dos números enteros.
     * @param int con el dividendo
     * @param int con el divisor
     * @return int con el cociente
     */
    public static int calcularCociente(int dividendo, int divisor) {
        // Caso recursivo. el dividendo es mayor o igual que el divisor
        if (dividendo >= divisor) {
            // Se continua dividiendo el resultado de restar el divisor al dividendo
            // el resultado devuelto por la función se incrementa en 1.
        	return 1 + calcularCociente(dividendo - divisor, divisor);
        }
        
        return 0; // Caso base. el divisor es mayor que el dividendo
    }
    
    public static void main(String[] args) {
        System.out.format("15/2 = %d%n", calcularCociente(15, 2));
        System.out.format("15/4 = %d%n", calcularCociente(15, 4));
        System.out.format("15/3 = %d%n", calcularCociente(15, 3));
        System.out.format("15/15 = %d%n", calcularCociente(15, 15));
        System.out.format("0/4 = %d%n", calcularCociente(0, 4));
    }
}