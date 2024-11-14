package es.deusto.prog3.cap04.resueltos;

/**
 * Supongamos que tienes un programa que simula la gestión de una cuenta bancaria compartida entre varios hilos.
 * La cuenta bancaria tiene un saldo inicial de 1000 euros. 
 * Programa dos hilos que intenten realizar depósitos y retiradas de dinero simultáneamente en la cuenta.
 * A la hora depositar o retirar dinero simula una verificación del saldo antes de modificar y actualiza el saldo verificado
 * Esto te permitirá ver que hay un problema
 * Es importante que la cuenta se maneje de manera segura para evitar que varios hilos accedan al saldo de la cuenta al mismo tiempo y generen inconsistencias.
 * Implementa un programa que utilice el bloque synchronized para garantizar la concurrencia segura en la gestión de la cuenta bancaria.
 */

public class CuentaBancaria {
    private double saldo = 1000.0;

    /**
     * Método que simula la verificación del saldo
     * @param cantidad
     * @return cantidad verificada
     */
    public double verificarSaldo(double cantidad) {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cantidad;
    }
    
    /**
     * Método depositar dinero en la cuenta. Actualiza el saldo verificado
     * @param cantidad
     * @return void
     */
    public synchronized void depositar(double cantidad) {
        System.out.println("Realizando depósito de " + cantidad + " euros.");
        double saldoVerificado = verificarSaldo(cantidad);
        saldo += saldoVerificado;
        System.out.println("Saldo después del depósito: " + saldo + " euros.");
    }

    /**
     * Método retirar dinero de la cuenta. Actualiza el saldo verificado
     * @param cantidad
     * @return void
     */
    public synchronized void retirar(double cantidad) {
        if (saldo >= cantidad) {
            System.out.println("Realizando retiro de " + cantidad + " euros.");
            double saldoVerificado = verificarSaldo(cantidad);
            saldo -= saldoVerificado;
            System.out.println("Saldo después del retiro: " + saldo + " euros.");
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro de " + cantidad + " euros.");
        }
    }
    /**
     * Función que obtiene el saldo de la cuenta
     * @return saldo
     */
    public double obtenerSaldo() {
        return saldo;
    }
    
    /**
     * Función Main que simula las operaciones
     * Crea un thread uno que deposita 200 euros varias veces
     * Crea otro thread que retira 150 euros varias veces
     * Imprime el saldo después de todas las operaciones
     * @param args
     */
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();

        Thread hiloDeposito = new Thread() {
        	@Override
            public void run() {
	            for (int i = 0; i < 5; i++) {
	                cuenta.depositar(200.0);
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
        	 }
        };

        Thread hiloRetiro = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                cuenta.retirar(150.0);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        hiloDeposito.start();
        hiloRetiro.start();

        try {
            hiloDeposito.join();
            hiloRetiro.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + cuenta.obtenerSaldo() + " euros.");
    }
}

