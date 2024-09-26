package es.deusto.prog3.cap03.ejemplos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EjemploLayouts extends JFrame {

    private static final long serialVersionUID = 1L;

	public EjemploLayouts() {
        // Definir el título
        setTitle("Ejemplo de Layouts en Swing");
        // Definir la operación por defecto al cerrar la ventana (terminar la aplicación)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Ajustar el tamaño de la ventana (ancho, alto en píxeles)
        setSize(800, 600);
        // Definir el tamaño mínimo de la ventana (ancho, alto en píxeles)
        setMinimumSize(new Dimension(500, 300));
        // Definir el tamaño máximo de la ventana (ancho, alto en píxeles)
        // Ajustar este valor de acuerdo a la resolución de la pantalla
        setMaximumSize(getToolkit().getScreenSize());         
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);		
		
        // Crear un panel principal con un GridLayout para organizar los otros paneles
        // El panel tiene 2 filas y 2 columnas, con 10 píxeles de separación horizontal y vertical
        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        
       
        /*
         * Panel con FlowLayout
         */
        JPanel flowLayoutPanel = new JPanel(new FlowLayout());
        // Añadir un borde con título al panel
        flowLayoutPanel.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
        // Añadir 4 botones al panel
		for (int i = 0; i < 4; i++) {
			flowLayoutPanel.add(new JButton("Botón " + (i + 1)));
		}

        /*
         *  Panel con BorderLayout
         */
        JPanel borderLayoutPanel = new JPanel(new BorderLayout());
        // Añadir un borde con título al panel
        borderLayoutPanel.setBorder(BorderFactory.createTitledBorder("BorderLayout"));
        // Añadir botones en las 5 posiciones del BorderLayout
        borderLayoutPanel.add(new JButton("Norte"), BorderLayout.NORTH);
        borderLayoutPanel.add(new JButton("Sur"), BorderLayout.SOUTH);
        borderLayoutPanel.add(new JButton("Este"), BorderLayout.EAST);
        borderLayoutPanel.add(new JButton("Oeste"), BorderLayout.WEST);
        borderLayoutPanel.add(new JButton("Centro"), BorderLayout.CENTER);

        /*
         *  Panel con GridLayout (2 filas, 2 columnas)
         */
        JPanel gridLayoutPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        // Añadir un borde con título al panel
        gridLayoutPanel.setBorder(BorderFactory.createTitledBorder("GridLayout"));
        // Añadir 4 botones al panel
		for (int i = 0; i < 4; i++) {
			gridLayoutPanel.add(new JButton("Botón " + (i + 1)));
		}
        
        /*
         * Panel con BoxLayout (Eje vertical)
         */
        JPanel boxLayoutPanel = new JPanel();
        // Se define el BoxLayout con orientación vertical
        boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel, BoxLayout.Y_AXIS));
        // Añadir un borde con título al panel
        boxLayoutPanel.setBorder(BorderFactory.createTitledBorder("BoxLayout (Vertical)"));
        // Añadir 4 botones al panel con separación entre ellos de 10 píxeles
		for (int i = 0; i < 4; i++) {
			boxLayoutPanel.add(new JButton("Botón " + (i + 1)));
			boxLayoutPanel.add(Box.createVerticalStrut(10)); // Separación entre botones
		}
        
        // Añadir los paneles al panel principal los paneles se distribuyen de
		// izquierda a derecha y de arriba a abajo
        mainPanel.add(flowLayoutPanel);
        mainPanel.add(borderLayoutPanel);
        mainPanel.add(gridLayoutPanel);
        mainPanel.add(boxLayoutPanel);

        // Añadir el panel principal al JFrame
        add(mainPanel);
	}

    public static void main(String[] args) {
        // Crear una instancia de EjemploLayouts y hacerla visible
        EjemploLayouts frame = new EjemploLayouts();
        frame.setVisible(true);
    }
}
