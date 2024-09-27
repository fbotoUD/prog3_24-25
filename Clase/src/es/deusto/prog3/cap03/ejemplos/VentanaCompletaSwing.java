package es.deusto.prog3.cap03.ejemplos;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Enumeration;

/** Ejemplo de ventana compleja en Swing sin eventos (compararla con VentanaAWT2)
 */
@SuppressWarnings("serial")  // Para evitar el warning de Serializable
public class VentanaCompletaSwing extends JFrame {

	JPanel panelNorte;
	JPanel panelCentral;
	JPanel panelSur;

	JPanel panelIzquierdo;
	JPanel panelDerecho;
	JPanel panelArriba;
	JPanel panelAbajo;

	JTextField nombre;
	JTextField direccion;
	JTextField telefono;

	JLabel etiqNombre;
	JLabel etiqDireccion;
	JLabel etiqTelefono;
	JLabel etiqCabecera;
	JLabel etiqOtrosDatos;
	JLabel etiqEstudios;

	JTextArea otrosDatos;

	ButtonGroup sexo;
	JCheckBox hombre;	
	JCheckBox mujer;
	JCheckBox coche;	
	JCheckBox viajar;
	JCheckBox mili;

	JList<String> estudios;

	JButton insertar;
	JButton salir;

	public VentanaCompletaSwing()
	{
		Utils.aumentarTamanoFuente(18);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelNorte= new JPanel();
		panelCentral = new JPanel();
		panelSur = new JPanel();
		panelIzquierdo = new JPanel();
		panelDerecho = new JPanel();
		panelArriba = new JPanel();
		panelAbajo = new JPanel();

		nombre = new JTextField(20);
		direccion = new JTextField(20);
		telefono = new JTextField(20);

		etiqCabecera = new JLabel("POR FAVOR, RELLENA LOS DATOS DE TU CURRICULUM");
		etiqNombre = new JLabel("Nombre");
		etiqDireccion = new JLabel("Dirección");
		etiqTelefono = new JLabel("Teléfono");
		etiqOtrosDatos = new JLabel("Otros Datos de Interés");
		etiqEstudios = new JLabel("Selecciona tus Estudios");

		otrosDatos = new JTextArea(10,25);

		sexo = new ButtonGroup();
		hombre = new JCheckBox("Hombre", true);
		mujer = new JCheckBox("Mujer", false);
		sexo.add(hombre);
		sexo.add(mujer);

		viajar = new JCheckBox("Disponibilidad para Viajar");
		coche = new JCheckBox("Posee Coche Propio");
		mili = new JCheckBox("Exento Servicio Militar");

		String[] losEstudios = {"Ingeniería Informática", 
					"Ingeniería Industrial",
					"Ingeniería Telecomunicaciones",
					"Arquitectura",
					"Filología Vasca",
					"Derecho",
					"Psicología",
					"Farmacia",
					"Medicina",
					"Hostelería"};
		estudios = new JList<String>(losEstudios);
		JScrollPane scrollLista =  new JScrollPane(estudios);
		insertar = new JButton("Insertar Datos");
		salir = new JButton("Salir");
	
		panelNorte.add(etiqCabecera);

		panelSur.add(insertar);					
		panelSur.add(salir);					

		panelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelIzquierdo.add(etiqNombre);
		panelIzquierdo.add(nombre);
		panelIzquierdo.add(etiqDireccion);
		panelIzquierdo.add(direccion);
		panelIzquierdo.add(etiqTelefono);
		panelIzquierdo.add(telefono);
		panelIzquierdo.add(etiqOtrosDatos);
		panelIzquierdo.add(otrosDatos);

		panelArriba.setLayout(new FlowLayout());
		panelArriba.add(etiqEstudios);
		panelArriba.add(scrollLista);

		panelAbajo.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAbajo.add(hombre);
		panelAbajo.add(mujer);
		panelAbajo.add(viajar);
		panelAbajo.add(coche);
		panelAbajo.add(mili);

		panelDerecho.setLayout(new GridLayout(2,1));
		panelDerecho.add(panelArriba);		
		panelDerecho.add(panelAbajo);

		panelCentral.setLayout(new GridLayout(1,2));
		panelCentral.add(panelIzquierdo);
		panelCentral.add(panelDerecho);

		this.getContentPane().add(panelNorte, "North");		
		this.getContentPane().add(panelSur, "South");		
		this.getContentPane().add(panelCentral, "Center");		
		this.setSize(750,725);
		this.setTitle("Currículum Vitae");
		this.setVisible(true);
	}

	public static void main(String[] args)
	{
		new VentanaCompletaSwing();
	}
}
