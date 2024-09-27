package es.deusto.prog3.cap03.resueltos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.deusto.prog3.cap03.ejemplos.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Clase que representa un elemento personalizado para la lista
class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sobrescribimos el método toString() para que el texto de cada ítem sea el nombre
    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

// Clase personalizada para renderizar las celdas de la lista
class PersonaRenderer extends JLabel implements ListCellRenderer<Persona> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Persona> list, Persona value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setOpaque(true);
        return this;
    }
}

public class EjemploJListCompleto {

    public static void main(String[] args) {
    	Utils.aumentarTamanoFuente(18);
        // Crear el marco
        JFrame frame = new JFrame("Ejemplo Completo de JList");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Crear el modelo de datos: DefaultListModel
        DefaultListModel<Persona> model = new DefaultListModel<>();
        model.addElement(new Persona("Ana", 25));
        model.addElement(new Persona("Juan", 30));
        model.addElement(new Persona("Luis", 35));
        model.addElement(new Persona("Marta", 40));

        // Crear el JList con el modelo
        JList<Persona> list = new JList<>(model);

        // Configurar el modo de selección (individual o múltiple)
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Personalizar el renderizado de los elementos
        list.setCellRenderer(new PersonaRenderer());

        // Seleccionar un ítem por defecto usando setSelectedIndex()
        list.setSelectedIndex(0);

        // Crear un JScrollPane para la lista
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Crear una etiqueta para mostrar la selección
        JLabel label = new JLabel("Selecciona un elemento de la lista.");
        frame.add(label, BorderLayout.SOUTH);

        // Añadir un listener para manejar la selección de la lista
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { //Evitar eventos duplicados
                    List<Persona> selectedValuesList = list.getSelectedValuesList();
                    if (!selectedValuesList.isEmpty()) {
                        StringBuilder selectedText = new StringBuilder("Seleccionaste: ");
                        for (Persona p : selectedValuesList) {
                            selectedText.append(p.toString()).append(", ");
                        }
                        label.setText(selectedText.toString());
                    } else {
                        label.setText("No hay elementos seleccionados.");
                    }
                }
            }
        });

        // Hacer visible el marco
        frame.setVisible(true);
    }
}

