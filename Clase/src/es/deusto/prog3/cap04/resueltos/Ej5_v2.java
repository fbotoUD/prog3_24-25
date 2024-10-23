package es.deusto.prog3.cap04.resueltos;

import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;


/**
 * Este ejemplo muestra cómo lanzar un hilo para realizar una tarea que bloquea
 * la UI y además mostrar el progreso del thread creado en una JProgressBar.
 * Como el thread es externo al hilo principal de Swing, las actualizaciones que
 * este hilo que hemos creado quiere mostrar en la JProgressBar se hacen 
 * utilizando SwingUtilities.invokeLater() para que se ejecuten en el hilo de
 * Swing correctamente.
**/
public class Ej5_v2 extends JFrame {
    private static final long serialVersionUID = 1L;

    private Thread t; // referencia al hilo que se va a lanzar

    public Ej5_v2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Ejemplo barra de progreso");
        setSize(320, 240);
        setTitle("Bloqueo de Swing");

        JButton startButton = new JButton("Iniciar");
        JButton stopButton = new JButton("Parar");
        
        // el boton de parar lo vamos a deshabilitar
        stopButton.setEnabled(false);

        JPanel panel = new JPanel();

        panel.add(startButton);
        panel.add(stopButton);

        add(panel);

        // creamos la barra de progreso de 0 a 100
        // con texto que indica el porcentaje
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        // añadimos la barra de progreso a la ventana
        add(progressBar, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // antes de lanzar el hilo vamos a establecer
                // el boton de iniciar a falso y el de parar a true
                // esto evita poder lanzar más de un hilo a la vez
                startButton.setEnabled(false);
                stopButton.setEnabled(true);

                // vamos a lanzar un hilo para que realice la tarea
                // que bloquea la interfaz gráfica.
                t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // el bucle comprueba la condición de interrupción
                        for (int i = 0; i <= 100 & !Thread.interrupted(); i++) {
                            System.out.println(i);

                            // actualizamos la barra de progreso
                            // con el porcentaje del contador de 0 a 100
                            int progress = i;
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setValue((int) (progress));
                                }
                            });
                            
                            try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								break;
							}

                        }

                        // al finalizar la tarea volvemos a habilitar
                        // el boton de iniciar y deshabilitamos el de parar
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                startButton.setEnabled(true);
                                stopButton.setEnabled(false);
                            }
                        });
                    }
                });

                t.start();
            }
        });

        // añadimos un listener al boton de parar
        stopButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // se cambia el estado de los botones
                startButton.setEnabled(true);
                stopButton.setEnabled(false);

                // se pide al hilo que detenga su ejecución
                t.interrupt();
            }
        });

        pack(); // ajusta el tamaño de la ventana
        setVisible(true); // muestra la ventana
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Ej5_v2();
            }
        }); 
    }
}
