package es.deusto.prog3.cap03.ejemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Ventana de prueba con algunos elementos básicos con eventos de ratón
 * Visualización en ventana de los eventos
 */
@SuppressWarnings("serial")
public class VentanaEventosRaton extends JFrame {
	
	/** Prueba de la clase
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		VentanaEventosRaton v = new VentanaEventosRaton();
		v.setVisible( true );
	}

	// NO STATIC
	
	private JTextArea taTextoIzq;
	private JTextArea taTextoDer;
	public VentanaEventosRaton() {
		Utils.aumentarTamanoFuente(20);
		// Formato de la ventana
		this.setTitle( "Mi ventana" );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 480 );
		// setLocation( 3000, 100 );  // Cambiar la posición en pantalla
		
		// Crear componentes
		taTextoIzq = new JTextArea( "Eventos de MouseListener:\n", 10, 40 );
		taTextoDer = new JTextArea( "Eventos de MouseMotionListener:\n", 10, 40 );
		JLabel lFoto = new JLabel( new ImageIcon("src/es/deusto/prog3/resources/sonic.png") );
		JButton bBorrar = new JButton( "Borrar texto" );
		JButton bAcabar = new JButton( "Acabar" );
		
		// Crear contenedores
		JPanel pInferior = new JPanel();
		JPanel pCentral = new JPanel();
		JPanel pSuperior = new JPanel();
		
		// Asignar formatos (layouts)
		pSuperior.setLayout( new GridLayout( 1, 2 ) );
		pCentral.setLayout( null );  // Nulo para mover la imagen libremente
		pCentral.setBackground( Color.CYAN );
		
		// Asignar componentes a contenedores
		pSuperior.add( new JScrollPane(taTextoIzq) );
		pSuperior.add( new JScrollPane(taTextoDer) );
		getContentPane().add( pSuperior, BorderLayout.NORTH );
		pCentral.add( lFoto );
		getContentPane().add( pCentral, BorderLayout.CENTER );
		lFoto.setLocation( 0, 0 );  // La foto en la esquina del panel central
		// Tamaño de la foto: OJO - si no se indica la foto no se ve 
		// (por defecto el tamaño es 0 y el layout de este panel es nulo)
		lFoto.setSize( 50, 50 );
		pInferior.add( bAcabar );
		pInferior.add( bBorrar );
		getContentPane().add( pInferior, BorderLayout.SOUTH );
		
		/**
		 *  Asociar gestores de eventos a componentes
		 */
		
		//Implementar botón acabar "dispose()"
		//TODO
		
		
		//Borrar los paneles de texto setText()
		//TODO
		
		//Añadir MouseListener a pCentral
		//TODO sacarMensaje cuando entra en el panel
		//TODO sacarMensaje cuando sale del panel
		//TODO sacarMensaje al presionar
		//TODO sacarMensaje al soltar
		//TODO sacarMensaje y mover el Sonic al hacer click
		
		//Añadir MouseMotionListener a pCentral
		//TODO sacarMensaje cuando hay movimiento de ratón
		//TODO sacarMensaje y mover el Sonic al hacer Drag del ratón
		
	}
	
	private void sacarMensaje(String nombre, MouseEvent e, JTextArea ta) {
		ta.append( nombre + ": " + e.getX() + "," + e.getY() + "\n" );
		ta.setSelectionStart( ta.getText().length() );
	}
}