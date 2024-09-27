package es.deusto.prog3.cap03.ejemplos;

import javax.swing.*;
import java.awt.*;

public class EjemploJList {

    public static void main(String[] args) {
    	Utils.aumentarTamanoFuente(18);
        // Crear el marco
        JFrame frame = new JFrame("Ejemplo Completo de JList");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Crear el modelo de datos: DefaultListModel para el JList
        //TODO

        // Crear el JList de dos maneras
        String[] personas = {"Ana, 25", "Juan, 32", "Luis, 23", "Marta, 44"};
        //TODO modificar para que se vean las personas en la lista
        JList<String> list = new JList<>(personas);
        //TODO Añadir el modelo de datos

        // Configurar el modo de selección (individual o múltiple)
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Personalizar el renderizado de los elementos setCellRenderer
        //TODO

        // Seleccionar un ítem por defecto usando setSelectedIndex()
        list.setSelectedIndex(0);

        // Crear un JScrollPane para la lista
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Crear una etiqueta para mostrar la selección
        JLabel label = new JLabel("Selecciona un elemento de la lista.");
        frame.add(label, BorderLayout.SOUTH);

        // Añadir un listener para manejar la selección de la lista 
        // addListSelectionListener(new ListSelectionListener())
        // Ten en cuenta que se pueden seleccionar varios getSelectedValuesList
        //TODO
        


        // Hacer visible el marco
        frame.setVisible(true);
    }
}

