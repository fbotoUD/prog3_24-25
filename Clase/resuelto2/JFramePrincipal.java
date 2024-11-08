package es.deusto.prog3.cap03.superheroes.resuelto2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import es.deusto.prog3.cap03.superheroes.resuelto2.Personaje.Editorial;


public class JFramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
		
	private List<Comic> comics;
	private int mouseRowPersonajes = -1;
	
	private JTable tablaComics;
	private DefaultTableModel modeloDatosComics;
	private JTable tablaPersonajes;
	private DefaultTableModel modeloDatosPersonajes;
	private JScrollPane scrollPanePersonajes;
	private JTextField txtFiltro;
	
	public JFramePrincipal(List<Comic> comics) {
		//Asignamos la lista de comics a la varaible local
		this.comics = comics;

		//Se inicializan las tablas y sus modelos de datos
		this.initTables();
		//Se cargan los comics en la tabla de comics
		this.loadComics();
		
		//La tabla de comics se inserta en un panel con scroll
		JScrollPane scrollPaneComics = new JScrollPane(this.tablaComics);
		scrollPaneComics.setBorder(new TitledBorder("Comics"));
		this.tablaComics.setFillsViewportHeight(true);
		
		//La tabla de personajes se inserta en otro panel con scroll
		this.scrollPanePersonajes = new JScrollPane(this.tablaPersonajes);
		this.scrollPanePersonajes.setBorder(new TitledBorder("Personajes"));		
		this.tablaPersonajes.setFillsViewportHeight(true);
				
		this.txtFiltro = new JTextField(20);
		//Se añade un listener para detectar cambios en el campo de texto
		this.txtFiltro.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filtrarComics();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filtrarComics();
			}

			@Override
			public void changedUpdate(DocumentEvent e) { }			
		});		
		
		JPanel panelFiltro = new JPanel();
		panelFiltro.add(new JLabel("Filtro por título: "));
		panelFiltro.add(txtFiltro);
		
		JPanel panelComics = new JPanel();
		panelComics.setLayout(new BorderLayout());
		panelComics.add(BorderLayout.CENTER, scrollPaneComics);
		panelComics.add(BorderLayout.NORTH, panelFiltro);
		
		//Listener para los eventos de teclado
		KeyListener myKeyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }

			@Override
			public void keyPressed(KeyEvent e) {
				// CTRL + C - Creación de un nuevo comic
				if (e.getKeyCode() == KeyEvent.VK_C && e.isControlDown()) {
					//Se inicializa el JComboBox para seleccionar la editorial
					JComboBox<Editorial> jcomoEditorial = new JComboBox<>(Editorial.values());				
					jcomoEditorial.setRenderer((list, value, index, isSelected, cellHasFocus) -> {
						JLabel result = new JLabel();
						
						Editorial editorial = (Editorial) value;
						
						switch (editorial) { 
							case MARVEL:
								result.setIcon(new ImageIcon("src/es/deusto/prog3/cap03/superheroes/resuelto2/MARVEL.png"));
								break;
							case DC:
								result.setIcon(new ImageIcon("src/es/deusto/prog3/cap03/superheroes/resuelto2/DC.png"));
								break;
							default:
						}
						
						if (isSelected) {
							result.setBackground(list.getSelectionBackground());
							result.setForeground(list.getSelectionForeground());
						}
						
						return result;
					});
					
					//Se define el JTextField para el título
					JTextField txtTitulo = new JTextField(30);
					
					//En este array de JComponent se definen los componentes que se 
					//muestran en el cuadro de diálogo.
					JComponent[] inputs = new JComponent[] {
						new JLabel("Editorial: "),
						jcomoEditorial,
						new JLabel("Título: "),
						txtTitulo
					};	
					
					
					int result = JOptionPane.showConfirmDialog(null, inputs, 
							"Crear un nuevo comic", 
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE);
					
					if (result == JOptionPane.OK_OPTION) {
						if (!txtTitulo.getText().isEmpty()) {
							Comic comic = new Comic(comics.size()+1, (Editorial) jcomoEditorial.getSelectedItem(), txtTitulo.getText());
							comics.add(comic);
							//Se borra el filtro
							txtFiltro.setText("");
							//Se cargan de nuevo los comics
							loadComics();
						} else {
							JOptionPane.showMessageDialog(null, "El título no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
						}						
					}
				} else if (tablaComics.getSelectedRow() != -1 && e.getKeyCode() == KeyEvent.VK_P && e.isControlDown()) {					
					Comic comic = comics.get((int) tablaComics.getValueAt(tablaComics.getSelectedRow(), 0) - 1);
					List<Personaje> personajes = new ArrayList<>();
					
					//Se recorren todos los comics
					comics.forEach(c -> {
						//Se recorren todos los personajes del comic
						c.getPersonajes().forEach(p -> {
							//Se añaden a la lista de personajes sin repetición
							if (!personajes.contains(p) && !comic.getPersonajes().contains(p)) {
								personajes.add(p);
							}
						});		
					});					
					
					//Se crea el cuadro de diálogo de modificación de personajes.
					new JDialogPersonajes(personajes, comic);
					
					//Se borra el filtro
					txtFiltro.setText("");
					//Se cargan de nuevo los comics para actualizar el número de personajes
					loadComics();
										
					//Se carga de nuevo la tabla de personajes
					loadPersonajes(comic);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) { }
		};
		
		//Se define el listener para detectar cuando el ratón sale de la tabla de personajes
		this.tablaPersonajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				//Se resetea la fila/columna sobre la que está el ratón				
				mouseRowPersonajes = -1;
			}
		});
		
		//Se define el listener para controlar el movimiento del ratón sobre la tabla de personajes
		this.tablaPersonajes.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//Se actualiza la fila/columna sobre la que está el ratón
				mouseRowPersonajes = tablaPersonajes.rowAtPoint(e.getPoint());
				
				//Se provoca el redibujado de la tabla
				tablaPersonajes.repaint();
			}			
		});
				
		this.tablaPersonajes.addKeyListener(myKeyListener);
		this.tablaComics.addKeyListener(myKeyListener);
		this.txtFiltro.addKeyListener(myKeyListener);
		
		this.tablaPersonajes.addKeyListener(myKeyListener);
		this.tablaComics.addKeyListener(myKeyListener);
		
		//El Layout del panel principal es un matriz con 2 filas y 1 columna
		this.getContentPane().setLayout(new GridLayout(2, 1));
		this.getContentPane().add(panelComics);
		this.getContentPane().add(this.scrollPanePersonajes);
		
		this.setTitle("Ventana principal de Comics");		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);		
	}
	
	private void initTables() {
		//Cabecera del modelo de datos
		Vector<String> cabeceraComics = new Vector<String>(Arrays.asList( "ID", "EDITORIAL", "TÍTULO", "Personajes"));
		//Se crea el modelo de datos para la tabla de comics sólo con la cabecera
		this.modeloDatosComics = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraComics);
		//Se crea la tabla de comics con el modelo de datos
		this.tablaComics = new JTable(this.modeloDatosComics) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 3) {
					return false;
	         	} else {
	         		return true;
	         	}
	         }
		};
		
		//Se define un CellRenderer para las celdas de las dos tabla usando una expresión lambda
		TableCellRenderer cellRenderer = (table, value, isSelected, hasFocus, row, column) -> {
			JLabel result = new JLabel(value.toString());
			
			//Se definen para el label los colores de texto y fondo por defecto de la tabla
			result.setBackground(table.getBackground());
			result.setForeground(table.getForeground());
						
			//Si el valor es de tipo Editorial: se renderiza con la imagen centrada
			if (value instanceof Editorial) {
				Editorial e = (Editorial) value;
				
				result.setText("");		
				result.setToolTipText(e.toString());
				result.setHorizontalAlignment(JLabel.CENTER);
				
				switch (e) { 
					case MARVEL:
						result.setIcon(new ImageIcon("src/es/deusto/prog3/cap03/superheroes/sol2/MARVEL.png"));
						break;
					case DC:
						result.setIcon(new ImageIcon("src/es/deusto/prog3/cap03/superheroes/sol2/DC.png"));
						break;
					default:
				}
			//Si el valor es numérico se renderiza centrado
			} else if (value instanceof Number) {
				result.setHorizontalAlignment(JLabel.CENTER);
			} else {
				//Si el valor es texto pero representa un número se renderiza centrado
				try {
					Integer.parseInt(value.toString());
					result.setHorizontalAlignment(JLabel.CENTER);				
				} catch(Exception ex) {
					result.setText(value.toString());
					
					if (table.equals(tablaComics)) {
						String filter = txtFiltro.getText();
						String txtValue = value.toString();
						StringBuffer txtHtml = new StringBuffer();						
						String txtResaltado;
						
						if (isSelected) {
							txtResaltado = "<strong style='background-color:white; color: red;'>" + filter + "</strong>";
						} else {
							txtResaltado = "<strong style='background-color:yellow; color: blue;'>" + filter + "</strong>";
						}
												
						txtHtml.append("<html>");
						txtHtml.append(txtValue.substring(0, txtValue.indexOf(filter)));
						txtHtml.append(txtResaltado);
						txtHtml.append(txtValue.substring(txtValue.indexOf(filter) + filter.length(), txtValue.length()));
						txtHtml.append("</html");
						
						result.setText(txtHtml.toString());
					}
				}		
			}
			
			//La filas pares e impares se renderizan de colores diferentes de la tabla de comics			
			if (table.equals(tablaComics)) {
				if (row % 2 == 0) {
					result.setBackground(new Color(250, 249, 249));
				} else {
					result.setBackground(new Color(190, 227, 219));
				}
			}			
			
			//Si la celda está seleccionada se renderiza con el color de selección por defecto
			if (isSelected || (table.equals(tablaPersonajes) && row == mouseRowPersonajes)) {
				result.setBackground(table.getSelectionBackground());
				result.setForeground(table.getSelectionForeground());			
			}			
			
			result.setOpaque(true);
			
			return result;
		};
		
		//Se define un CellRenderer para las cabeceras de las dos tabla usando una expresión lambda
		TableCellRenderer headerRenderer = (table, value, isSelected, hasFocus, row, column) -> {
			JLabel result = new JLabel(value.toString());			
			result.setHorizontalAlignment(JLabel.CENTER);
			
			switch (value.toString()) {
				case "TÍTULO":
				case "NOMBRE":
				case "EMAIL":
					result.setHorizontalAlignment(JLabel.LEFT);
			}
			
			result.setBackground(table.getBackground());
			result.setForeground(table.getForeground());
			
			result.setOpaque(true);
			
			return result;
		};
		
		//Se crea un CellEditor a partir de un JComboBox()
		JComboBox<Editorial> jComboEditorial = new JComboBox<>(Editorial.values());		
		DefaultCellEditor editorialEditor = new DefaultCellEditor(jComboEditorial);
		
		//Se define la altura de las filas de la tabla de comics
		this.tablaComics.setRowHeight(26);
		
		//Se deshabilita la reordenación de columnas
		this.tablaComics.getTableHeader().setReorderingAllowed(false);
		//Se deshabilita el redimensionado de las columna
		this.tablaComics.getTableHeader().setResizingAllowed(false);		

		//Se definen criterios de ordenación por defecto para cada columna
		this.tablaComics.setAutoCreateRowSorter(true);
		
		//Se establecen los renderers al la cabecera y el contenido
		this.tablaComics.getTableHeader().setDefaultRenderer(headerRenderer);		
		this.tablaComics.setDefaultRenderer(Object.class, cellRenderer);
		
		//Se establece el editor específico para la Editorial		
		this.tablaComics.getColumnModel().getColumn(1).setCellEditor(editorialEditor);
		
		//Se define la anchura de la columna Título
		this.tablaComics.getColumnModel().getColumn(2).setPreferredWidth(400);
		
		//Se modifica el modelo de selección de la tabla para que se pueda selecciona únicamente una fila
		this.tablaComics.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Se define el comportamiento el evento de selección de una fila de la tabla
		this.tablaComics.getSelectionModel().addListSelectionListener(e -> {
			//Se obtiene el ID del comic de la fila seleccionada si es distinta de -1
			if (tablaComics.getSelectedRow() != -1) {
				this.loadPersonajes(this.comics.get((int) tablaComics.getValueAt(tablaComics.getSelectedRow(), 0) - 1));
			}
		});
		
		//Cabecera del modelo de datos
		Vector<String> cabeceraPersonajes = new Vector<String>(Arrays.asList( "ID", "EDITORIAL", "NOMBRE", "EMAIL"));
		//Se crea el modelo de datos para la tabla de comics sólo con la cabecera
		this.modeloDatosPersonajes = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraPersonajes);
		//Se crea la tabla de personajes con el modelo de datos
		this.tablaPersonajes = new JTable(this.modeloDatosPersonajes) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
				
		this.tablaPersonajes.getTableHeader().setDefaultRenderer(headerRenderer);		
		this.tablaPersonajes.setDefaultRenderer(Object.class, cellRenderer);
		this.tablaPersonajes.setRowHeight(26);
		this.tablaPersonajes.getColumnModel().getColumn(2).setPreferredWidth(200);
		this.tablaPersonajes.getColumnModel().getColumn(3).setPreferredWidth(200);
	}
	
	private void filtrarComics() {
		//Se vacían las dos tablas
		this.modeloDatosComics.setRowCount(0);
		this.modeloDatosPersonajes.setRowCount(0);
		
		//Se añaden a la tabla sólo los comics que contengan el texto del filtro
		this.comics.forEach(c -> {
			if (c.getTitulo().contains(this.txtFiltro.getText())) {
				this.modeloDatosComics.addRow(
					new Object[] {c.getId(), c.getEditorial(), c.getTitulo(), c.getPersonajes().size()} );
			}
		});
	}
	
	private void loadComics() {
		//Se borran los datos del modelo de datos
		this.modeloDatosComics.setRowCount(0);
		//Se añaden los comics uno a uno al modelo de datos
		this.comics.forEach(c -> this.modeloDatosComics.addRow(
				new Object[] {c.getId(), c.getEditorial(), c.getTitulo(), c.getPersonajes().size()} )
		);
	}
	
	private void loadPersonajes(Comic comic) {
		//Se borran los datos del modelo de datos
		this.modeloDatosPersonajes.setRowCount(0);

		//Se añaden los personajes uno a uno al modelo de datos
		comic.getPersonajes().forEach(p -> this.modeloDatosPersonajes.addRow(
				new Object[] {p.getId(), p.getEditorial(), p.getNombre(), p.getEmail()} )
		);
		
		//Se modifica el texto del bode de la lista de personajes 
		this.scrollPanePersonajes.setBorder(new TitledBorder(String.format("Personajes del comic '%s' [%d]",
				comic.getTitulo(), comic.getPersonajes().size())));
	}
}