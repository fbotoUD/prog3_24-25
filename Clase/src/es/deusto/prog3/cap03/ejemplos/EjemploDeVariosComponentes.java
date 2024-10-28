package es.deusto.prog3.cap03.ejemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** Clase ejemplo de varios componentes de Swing:
 * Border
 * Checkbox
 * ButtonGroup y RadioButton
 * JSpinner
 * JSlider
 * setPreferredSize
 * Menús
 * @author andoni.eguiluz at deusto.es
 */
@SuppressWarnings("serial")
public class EjemploDeVariosComponentes extends JFrame {
	/** Método principal
	 * @param args	Ignorado
	 */
	public static void main(String[] args) {
		EjemploDeVariosComponentes f = new EjemploDeVariosComponentes();
		f.setVisible( true );
		// Espera 3 segundos y progresa el progressbar
		//TODO later
	}

	private ButtonGroup bgRadios;  // Grupo de los botones de radio
	private JRadioButton rbSalado;
	private JRadioButton rbDulce;
	private JRadioButton rbAmargo;
	private JRadioButton rbNinguno;
	private JCheckBox cbNogusta;
	private JCheckBox cbDeporte;
	private JTextArea taEscribeAqui;
	private JScrollPane spCentral;
	private JSpinner spinValor;
	private JTextField tfValor;
	private JSlider slValor;
	
	public EjemploDeVariosComponentes() {
		Utils.aumentarTamanoFuente(20);
		// 1.- Inicialización de ventana
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 600 );
		setLocationRelativeTo( null );  // Centra la posición en el escritorio
		setTitle( "Ejemplo de varios componentes de Swing" );
		
		// 2.- Inicialización de componentes y contenedores
		// Paneles y layouts
		JPanel pBotonera = new JPanel();
		pBotonera.setLayout( new BoxLayout( pBotonera, BoxLayout.Y_AXIS ) );
		JPanel pInferior = new JPanel();  // FlowLayout por defecto
		// Botones de radio y buttongroup
		rbSalado = new JRadioButton( "Salado..." );
		rbDulce = new JRadioButton( "Dulce..." );
		rbAmargo = new JRadioButton( "Amargo" );
		rbNinguno = new JRadioButton( "Ninguno de los anteriores" );
		bgRadios = new ButtonGroup();  // Observa que si quitas el buttongroup los 4 radios funcionan independientes y se pueden pulsar los 4 (como si fueran checkboxes)
		bgRadios.add( rbSalado ); bgRadios.add( rbDulce ); bgRadios.add( rbAmargo ); bgRadios.add( rbNinguno );
		// Checkboxes
		cbNogusta = new JCheckBox( "NO me gusta mucho comer" );
		cbDeporte = new JCheckBox( "Me gusta el deporte" );
		// Resto componentes
		taEscribeAqui = new JTextArea( 15, 40 ); // Filas y columnas aunque si el layout manda da igual el tamaño
		spCentral = new JScrollPane( taEscribeAqui );  // El scrollpane "contiene" al textarea para darle barras de scroll
		slValor = new JSlider( 0, 100 );  // Valores mínimo y máximo del slider
		tfValor = new JTextField( "0", 5 );
		spinValor = new JSpinner();
 		
		// 3.- Formato y configuración
		// Ejemplo de border
		pBotonera.setBorder( BorderFactory.createDashedBorder( Color.red, 10.0f, 5.0f ) );
		spinValor.setPreferredSize( new Dimension( 60, 20 ) );  // Forzar la dimensión preferida del spinner (vale con cualquier componente)
		taEscribeAqui.append( "JTextArea - texto multilínea\n" );
		taEscribeAqui.append( "Tiene scroll que se ve cuando la línea es más ancha que lo que la ventana permite\n" );
		taEscribeAqui.append( "O las líneas más altas\n" );
		taEscribeAqui.append( "\nObserva que la progressbar desde el botón no funciona ¿por qué?\n" );
		
		// 4.- Asociación de componentes a contenedores
		pBotonera.add( new JLabel( "Eres más de ..." ) );
		pBotonera.add( rbSalado );
		pBotonera.add( rbDulce );
		pBotonera.add( rbAmargo );
		pBotonera.add( rbNinguno );
		pBotonera.add( cbNogusta );
		pBotonera.add( cbDeporte );
		pInferior.add( spinValor );
		pInferior.add( slValor );
		pInferior.add( tfValor );
		
		// El buttongroup no hay que añadirlo, no es visual, solo funciona su lógica (no se pueden activar 2 botones del mismo buttongroup)
		getContentPane().add( pBotonera, BorderLayout.WEST );
		getContentPane().add( spCentral, BorderLayout.CENTER );
		getContentPane().add( pInferior, BorderLayout.SOUTH );
		
		// 5.- Menús 
		JMenuBar barraMenu = new JMenuBar(); // Barra de menú
		JMenu menu1 = new JMenu( "Acciones" ); // Primer menú desplegable
		JMenuItem menuItem1 = new JMenuItem( "Reset radios" );   // Opciones
		JMenuItem menuItem2 = new JMenuItem( "Reset progreso" ); 
		menu1.add( menuItem1 ); menu1.add( menuItem2 );
		barraMenu.add( menu1 ); // Añadir a barra
		JMenu menu2 = new JMenu( "Otras" ); // Segundo menú desplegable
		JMenuItem menuItem3 = new JMenuItem( "Salir" );   // Opciones
		menu2.add( menuItem3 );
		barraMenu.add( menu2 ); // Añadir a barra
		setJMenuBar( barraMenu );
		
		/**
		 * Eventos
		 */
		
		//Añadir ChangeListener al spinValor
		//TODO Al cambiar el spinner actualizamos el cuadro de texto
		//Al seleccionar el final del texto, se ve este punto en pantalla aunque el scroll se salga 
		spinValor.addChangeListener( new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) { 
				// Al cambiar el spinner actualizamos el cuadro de texto
				tfValor.setText( spinValor.getValue() + "" );
				taEscribeAqui.append( "Actuación sobre el spinner\n" );
				taEscribeAqui.setSelectionStart( taEscribeAqui.getText().length() );  // Al seleccionar el final del texto, se ve este punto en pantalla aunque el scroll se salga 
			}
		});
		slValor.addChangeListener( new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// Al cambiar el slider actualizamos el cuadro de texto
				tfValor.setText( slValor.getValue() + "" );
				taEscribeAqui.append( "Actuación sobre el slider\n" );
				taEscribeAqui.setSelectionStart( taEscribeAqui.getText().length() );  // Al seleccionar el final del texto, se ve este punto en pantalla aunque el scroll se salga 
			}
		});
		menuItem1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bgRadios.clearSelection();
			}
		});

		menuItem3.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// Es lo mismo que EjemploDeVariosComponentes.this.dispose();
			}
		});
	}
}
