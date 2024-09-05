package es.deusto.prog3.cap03.ejemplos;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/** Ejemplo de cambio entre ventanas (ver también EjemploCambioVentanas_VentanaRecords)
 * @author andoni.eguiluz at deusto.es
 */
@SuppressWarnings("serial")
public class EjemploCambioVentanas_VentanaPrincipal extends JFrame {

	public static void main(String[] args) {
		EjemploCambioVentanas_VentanaPrincipal v = new EjemploCambioVentanas_VentanaPrincipal();
		v.setVisible( true );
	}

	public EjemploCambioVentanas_VentanaPrincipal() {
		// Configuración
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 600, 450 );
		setTitle( "Menú principal" );
		// Crear componentes y contenedores
		JButton bRecords = new JButton( "Records" );
		JButton bConfig = new JButton( "Configuración" );
		JButton bJugar = new JButton( "Jugar!" );
		// Configurar layouts y formato
		getContentPane().setLayout( new GridLayout( 3, 1 ) );
		// bRecords.setIcon( ... );
		// Asignar componentes a contenedores
		getContentPane().add( bRecords );
		getContentPane().add( bConfig );
		getContentPane().add( bJugar );
		// Gestión de eventos
		bConfig.addActionListener( new Boton1Action() ); // Escuchador con clase interna
		bJugar.addActionListener( // Escuchador con clase interna anónima
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println( "Pulsado Jugar (sin ventana asociada)");
					}
				}
			);
		bRecords.addActionListener( // Escuchador con clase interna anónima que lanza otra ventana
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println( "Pulsado records");
					// Creo otra ventana pasándole la mía (this) para que se visualice al "volver"
					EjemploCambioVentanas_VentanaRecords v = new EjemploCambioVentanas_VentanaRecords( EjemploCambioVentanas_VentanaPrincipal.this );
					v.setLocation( getLocation() ); // Con esto visualizo la nueva en la misma coordenada en la que yo estoy
					v.setSize( getSize() ); // Y con mi mismo tamaño
					v.setVisible( true );
					EjemploCambioVentanas_VentanaPrincipal.this.setVisible( false );
				}
			}
		);
		/*  Si quisiéramos un solo escuchador para todos los botones en lugar de uno para cada uno podría hacerse:
		ActionListener escBotones = new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				System.out.println( "Pulsado botón " + e.getSource() );
				if (e.getSource()==bConfig) {
					// ..
				} else {
					// ..
				}
			}
		};
		bConfig.addActionListener( escBotones );
		bJugar.addActionListener( escBotones );
		bRecords.addActionListener( escBotones );
		*/
	}
	
	private class Boton1Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println( "Pulsado Config (sin ventana asociada)");
		}
	}
	
}
