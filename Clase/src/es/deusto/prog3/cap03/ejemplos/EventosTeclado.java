package es.deusto.prog3.cap03.ejemplos;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class EventosTeclado extends JFrame {

    private JLabel label;

    public EventosTeclado() {
        setTitle("Ejemplo de eventos de teclado");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        label = new JLabel("Presiona una tecla...", SwingConstants.CENTER);
        add(label);

        // Añadir un KeyAdapter para manejar eventos de teclado
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Mostrar la tecla presionada en el JLabel
                label.setText("Tecla presionada: " + KeyEvent.getKeyText(e.getKeyCode()));
             // Consumir el evento si es la tecla ESC
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    label.setText("Presiona una tecla...");
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_ALT) {
                	label.setText("Tecla presionada ALT");
                    e.consume();
                }
                if (e.getKeyCode() ==KeyEvent.VK_C && e.isControlDown()) {
                	label.setText("Combinación CONTROL+C");
                	e.consume();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Mostrar la tecla liberada en el JLabel
//                label.setText("Tecla liberada: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new EventosTeclado());
    }
}
