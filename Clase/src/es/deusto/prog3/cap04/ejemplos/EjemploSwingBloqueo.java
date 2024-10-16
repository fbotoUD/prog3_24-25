package es.deusto.prog3.cap04.ejemplos;

import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/* En este ejemplo se lanza una tarea larga (contar)
* como parte de un escuchador. Esto bloquea el thread de Swing y
* la UI deja de responder correctamente al usuario.
* ¡Atención! Esto es un ejemplo de cómo NO hacer las cosas.
**/
public class EjemploSwingBloqueo extends JFrame {
    private static final long serialVersionUID = 1L;

    public EjemploSwingBloqueo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Ejemplo de bloqueo de Swing");
        setSize(320, 240);
        setTitle("Bloqueo de Swing");

        JButton button = new JButton("Lanzar tarea");
        JPanel panel = new JPanel();
        panel.add(button);

        add(panel);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // este método realiza una tarea muy larga
                // lo que bloquea la interfaz gráfica y deja
                // de responder a eventos.

                for (int i = 0; i < 10000; i++) {
                    System.out.println(i);
                }
            }
        });

        pack(); // ajusta el tamaño de la ventana
        setVisible(true); // muestra la ventana
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new EjemploSwingBloqueo();
            }
        }); 
    }
}
