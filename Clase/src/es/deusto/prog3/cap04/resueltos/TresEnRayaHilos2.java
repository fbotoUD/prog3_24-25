package es.deusto.prog3.cap04.resueltos;

/**
 * Programa dos hilos que jueguen entre sí al tres en raya,
 * usando atributos únicos static con el turno y el tablero
 * (puedes hacer que tengan distintas estrategias para jugar)

 */

public class TresEnRayaHilos2 {
    private static char[][] tablero = new char[3][3]; // Tablero del juego
    private static char turno = 'X'; // Jugador X comienza

    public static void main(String[] args) {
        // Inicializar el tablero con espacios en blanco
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Crear e iniciar hilos para los jugadores
        Thread jugadorX = new Thread(new Jugador('X'));
        Thread jugadorO = new Thread(new Jugador('O'));

        jugadorX.start();
        jugadorO.start();
    }

    // Método para imprimir el tablero en la consola
    private static void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Método para verificar si hay un ganador o empate
    private static boolean hayGanador(char jugador) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugador && tablero[1][j] == jugador && tablero[2][j] == jugador) {
                return true;
            }
        }

        // Verificar diagonales
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
            (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) {
            return true;
        }

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
            while (true) {
                    if (turno == simbolo) {
                        turno();
                    }
            }
        }
        
        private synchronized void turno() {
        	System.out.println("Turno del jugador " + simbolo);
            jugar();
            imprimirTablero();
            if (hayGanador(simbolo)) {
                System.out.println("¡El jugador " + simbolo + " ha ganado!");
                System.exit(0);
            } else if (tableroCompleto()) {
                System.out.println("¡Empate!");
                System.exit(0);
            }
            cambiarTurno();
        }

        private void jugar() {
            // Aquí implementa tu estrategia de juego
            // Este ejemplo usa una estrategia aleatoria
            int fila, columna;
            do {
                fila = (int) (Math.random() * 3);
                columna = (int) (Math.random() * 3);
            } while (tablero[fila][columna] != ' ');

            tablero[fila][columna] = simbolo;
        }
    }

    // Método para cambiar el turno
    private static void cambiarTurno() {
        turno = (turno == 'X') ? 'O' : 'X';
    }

    // Método para verificar si el tablero está completo
    private static boolean tableroCompleto() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false; // Todavía hay casillas vacías
                }
            }
        }
        return true; // El tablero está completo
    }
}

