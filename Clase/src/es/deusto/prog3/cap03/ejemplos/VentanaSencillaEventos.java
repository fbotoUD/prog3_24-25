package es.deusto.prog3.cap03.ejemplos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class VentanaSencillaEventos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *   
	 *1- Crear clas clases necesarias que implementan ActionListener
	 *2- Añade los action listener a los botones correspondientes
	 *3- Haz que las clases sean internas y anónimas
	 *4- Prueba a crear mensajes con JOptionPane
	 *5- Modifica la fuente de los componentes Component.setFont(new Font("Arial", Font.PLAIN, 18))
	 *6- Modificar el programa para que sólo sea necesario un ActionListener.
	 *		Puedes usar ActionEnvent.getActionCommand()
	 */
	
	private JTextField tfMail;
	private JTextArea areaTexto;
	
	public VentanaSencillaEventos() {
		// Configuración de la ventana
    	setTitle("Envío de Correo Electrónico");
    	
    	setSize(400, 200);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	// Crear el panel
        JPanel panel = new JPanel();
        add(panel); // Añadir el panel a la ventana
        panel.setLayout(new BorderLayout());
        

        // Crear el campo de texto
        tfMail = new JTextField(20);
        JPanel panelMail = new JPanel();
        panelMail.setLayout(new GridLayout(2, 1));
        panelMail.add(new JLabel("Email:"));
        panelMail.add(tfMail);
        
        // Crear el área de texto
        areaTexto = new JTextArea(5, 15);       
        JScrollPane scrollPane = new JScrollPane(areaTexto); // Añadir scroll
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(2, 1));
        panelTexto.add(new JLabel("Escribe aquí tu mensaje:"));
        panelTexto.add(scrollPane);

        // Crear los botones
        JButton boton1 = new JButton("Enviar");
        JButton boton2 = new JButton("Salir");
        
        //Añadir una Action listener para cada botón
        //TODO
        
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
    	VentanaSencillaEventos ventana = new VentanaSencillaEventos();
        ventana.setVisible(true);
    }
}

//Crear las clases que implementan la interfaz ActionListener
//TODO
