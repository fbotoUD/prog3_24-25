package es.deusto.prog3.cap03.resueltos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Programa una clase en Java que muestre unos de tatos en una tabla
 * y un botón añada una nueva entrada a los datos.
 * Haz que los nuevos datos se cojan de dos JTextField
 * Modifica el modelo para que:
 * 1- No se pueda modificar la columna nombre
 * 2- La columna edad solo acepte enteros
 * 3- No se acepten edades mayores de 105
 * 
 * Modifica el render y el editor añadiendo un JSpiner para modificar la edad
 */

public class IntroduccionDatosTabla {
    private JFrame ventana;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField tfNombre;
    private JTextField tfEdad;

    public IntroduccionDatosTabla() {
        ventana = new JFrame("Tabla de Datos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Datos iniciales para la tabla
        Object[] columnNames = {"Nombre", "Edad"};
        Object[][] data = {
            {"Alain", 28},
            {"Osane", 35},
            {"Ane", 20},
            {"Oihan", 42}
        };

        // Crear el modelo de la tabla
        modelo = new DefaultTableModel(data, columnNames);

        // Crear la tabla
        tabla = new JTable(modelo);

        // Crear JTextField para ingresar datos
        tfNombre = new JTextField(10);
        tfEdad = new JTextField(10);

        // Crear un botón de actualización
        JButton updateButton = new JButton("Actualizar Datos");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener datos del JTextField
                String name = tfNombre.getText();
                int age;
                try {
                    age = Integer.parseInt(tfEdad.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana, "Edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Agregar los datos ingresados a la tabla
                Object[] newRow = {name, age};
                modelo.addRow(newRow);

                // Limpiar los campos de entrada
                tfNombre.setText("");
                tfEdad.setText("");
            }
        });

        // Crear un panel para colocar la tabla, JTextField y botón
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(tfNombre);
        inputPanel.add(new JLabel("Edad:"));
        inputPanel.add(tfEdad);
        inputPanel.add(updateButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        // Agregar el panel al marco
        ventana.add(panel);

        ventana.pack();
        ventana.setVisible(true);
        
        modelo = new DefaultTableModel(columnNames,0) {

			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println("isCellEditable"+row+","+column);
				if (column == 0) return false;
				else return super.isCellEditable(row, column);
				
			}

			@Override
			public Object getValueAt(int row, int column) {
				Object val = super.getValueAt(row, column);
				System.out.println("getValueAt "+row+","+column+"<-"+ val);
				return val;
			}

			@Override
			public void setValueAt(Object aValue, int row, int column) {
				System.out.println("setValueAt "+row+","+column +"->" +aValue);
//				if (aValue.getClass().equals(String.class)) return;
				try {
					int valor = Integer.parseInt(aValue+"");
					if (valor <=105) {
						super.setValueAt(aValue, row, column);
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} // Hereda de DefaultTableModel
			
		};
		modelo.setDataVector(data, columnNames);
		tabla.setModel(modelo);
		
		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// TODO Auto-generated method stub
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if(column == 0) {
					((JLabel)comp).setBackground(Color.GREEN);
				}
				if(column ==1) {
					JSpinner spinner = new JSpinner();
					spinner.setValue(value);
					comp = spinner;
				}
				return comp;
			}
			
		});
		
		tabla.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()) {
			
			int valueAnt;
			JTextField tf;
			Component comp;

			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
				comp =  super.getTableCellEditorComponent(table, value, isSelected, row, column);
				
				tf = (JTextField) comp;
				
				if (column == 1) {
					tf = null;
					comp = new JSpinner();
					((JSpinner)comp).setValue(value);
					//Me falta que salga el dato al principio
					((JSpinner)comp).addChangeListener(new ChangeListener() {
						
						@Override
						public void stateChanged(ChangeEvent e) {
							valueAnt = (int) ((JSpinner)comp).getValue();
							
						}
					});
				}
				
				return comp;
			}
			
			@Override
			public Object getCellEditorValue() {
				if (tf != null) {
					return tf;
				}
				else {
					return valueAnt;
				}
			}
			
		});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new IntroduccionDatosTabla();
            }
        });
    }
}


