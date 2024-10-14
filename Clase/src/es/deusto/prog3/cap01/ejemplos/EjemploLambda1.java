package es.deusto.prog3.cap01.ejemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

public class EjemploLambda1 {
	private static JFrame ventana;
	private static JButton boton;
	public static void creaVentana() {
		ventana = new JFrame();
		ventana.setSize(200, 200);
		boton = new JButton();
		ventana.add( boton );
		boton.addActionListener( 
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println( e.getWhen() );
					getNumbers();
				}
			}
//			(e) -> { System.out.println( e.getWhen() );}
		);
		ventana.setVisible( true );
	}
	private static void getNumbers() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

//		for(int i = 0;i<numbers.size();i++) {
//			System.out.println(numbers.get(i));
//		}
		for(int n:numbers) {
			System.out.println(n);
		}
        // Expresión lambda para imprimir cada número
//        numbers.forEach(number -> System.out.println(number));
	}
	public static void main(String[] args) {
		// ...
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						creaVentana();
					}
				}
//				 () -> { creaVentana(); }  // Interfaz
//				EjemploLambda1::creaVentana
		);
	}
}
