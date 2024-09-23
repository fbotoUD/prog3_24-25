package es.deusto.prog3.cap03.ejemplos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class VentanaSencillaLayouts extends JFrame{

	/**
	 *   
	 * Usando BorderLayout y GridLayout para las tres partes
	 */
	
	public VentanaSencillaLayouts() {
		// Configuración de la ventana
    	setTitle("Envío de Correo Electrónico");
    	setSize(400, 200);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	// Crear el panel
        JPanel panel = new JPanel();
        add(panel); // Añadir el panel a la ventana
        panel.setLayout(new BorderLayout());
        

        // Crear etiqueta mail
        JLabel lMail = new JLabel("Email:");
        // Crear el campo de texto
        JTextField tfMail = new JTextField(20);
        JPanel panelMail = new JPanel();
        panelMail.setLayout(new GridLayout(2, 1));
        panelMail.add(lMail);
        panelMail.add(tfMail);
        
        JLabel lMensaje = new JLabel("Escribe aquí tu mensaje:");
        // Crear el área de texto
        JTextArea areaTexto = new JTextArea(5, 15);       
        JScrollPane scrollPane = new JScrollPane(areaTexto); // Añadir scroll
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(2, 1));
        panelTexto.add(lMensaje);
        panelTexto.add(scrollPane);

        // Crear los botones
        JButton boton1 = new JButton("Enviar");
        JButton boton2 = new JButton("Salir");
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2));
        panelBotones.add(boton1);
        panelBotones.add(boton2);        

        // Añadir los componentes al panel
        panel.add(panelMail,BorderLayout.NORTH);
        panel.add(panelTexto,BorderLayout.CENTER);
        panel.add(panelBotones,BorderLayout.SOUTH);
	}

    public static void main(String[] args) {
    	VentanaSencillaLayouts ventana = new VentanaSencillaLayouts();
    	
        
        ventana.setVisible(true);
    }
}
