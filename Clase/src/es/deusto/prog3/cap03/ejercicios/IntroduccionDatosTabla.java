package es.deusto.prog3.cap03.ejercicios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * Programa una clase en Java que muestre unos de tatos en una tabla
 * y un botón añada una nueva entrada a los datos.
 * Haz que los nuevos datos se cojan de dos JTextField
 * Modifica el modelo para que:
        1- No se pueda modificar la columna nombre
        2- La columna edad solo acepte enteros
        3- No se acepten edades mayores de 105
 */

public class IntroduccionDatosTabla {
    private JFrame ventana;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField tfNombre;
    private JTextField tfEdad;

    public IntroduccionDatosTabla() {
    	
    	//TODO crear ventana
        

        // Datos iniciales para la tabla
        Object[] columnNames = {"Nombre", "Edad"};
        Object[][] data = {
            {"Alain", 28},
            {"Osane", 35},
            {"Ane", 20},
            {"Oihan", 42}
        };

        // TODO Crear el modelo de la tabla
        

        // TODO Crear la tabla
        

        // TODO Crear los componentes adicionales botón y campos de texto
        // (En la actualización de datos usa modelo.addRow)
        

        // TODO Crear un panel para colocar la tabla, y el resto de componentes
        // (Haz que el panel lleve un scroll para facilitar la lectura de la tabla)
        
        
        

        // TODO después de añadir los componentes en este punto puedes hacer visible la ventana
        
        
        //TODO modifica el modelo con los requerimientos indicados
        
			
		
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new IntroduccionDatosTabla();
            }
        });
    }
}


