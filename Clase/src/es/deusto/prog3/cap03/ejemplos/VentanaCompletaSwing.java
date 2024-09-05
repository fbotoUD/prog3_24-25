package es.deusto.prog3.cap03.ejemplos;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/** Ejemplo de ventana compleja en Swing sin eventos (compararla con VentanaAWT2)
 */
@SuppressWarnings("serial")  // Para evitar el warning de Serializable
public class VentanaCompletaSwing extends JFrame {

	JPanel JPanelNorte;
	JPanel JPanelCentral;
	JPanel JPanelSur;

	JPanel JPanelIzquierdo;
	JPanel JPanelDerecho;
	JPanel JPanelArriba;
	JPanel JPanelAbajo;

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
		JPanelNorte= new JPanel();
		JPanelCentral = new JPanel();
		JPanelSur = new JPanel();
		JPanelIzquierdo = new JPanel();
		JPanelDerecho = new JPanel();
		JPanelArriba = new JPanel();
		JPanelAbajo = new JPanel();

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
	
		JPanelNorte.add(etiqCabecera);

		JPanelSur.add(insertar);					
		JPanelSur.add(salir);					

		JPanelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanelIzquierdo.add(etiqNombre);
		JPanelIzquierdo.add(nombre);
		JPanelIzquierdo.add(etiqDireccion);
		JPanelIzquierdo.add(direccion);
		JPanelIzquierdo.add(etiqTelefono);
		JPanelIzquierdo.add(telefono);
		JPanelIzquierdo.add(etiqOtrosDatos);
		JPanelIzquierdo.add(otrosDatos);

		JPanelArriba.setLayout(new FlowLayout());
		JPanelArriba.add(etiqEstudios);
		JPanelArriba.add(scrollLista);

		JPanelAbajo.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanelAbajo.add(hombre);
		JPanelAbajo.add(mujer);
		JPanelAbajo.add(viajar);
		JPanelAbajo.add(coche);
		JPanelAbajo.add(mili);

		JPanelDerecho.setLayout(new GridLayout(2,1));
		JPanelDerecho.add(JPanelArriba);		
		JPanelDerecho.add(JPanelAbajo);

		JPanelCentral.setLayout(new GridLayout(1,2));
		JPanelCentral.add(JPanelIzquierdo);
		JPanelCentral.add(JPanelDerecho);

		this.getContentPane().add(JPanelNorte, "North");		
		this.getContentPane().add(JPanelSur, "South");		
		this.getContentPane().add(JPanelCentral, "Center");		
		this.setSize(450,425);
		this.setTitle("Currículum Vitae");
		this.setVisible(true);
	}

	public static void main(String[] args)
	{
		new VentanaCompletaSwing();
	}
}
