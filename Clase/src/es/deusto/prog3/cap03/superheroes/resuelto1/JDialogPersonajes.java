package es.deusto.prog3.cap03.superheroes.resuelto1;

import java.awt.BorderLayout;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class JDialogPersonajes extends JDialog {

	private static final long serialVersionUID = 1L;

	private List<Personaje> personajes;
	private Comic comic;
	private JList<Personaje> listPersonajesTodos;
	private JScrollPane scrollPaneTodos;
	private JList<Personaje> listPersojanesComic;
	private JScrollPane scrollPaneComic;
	private JButton btnAdd = new JButton("Añadir >");
	private JButton btnRemove = new JButton("< Eliminar");
	
	public JDialogPersonajes(List<Personaje> personajes, Comic comic) {
		this.personajes = personajes;
		this.comic = comic;
		
		if (personajes != null) {
			//Se ordena la lista de personajes totales alfabéticamente
			Collections.sort(personajes, (p1, p2) -> {
				return p1.getNombre().compareToIgnoreCase(p2.getNombre());
			});
			
			//Se crea el modelo de datos para el JList de todo los personajes
			DefaultListModel<Personaje> personajesTodosModel = new DefaultListModel<>();
			this.personajes.forEach(p -> {
				personajesTodosModel.addElement(p);
			});
		
			this.listPersonajesTodos = new JList<Personaje>(personajesTodosModel);
			scrollPaneTodos = new JScrollPane(this.listPersonajesTodos);
			scrollPaneTodos.setBorder(new TitledBorder("Personajes existentes"));
		}
		
		if (comic != null) {
			//Se ordena la lista de personajes del comic actual alfabéticamente
			Collections.sort(comic.getPersonajes(), (p1, p2) -> {
				return p1.getNombre().compareToIgnoreCase(p2.getNombre());
			});
			
			//Se crea el modelo de datos para el JList de personajes del comic
			DefaultListModel<Personaje> personajesComicModel = new DefaultListModel<>();
			this.comic.getPersonajes().forEach(p -> {
				personajesComicModel.addElement(p);
			});
	
			this.listPersojanesComic = new JList<Personaje>(personajesComicModel);
			scrollPaneComic = new JScrollPane(this.listPersojanesComic);
			scrollPaneComic.setBorder(new TitledBorder("Personajes del comic '" + comic.getTitulo() + "'"));
		}
		
		JPanel panelCentral = new JPanel();
		panelCentral.add(btnAdd);
		panelCentral.add(btnRemove);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(scrollPaneTodos, BorderLayout.WEST);
		this.getContentPane().add(scrollPaneComic, BorderLayout.EAST);
		this.getContentPane().add(panelCentral, BorderLayout.CENTER);		
		
		this.setTitle("Modificar personajes del comic '" + comic.getTitulo() + "'");
		this.setSize(1200, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
}
