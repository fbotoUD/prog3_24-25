package es.deusto.prog3.cap04.resueltos;

public class Ejercicio6_partido {
	
	//mueve las variables fuera para que sean de clase
	/**
	 * ¿Porqué no puedo acceder a una variable en el propio método?
	 * Respuesta ChatGPT
	 * El motivo de esta restricción es evitar inconsistencias
	 * o comportamientos inesperados, ya que las variables locales
	 * en un método tienen una vida útil muy corta y son almacenadas en la pila del thread.
	 * Si intentas modificar una variable desde otro thread o clase anónima,
	 * eso podría causar errores si esa variable ya ha dejado de existir en el contexto original.
	 */
	
	long var0=0;
	long var1=0;
	long var2=0;
	long var3=0;
	
	public void contador() {
		
		//el problema era que no se puede acceder a una variable dentro del
		//método de una clase si luego se modifica
		//si intentas modificarla como es el caso, da un error
		//aunque también podrías usar un array
		//por ejemplo long[] vars = new long[4];
//		long var0=0;
//		long var1=0;
//		long var2=0;
//		long var3=0;
		
		long[] vars = new long[4];
	
		
		long tiempo=System.currentTimeMillis();
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				long temp = 0;
				for(int i=0;i<250000000;i++) {
					var0+=i;
					//para la solución con array
					//vars[0]+=i;
				}
			}
		});
		t1.start();
				
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<250000000;i++) {
					var1+=1;
				}
			}
		});
		t2.start();
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<250000000;i++) {
					var2+=1;
				}
			}
		});
		t3.start();
		
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<250000000;i++) {
					var3+=1;
				}
			}
		});
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		}catch (Exception e) {}
		
		
		long tiempo_final = System.currentTimeMillis()-tiempo;
		
		long valor=var0+var1+var2+var3;
		System.out.println("Valor de var: " + valor + " milisegundos diferencia:  " + tiempo_final);

		
	}
	public static void main(String[] args) {
		
		new Ejercicio6_partido().contador();
		
	}
	
	
	public static long sumar(long var) {
		for(int i=0;i<250000000;i++) {
			var+=i;
		}
		return var;
	}
	
	
	
}
