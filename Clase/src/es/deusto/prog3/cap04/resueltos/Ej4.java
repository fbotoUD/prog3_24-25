package es.deusto.prog3.cap04.resueltos;

import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/* En este ejemplo se lanza una tarea larga (contar)
* como parte de un escuchador. Para evitar el bloqueo
* de la interfaz gráfica, se debe lanzar la tarea en un
* hilo separado.
**/
public class Ej4 extends JFrame {
    private static final long serialVersionUID = 1L;

    public Ej4() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Ejemplo de hilo en Swing");
        setSize(320, 240);
        setTitle("Bloqueo de Swing");

        JButton button = new JButton("Lanzar tarea");
        JPanel panel = new JPanel();
        panel.add(button);

        add(panel);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // vamos a lanzar un hilo para que realice la tarea
                // que bloquea la interfaz gráfica.
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        for (int i = 0; i < 10000; i++) {
//                            System.out.println(i);
//                        }
                    	//Otra obción
                        for (int i = 1; i < 10; i++) {
                        	System.out.println("Ha pasado "+i+"s");
                        	try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								break;
							}
                        }
                    }
                });

                t.start();
            }
        });

        pack(); // ajusta el tamaño de la ventana
        setVisible(true); // muestra la ventana
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Ej4();
            }
        }); 
    }
}
