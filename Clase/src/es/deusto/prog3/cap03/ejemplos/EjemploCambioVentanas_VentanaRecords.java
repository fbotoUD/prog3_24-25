package es.deusto.prog3.cap03.ejemplos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Ejemplo de cambio entre ventanas (ver también EjemploCambioVentanas_VentanaPrincipal)
 * @author andoni.eguiluz at deusto.es
 */
@SuppressWarnings("serial")
public class EjemploCambioVentanas_VentanaRecords extends JFrame {
	JList<String> lRecords;
	JFrame ventanaAnterior;
	public EjemploCambioVentanas_VentanaRecords( JFrame v ) {
		ventanaAnterior = v;
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 400, 300 );
		JLabel lTitulo = new JLabel( "TOP TEN" );
		lTitulo.setHorizontalAlignment( JLabel.CENTER );
		lRecords = new JList<String>();
		JButton bVolver = new JButton( "Volver" );
		JPanel pBotonera = new JPanel();
		getContentPane().add( lTitulo, BorderLayout.NORTH );
		getContentPane().add( lRecords, BorderLayout.CENTER );
		getContentPane().add( pBotonera, BorderLayout.SOUTH );
		pBotonera.add( bVolver );
		// Vuelve a la ventana anterior al pulsar la x
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				ventanaAnterior.setVisible( true );
			}
		});
		// Vuelve a la ventana anterior al pulsar el botón de cierre
		bVolver.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();  // Me cierro definitivamente
				ventanaAnterior.setVisible( true ); // En este caso no haría falta porque al hacer dispose() se ejecuta también el evento windowClosed()
			}
		});
	}
	
}
