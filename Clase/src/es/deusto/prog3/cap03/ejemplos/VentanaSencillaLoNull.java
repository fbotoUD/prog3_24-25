package es.deusto.prog3.cap03.ejemplos;



import javax.swing.*;

public class VentanaSencillaLoNull {

	/**
	 *   
	 * Ubicando los componentes de forma absoluta en la pantalla
	 */

	public static void main(String[] args) {
        // Crear la ventana
        JFrame ventana = new JFrame("Envío de Correo Electrónico");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null); // Desactivar el layout manager para usar posiciones absolutas

        // Crear las etiquetas y los campos de texto
        JLabel lMail = new JLabel("Email:");
        lMail.setBounds(20, 20, 50, 20); // Posición y tamaño

        JTextField tfMail = new JTextField(20);
        tfMail.setBounds(80, 20, 200, 20); // Posición y tamaño

        JLabel lMensaje = new JLabel("Mensaje:");
        lMensaje.setBounds(20, 60, 60, 20); // Posición y tamaño

        JTextArea areaTexto = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(areaTexto); // Añadir scroll
        scrollPane.setBounds(80, 60, 200, 100); // Posición y tamaño

        // Crear los botones
        JButton boton1 = new JButton("Enviar");
        boton1.setBounds(80, 180, 80, 25); // Posición y tamaño

        JButton boton2 = new JButton("Salir");
        boton2.setBounds(200, 180, 80, 25); // Posición y tamaño

        // Añadir los componentes a la ventana
        ventana.add(lMail);
        ventana.add(tfMail);
        ventana.add(lMensaje);
        ventana.add(scrollPane);
        ventana.add(boton1);
        ventana.add(boton2);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
