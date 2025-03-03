package es.deusto.prog3.cap03.resueltos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import es.deusto.prog3.cap03.ejemplos.Utils;

/** Ventana de prueba con algunos elementos básicos con eventos de ratón
 * Visualización en ventana de los eventos
 */
@SuppressWarnings("serial")
public class VentanaEventosRatonCompleto extends JFrame {
	
	/** Prueba de la clase
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		VentanaEventosRatonCompleto v = new VentanaEventosRatonCompleto();
		v.setVisible( true );
	}

	// NO STATIC
	
	private JTextArea taTextoIzq;
	private JTextArea taTextoDer;
	public VentanaEventosRatonCompleto() {
		Utils.aumentarTamanoFuente(18);
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
		
		// Asociar gestores de eventos a componentes
		bAcabar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bBorrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taTextoIzq.setText( "" );
				taTextoDer.setText( "" );
			}
		} );
		pCentral.addMouseListener( new MouseListener() {
			// Atributo (invisible) guarda el valor de lFoto
			@Override
			public void mouseEntered(MouseEvent e) {
				sacarMensaje( "mouseEntered", e, taTextoIzq );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sacarMensaje( "mouseExited", e, taTextoIzq );
			}
			@Override
			public void mousePressed(MouseEvent e) {
				sacarMensaje( "mousePressed", e, taTextoIzq );
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				sacarMensaje( "mouseReleased", e, taTextoIzq );
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				sacarMensaje( "mouseClicked", e, taTextoIzq );
				// Comportamiento de ejemplo: mover el balón con click
				// Ojo: lFoto se está utilizando desde la copia invisible 
				// del atributo de ese objeto escuchador
				lFoto.setLocation( e.getX()-lFoto.getWidth()/2, e.getY()-lFoto.getHeight()/2 );
				// Se puede, pero solo si no cambia.
				// Es bastante recomendable estas variables usarlas como atributos
				// porque están fuera del ámbito de ejecución del escuchador 
				// (el constructor ya habrá acabado cuando el evento se ejecute,
				// sin embargo el atributo seguirá existiendo)
			}
		});
		
		//Con la clase abstracta MouseAdapter
//		pCentral.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				sacarMensaje( "mouseClicked", e, taTextoIzq );
//				lFoto.setLocation( e.getX()-lFoto.getWidth()/2, e.getY()-lFoto.getHeight()/2 );
//			}
//		});
		pCentral.addMouseMotionListener( new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				sacarMensaje( "mouseMoved", e, taTextoDer );
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				sacarMensaje( "mouseDragged", e, taTextoDer );
				// Comportamiento de ejemplo: mover el balón con drag
				lFoto.setLocation( e.getX()-lFoto.getWidth()/2, e.getY()-lFoto.getHeight()/2 );
			}
		});
		//Con MouseMotionAdapter
//		pCentral.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				sacarMensaje( "mouseDragged", e, taTextoDer );
//				lFoto.setLocation( e.getX()-lFoto.getWidth()/2, e.getY()-lFoto.getHeight()/2 );
//			}
//		});
		// Final
	}
	
	private void sacarMensaje(String nombre, MouseEvent e, JTextArea ta) {
		ta.append( nombre + ": " + e.getX() + "," + e.getY() + "\n" );
		ta.setSelectionStart( ta.getText().length() );
	}
	
}
