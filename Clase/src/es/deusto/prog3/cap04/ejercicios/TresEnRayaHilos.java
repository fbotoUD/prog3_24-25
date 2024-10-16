package es.deusto.prog3.cap04.ejercicios;

/**
 * Programa dos hilos que jueguen entre sí al tres en raya,
 * usando atributos únicos static con el turno y el tablero
 * (puedes hacer que tengan distintas estrategias para jugar)

 */

public class TresEnRayaHilos {
    private static char[][] tablero = new char[3][3]; // Tablero del juego
    private static char turno = 'X'; // Jugador X comienza

    public static void main(String[] args) {
        // Inicializar el tablero con espacios en blanco
        

        // Crear e iniciar hilos para los jugadores
        
    }

    // Método para imprimir el tablero en la consola
    private static void imprimirTablero() {
        
    }

    // Método para verificar si hay un ganador o empate
    private static boolean hayGanador(char jugador) {
        // Verificar filas
        

        // Verificar columnas
        

        // Verificar diagonales
        

        return false;
    }

    // Clase Jugador que implementa la estrategia de juego
    private static class Jugador implements Runnable {
        private char simbolo;

        public Jugador(char simbolo) {
            this.simbolo = simbolo;
        }

        @Override
        public void run() {
            
        }

        private void jugar() {
            // Aquí implementa tu estrategia de juego
            // Puedes implementar una estrategia aleatoria
            
        }
    }

    // Método para cambiar el turno
    private static void cambiarTurno() {
        turno = (turno == 'X') ? 'O' : 'X';
    }

    // Método para verificar si el tablero está completo
    private static boolean tableroCompleto() {
        
        return true; // El tablero está completo
    }
}

