package es.deusto.prog3.cap03.superheroes.resuelto1;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class MyTableRenderer extends DefaultTableCellRenderer{
	
	private JTable table;
	
	public MyTableRenderer(JTable table) {
		this.table = table;		
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		Component comp =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (column ==1) {
			if (value.toString().equals("DC")) {
//				((JLabel)comp).setIcon(new ImageIcon("src/es/deusto/prog3/cap03/superheroes/sol1/DC.png"));
				/**
				 * el método getResource() busca el archivo de imagen dentro del classpath,
				 * que incluye los recursos que están empaquetados junto con las clases de la aplicación.
				 * Al usar simplemente "DC.png", se está indicando que el archivo de imagen está en el 
				 * mismo paquete que la clase desde la que se llama a getResource().
				 */
				((JLabel)comp).setIcon(new ImageIcon(getClass().getResource("DC.png")));
			}else {
//				((JLabel)comp).setIcon(new ImageIcon("src/es/deusto/prog3/cap03/superheroes/sol1/MARVEL.png"));
				((JLabel)comp).setIcon(new ImageIcon(getClass().getResource("MARVEL.png")));
			}
			((JLabel)comp).setToolTipText(value.toString());
			((JLabel)comp).setText("");
			
		}else {
			((JLabel)comp).setIcon(null);
		}
		
		if (row%2 == 0) {
			comp.setBackground(new Color(250,249,249));
		}else {
			comp.setBackground(new Color(190, 227, 219));
		}
		if (isSelected) {
			comp.setBackground(this.table.getSelectionBackground());
		}
		
		try {
			Integer.parseInt(value.toString());
			((JLabel)comp).setHorizontalAlignment(JLabel.CENTER);
		} catch (NumberFormatException e) {
			((JLabel)comp).setHorizontalAlignment(JLabel.LEFT);
		}
		
		return comp;
	}

}
