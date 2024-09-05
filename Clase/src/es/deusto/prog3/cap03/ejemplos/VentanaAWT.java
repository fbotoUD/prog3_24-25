package es.deusto.prog3.cap03.ejemplos;

import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.Label;
import java.awt.List;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/** Ejemplo de ventana completa AWT (modo antiguo previo a Swing)
 	(compararla con VentanaCompletaSwing)
  */
@SuppressWarnings("serial")
public class VentanaAWT extends Frame {
	Panel panelNorte;
	Panel panelCentral;
	Panel panelSur;

	Panel panelIzquierdo;
	Panel panelDerecho;
	Panel panelArriba;
	Panel panelAbajo;

	TextField nombre;
	TextField direccion;
	TextField telefono;

	Label etiqNombre;
	Label etiqDireccion;
	Label etiqTelefono;
	Label etiqCabecera;
	Label etiqOtrosDatos;
	Label etiqEstudios;

	TextArea otrosDatos;

	CheckboxGroup sexo;
	Checkbox hombre;	
	Checkbox mujer;
	Checkbox coche;	
	Checkbox viajar;
	Checkbox mili;

	List estudios;

	Button insertar;
	Button salir;
	
	public VentanaAWT()
	{
		panelNorte= new Panel();
		panelCentral = new Panel();
		panelSur = new Panel();
		panelIzquierdo = new Panel();
		panelDerecho = new Panel();
		panelArriba = new Panel();
		panelAbajo = new Panel();

		nombre = new TextField(20);
		direccion = new TextField(20);
		telefono = new TextField(20);

		etiqCabecera = new Label("POR FAVOR, RELLENA LOS DATOS DE TU CURRICULUM");
		etiqNombre = new Label("Nombre");
		etiqDireccion = new Label("Dirección");
		etiqTelefono = new Label("Teléfono");
		etiqOtrosDatos = new Label("Otros Datos de Interés");
		etiqEstudios = new Label("Selecciona tus Estudios");
		otrosDatos = new TextArea(6,25);
		sexo = new CheckboxGroup();
		hombre = new Checkbox("Hombre", sexo, true);
		mujer = new Checkbox("Mujer", sexo, false);
		viajar = new Checkbox("Disponibilidad para Viajar");
		coche = new Checkbox("Posee Coche Propio");
		mili = new Checkbox("Exento Servicio Militar");
		estudios = new List(8,true);
		estudios.add("Ingeniería Informática");
		estudios.add("Ingeniería Industrial");
		estudios.add("Ingeniería Telecomunicaciones");
		estudios.add("Arquitectura");
		estudios.add("Filología Vasca");
		estudios.add("Derecho");
		estudios.add("Psicología");
		estudios.add("Farmacia");
		estudios.add("Medicina");
		estudios.add("Hostelería");
		insertar = new Button("Insertar Datos");
		salir = new Button("Salir");

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
		panelArriba.add(estudios);
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
		this.add(panelNorte, "North");		
		this.add(panelSur, "South");		
		this.add(panelCentral, "Center");		
		this.setSize(450,425);
		this.setTitle("Currículum Vitae");
	}

	public static void main(String[] args)
	{
		(new VentanaAWT()).setVisible(true);
	}
}
