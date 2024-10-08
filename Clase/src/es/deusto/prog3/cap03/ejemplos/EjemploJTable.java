package es.deusto.prog3.cap03.ejemplos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class EjemploJTable {
	
	private static JFrame vent;
	private static JTable tabla;
	
	private static DefaultTableModel modelo;

	public static void main(String[] args) {
		
		Utils.aumentarTamanoFuente(25);
		
		vent = new JFrame();
		vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		vent.setSize(700,600);
//		vent.setLocation(2000, 0);
		
		//Hay componentes que se asocia un modelo de datos JTable es uno de ellos
		//Patrón de diseño en el que por una parte tengo la gestión de los datos y por otro la visualización
		modelo = new DefaultTableModel(new Object[] {"Name","Cod"},0);
				
		//Tabla en la ventana
		tabla = new JTable(modelo);
//		vent.getContentPane().add(tabla,BorderLayout.CENTER);
		
		
		//Es interesante poner scroll
		JScrollPane scroll = new JScrollPane(tabla);
		vent.getContentPane().add(scroll,BorderLayout.CENTER);
		
		//Se puede crear el JScrollPane directamente
//		vent.getContentPane().add(new JScrollPane(tabla), BorderLayout.CENTER);
//		
		//Añadir datos
		modelo.addRow(new Object[] {"Miren",70});
		modelo.addRow(new Object[] {"Mara",500});
		modelo.addRow(new Object[] {"Oihan",250});
		
		
		//Anchura columnas (es visual está en la tabla, no en el modelo)
		tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
		tabla.getColumnModel().getColumn(0).setMaxWidth(300);
		tabla.getColumnModel().getColumn(0).setMinWidth(100);
		tabla.setRowHeight(30);
		
		/**
		 * Modificar Modelos de datos
		 */
		// Crear un modelo de datos particular para esta tabla
		//TODO
		modelo = new DefaultTableModel(new Object[] {"Name","Cod"},0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==0) return false;
				return super.isCellEditable(row, column);
			}
			
			@Override
			public Object getValueAt(int row, int column) {
				System.out.println("getValueAt: "+row+","+column);
				return super.getValueAt(row, column);
			}
			@Override
			public void setValueAt(Object aValue, int row, int column) {
				// TODO Auto-generated method stub
				if(column == 0) {
					super.setValueAt(aValue, row, column);
				}else {
					try {
						int valor = Integer.parseInt(aValue+"");
						if(valor <=255) {
							super.setValueAt(aValue, row, column);
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		tabla.setModel(modelo);
		modelo.addRow(new Object[] {"Miren",70});
		modelo.addRow(new Object[] {"Mara",200});
		modelo.addRow(new Object[] {"Oihan",250});
		
		/**
		 * Modificar el renderer de la tabla (DefaultTableCellRenderer)
		 */
		//Puedes cambiar los colores (setBackground)
		//Poner un JSlider en la columna 1
		//TODO
		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component compo = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				System.out.println("Soy un JLabel?"+(compo instanceof JLabel));
				//Añadido
				if(column==0) {
					compo.setBackground(Color.GRAY);
				}else {
					compo.setBackground(Color.WHITE);					
				}
				return compo;
			}			
		});
		
		
		/**
		 * Modificar el editor para poder actuar con el JSlider(DefaultCellEditor)
		 */
		//Es necesario añadir un escuchador al JSlider
		//TODO		
				
		
		vent.setVisible(true);
		
		
	}
	
	
	
	

}
