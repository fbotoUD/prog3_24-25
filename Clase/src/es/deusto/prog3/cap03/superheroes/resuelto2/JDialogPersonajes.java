package es.deusto.prog3.cap03.superheroes.resuelto2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

public class JDialogPersonajes extends JDialog {

	private static final long serialVersionUID = 1L;

	private List<Personaje> personajes;
	private Comic comic;
	private JList<Personaje> listPersonajesTodos;
	private DefaultListModel<Personaje> personajesTodosModel;
	private JList<Personaje> listPersojanesComic;
	private DefaultListModel<Personaje> personajesComicModel;
	private JButton btnAdd = new JButton("Añadir >");
	private JButton btnRemove = new JButton("< Eliminar");	
	
	public JDialogPersonajes(List<Personaje> personajes, Comic comic) {
		//Se fuerza la modalidad para bloquear la edición en la ventana principal.
		//this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		this.setModal(true);
		
		this.personajes = personajes;
		this.comic = comic;
				
		//Se crea el modelo de datos para el JList de todos los personajes
		personajesTodosModel = new DefaultListModel<>();
		this.listPersonajesTodos = new JList<Personaje>(personajesTodosModel);
		this.listPersonajesTodos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);			
		JScrollPane scrollPaneTodos = new JScrollPane(this.listPersonajesTodos);		
		scrollPaneTodos.setBorder(new TitledBorder("Personajes existentes"));
		scrollPaneTodos.setPreferredSize(new Dimension(380, 250));
		
		//Se crea el modelo de datos para el JList de personajes del comic
		personajesComicModel = new DefaultListModel<>();
		this.listPersojanesComic = new JList<Personaje>(personajesComicModel);
		this.listPersojanesComic.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneComic = new JScrollPane(this.listPersojanesComic);			
		scrollPaneComic.setBorder(new TitledBorder("Personajes del comic '" + comic.getTitulo() + "'"));
		scrollPaneComic.setPreferredSize(new Dimension(380, 250));
		
		//Se cargan las listas de personajes
		cargarListasPersonajes();
				
		//Se implementa el Listener para añadir personajes al comic
		btnAdd.addActionListener((e) -> {
			if (!listPersonajesTodos.isSelectionEmpty()) {
				Personaje pSeleccionado = listPersonajesTodos.getSelectedValue();
				personajesTodosModel.removeElement(pSeleccionado);
				personajesComicModel.addElement(pSeleccionado);
				
				personajes.remove(pSeleccionado);
				comic.getPersonajes().add(pSeleccionado);
				
				//Se cargan de nuevo las listas para ordenarlas alfabéticamente
				cargarListasPersonajes();
			}
		});
		
		JPanel panelCentral = new JPanel();
		panelCentral.add(btnAdd);
		panelCentral.add(btnRemove);
		
		//Se implementa el Listener para eliminar un personaje del comic
		btnRemove.addActionListener((e) -> {
			if (!listPersojanesComic.isSelectionEmpty()) {
				Personaje pSeleccionado = listPersojanesComic.getSelectedValue();
				personajesComicModel.removeElement(pSeleccionado);
				personajesTodosModel.addElement(pSeleccionado);
				
				comic.getPersonajes().remove(pSeleccionado);
				personajes.add(pSeleccionado);
				
				//Se cargan de nuevo las listas para ordenarlas alfabéticamente
				cargarListasPersonajes();
			}
		});
		
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(scrollPaneTodos);		
		this.getContentPane().add(panelCentral);
		this.getContentPane().add(scrollPaneComic);
		
		this.setTitle("Modificar personajes del comic '" + comic.getTitulo() + "'");
		this.setSize(1024, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void cargarListasPersonajes() {		
		//Se ordena la lista de personajes totales por nombre
		Collections.sort(personajes, (p1, p2) -> {
			return p1.getNombre().compareToIgnoreCase(p2.getNombre());
		});
		
		personajesTodosModel.clear();
		
		this.personajes.forEach(p -> {
			personajesTodosModel.addElement(p);
		});
		
		//Se ordena la lista de personajes del comic actual alfabéticamente
		Collections.sort(comic.getPersonajes(), (p1, p2) -> {
			return p1.getNombre().compareToIgnoreCase(p2.getNombre());
		});
		
		personajesComicModel.clear();
		
		this.comic.getPersonajes().forEach(p -> {
			personajesComicModel.addElement(p);
		});
	}
}
