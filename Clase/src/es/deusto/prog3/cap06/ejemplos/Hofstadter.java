package es.deusto.prog3.cap06.ejemplos;

public class Hofstadter {
	
	public static long f(long n) {
		
		if (n == 0) {
			return 1;
		}else {
			long ret = n - m(f(n-1));
			return ret;
		}
	}
	
	public static long m(long n) {
		
		if (n == 0) {
			return 0;
		}else {
			long ret = n-f(m(n-1));
			return ret;
		}
	}
	
	public static void main(String[] args) {
		int n = 20;
		System.out.print("F:");
		for (int i = 0; i<=n;i++) System.out.print(","+f(i));
		System.out.println("");
		System.out.print("M:");
		for (int i = 0; i<=n;i++) System.out.print(","+m(i));
	}

}
