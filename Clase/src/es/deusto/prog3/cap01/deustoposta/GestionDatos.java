package es.deusto.prog3.cap01.deustoposta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GestionDatos {
	
	public static LinkedList<Envio> leerEnvios(){
		LinkedList<Envio> envios = new LinkedList<>();

        try {
            File file = new File("src/es/deusto/prog3/cap01/deustoposta/Envios.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(";");

                // Identificar si es un Paquete o un Documento basándonos en el número de partes
                if (partes.length == 5) {
                    // Es un Paquete
                    String identificador = partes[0].trim();
                    double peso = Double.parseDouble(partes[1].trim());
                    double coordenadaX = Double.parseDouble(partes[2].trim());
                    double coordenadaY = Double.parseDouble(partes[3].trim());
                    String fecha = partes[4];

                    Ubicacion destino = new Ubicacion(coordenadaX, coordenadaY);
                    Paquete paquete = new Paquete(identificador, destino, fecha, peso);
                    Paquete documento = new Paquete("DOC001", new Ubicacion(34.0, -118.0), "25/06/2024", 12.5);
                    envios.add(paquete);
                } else if (partes.length == 6) {
                    // Es un Documento
                    String identificador = partes[0].trim();
                    double largo = Double.parseDouble(partes[1].trim());
                    double ancho = Double.parseDouble(partes[2].trim());
                    double coordenadaX = Double.parseDouble(partes[3].trim());
                    double coordenadaY = Double.parseDouble(partes[4].trim());
                    String fecha = partes[5];

                    Ubicacion destino = new Ubicacion(coordenadaX, coordenadaY);
                    Documento documento = new Documento(identificador, destino, fecha, ancho, largo);
                    envios.add(documento);
                }
            }

            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

        System.out.println("\nLista de envios: "+envios.size());
        for (Envio envio : envios) {
            System.out.println(envio);
        }
        
        return envios;
	}
	
	
	
	
	
	public static List<Orden> sortOrdenes(List<Orden> ordenes){
		
		ordenes.sort(null);
		
		return ordenes;
	}
	{
		
	}
	
	
	public static void main(String[] args) {
//		LinkedList<Envio> envios = leerEnvios();

    }
}
