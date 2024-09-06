package es.deusto.prog3.cap01.resuelto;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InterfazProperties extends JFrame {

    private JTextField nombreField;
    private JTextField edadField;
    private JTextField ciudadField;

    public InterfazProperties() {
        super("Configuración de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Crear componentes
        nombreField = new JTextField(20);
        edadField = new JTextField(20);
        ciudadField = new JTextField(20);
        JButton actualizarButton = new JButton("Actualizar");

        // Configurar el diseño
        setLayout(new GridLayout(4, 2));

        // Agregar componentes a la interfaz
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Edad:"));
        add(edadField);
        add(new JLabel("Ciudad:"));
        add(ciudadField);
        add(new JLabel("")); // Espacio en blanco
        add(actualizarButton);

        // Configurar el ActionListener para el botón
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPropiedades();
            }
        });
        
        cargarProperties();
    }
    
    private void cargarProperties() {
    	Properties properties = new Properties();
        FileInputStream inputStream = null;

        try {
            // Cargar las propiedades desde el archivo
            inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);

            // Obtener y mostrar propiedades
            String nombre = properties.getProperty("nombre");
            String edad = properties.getProperty("edad");
            String ciudad = properties.getProperty("ciudad");
            nombreField.setText(nombre);
            edadField.setText(edad);
            ciudadField.setText(ciudad);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    

    private void actualizarPropiedades() {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            // Cargar las propiedades existentes
            inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);

            // Actualizar las propiedades con los nuevos valores
            properties.setProperty("nombre", nombreField.getText());
            properties.setProperty("edad", edadField.getText());
            properties.setProperty("ciudad", ciudadField.getText());

            // Guardar las propiedades actualizadas en el archivo
            outputStream = new FileOutputStream("config.properties");
            properties.store(outputStream, null);

            JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	InterfazProperties interfaz = new InterfazProperties();
                interfaz.setVisible(true);
            }
        });
    }
}
