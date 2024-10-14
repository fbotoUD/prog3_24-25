package es.deusto.prog3.cap03.ejemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Ventana de prueba con algunos elementos básicos con eventos de teclado
 * Gestión de validación con foco en cuadro de texto
 */
@SuppressWarnings("serial")
public class VentanaEventosTecladoYFoco extends JFrame {
	
	/** Prueba de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaEventosTecladoYFoco v = new VentanaEventosTecladoYFoco();
		v.setVisible( true );  
		// Swing lanza un gestor de eventos
		// Swing lanza un NUEVO HILO de ejecución
	}
	
	// NO STATIC

	private JLabel lMensaje;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	public VentanaEventosTecladoYFoco() {
		// Formato de la ventana
		this.setTitle( "Mi ventana" );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 640, 250 );
		// setLocation( 3000, 100 );  // Cambio de posición en pantalla

		// Crear componentes
		lMensaje = new JLabel( " " );
		JLabel lNombre = new JLabel( "Nombre:" );
		tfNombre = new JTextField( "", 20 );
		JLabel lApellidos = new JLabel( "Apellidos:" );
		tfApellidos = new JTextField( "", 50 );
		JButton bBorrar = new JButton( "Borrar texto" );
		JButton bAceptar = new JButton( "Aceptar" );
		
		// Crear contenedores
		JPanel pIzquierdo = new JPanel();
		JPanel pInferior = new JPanel();
		JPanel pIzq1 = new JPanel( new FlowLayout( FlowLayout.LEFT ));  // FlowLayout alineado a izquierda (por defecto es center)
		JPanel pIzq2 = new JPanel( new FlowLayout( FlowLayout.LEFT ));  // FlowLayout alineado a izquierda (por defecto es center)

		// Asignar formatos (layouts)
		pIzquierdo.setLayout( new GridLayout( 2, 1 ) );
		bAceptar.setFocusable( false );

		// Asignar componentes a contenedores
		getContentPane().add( lMensaje, BorderLayout.NORTH );
		pIzq1.add( lNombre );  
		pIzq1.add( tfNombre );
		pIzq2.add( lApellidos );
		pIzq2.add( tfApellidos );
		pIzquierdo.add( pIzq1 );
		pIzquierdo.add( pIzq2 );
		getContentPane().add( pIzquierdo, BorderLayout.WEST );
		pInferior.add( bAceptar );
		pInferior.add( bBorrar );
		getContentPane().add( pInferior, BorderLayout.SOUTH );
		
		// Eventos
		KeyListener klQuitaNumeros = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println( "Typed  " + e );
				if (e.getKeyChar()>='0' && e.getKeyChar()<='9') {
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println( "Released " + e );
			}
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println( "Pressed " + e );
			}
		};
		tfNombre.addKeyListener(klQuitaNumeros);
		tfApellidos.addKeyListener(klQuitaNumeros);
		tfNombre.addKeyListener( new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_CONTROL && tfNombre.getText().length()>0) {
					// Si se pulsa control se pone la primera letra en mayúscula
					tfNombre.setText( (""+tfNombre.getText().charAt(0)).toUpperCase() + tfNombre.getText().substring(1) );
				}
			}
		});
		FocusListener fl = new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println( "Pierdo foco" );
				char letraIni = tfNombre.getText().charAt(0);
				char letraFin = tfNombre.getText().charAt( tfNombre.getText().length()-1 );
				if (letraIni<'A' || letraIni>'Z' || letraFin==' ') {
					lMensaje.setText( "Error en validación de nombre" );
					tfNombre.setBackground( Color.RED );
					tfNombre.requestFocus();
				} else {
					tfNombre.setBackground( Color.WHITE );
					lMensaje.setText( " " );
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println( "Recibo foco" );
				lMensaje.setText( "Introduce nombre correcto que inicie en mayúscula y no acabe en espacio" );
			}
		};
		tfNombre.addFocusListener( fl );
	}
	
}
