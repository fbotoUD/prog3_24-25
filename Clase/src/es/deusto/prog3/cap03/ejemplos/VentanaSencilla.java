package es.deusto.prog3.cap03.ejemplos;

import javax.swing.*;

public class VentanaSencilla {

	/**
	 *   
	 * JPanel tiene su propio layout manager (administrador de diseño) que por defecto es un FlowLayout, 
	 * lo que significa que los componentes se organizan en línea y se ajustan según el tamaño de su contenido y del panel.
	 */

    public static void main(String[] args) {
    	JFrame ventana = new JFrame();
    	// Configuración de la ventana
    	ventana.setTitle("Envío de Correo Electrónico");
    	ventana.setSize(200, 200);
	ventana.setMaximumSize(new Dimension(500,500));
    	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	// Crear el panel
        JPanel panel = new JPanel();
        ventana.add(panel); // Añadir el panel a la ventana
        

        // Crear las etiquetas
        JLabel lMail = new JLabel("Email:");
        JLabel lMensaje = new JLabel("Escribe aquí tu mensaje:");

        // Crear el campo de texto
        JTextField tfMail = new JTextField(20);

        // Crear el área de texto
        JTextArea areaTexto = new JTextArea(5, 15);
        JScrollPane scrollPane = new JScrollPane(areaTexto); // Añadir scroll

        // Crear los botones
        JButton boton1 = new JButton("Enviar");
        JButton boton2 = new JButton("Salir");

        // Añadir los componentes al panel
        panel.add(lMail);
        panel.add(tfMail);
        panel.add(lMensaje);
        panel.add(scrollPane);
        panel.add(boton1);
        panel.add(boton2);
        
        ventana.setVisible(true);
    }
}
