package es.deusto.prog3.cap05.ejemplos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class EjemploProperties {

    public static void main(String[] args) {
        // Ejemplo de escritura de propiedades en un archivo
        escribirPropiedades();

        // Ejemplo de lectura de propiedades desde un archivo
        leerPropiedades();
    }

    private static void escribirPropiedades() {
        Properties properties = new Properties();
        FileOutputStream outputStream = null;

        try {
            // Establecer propiedades
            properties.setProperty("nombre", "Albert");
            properties.setProperty("edad", "144");
            properties.setProperty("ciudad", "Princeton");

            // Escribir las propiedades en un archivo
            outputStream = new FileOutputStream("config.properties");
            properties.store(outputStream, "Configuración de Ejemplo");
            properties.storeToXML(new PrintStream( "config.xml" ), "Ejemplo propiedades" );

            System.out.println("Propiedades escritas correctamente en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void leerPropiedades() {
        Properties properties = new Properties();
        FileInputStream inputStream = null;

        try {
            // Cargar las propiedades desde el archivo
            properties.load(new FileInputStream("config.properties"));

            // Obtener y mostrar propiedades desde .properties 
            String nombre = properties.getProperty("nombre");
            String edad = properties.getProperty("edad");
            String ciudad = properties.getProperty("ciudad");
            System.out.println("Lectura de las propiedades desde .properties");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Ciudad: " + ciudad);
	        
            properties.loadFromXML( new FileInputStream( "config.xml" ) );
	        // Obtener y mostrar propiedades desde .properties 
            nombre = properties.getProperty("nombre");
            edad = properties.getProperty("edad");
            ciudad = properties.getProperty("ciudad");
            System.out.println("Lectura de las propiedades desde .xml");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Ciudad: " + ciudad);
            
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
}

