package es.deusto.prog3.cap01.deustoposta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Utilidades {

    /**
     * Fuente: ChatGPT
     * Calcula la distancia euclidiana entre dos ubicaciones.
     *
     * @param destino1 La primera ubicación.
     * @param destino2 La segunda ubicación.
     * @return La distancia euclidea entre las dos ubicaciones.
     */
    public static double calcularDistancia(Ubicacion destino1, Ubicacion destino2) {
        double deltaX = destino2.getCoordenadaX() - destino1.getCoordenadaX();
        double deltaY = destino2.getCoordenadaY() - destino1.getCoordenadaY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
    
    /**
     * 
     * @return Mapa de vehículos para cada key una lista del tipo correspondiente.
     * 			Keys: Coches, Drones y Bicis
     */
    public static Map<String,List<Vehiculo>> crearVehiculos(){
		Map<String,List<Vehiculo>> vehiculos = new HashMap<>();
		int numCoches =4, numDrones=5, numBicis=8;
		
		List<Vehiculo> coches = new ArrayList<>();
		for (int i = 0; i< numCoches;i++) {
			String id = "C"+i;
			coches.add(new Coche(id, new Ubicacion(0.0,0.0)));
		}
		vehiculos.put("Coches",coches);
		List<Vehiculo> drones = new ArrayList<>();
		for (int i = 0; i< numDrones;i++) {
			String id = "D"+i;
			drones.add(new Dron(id, new Ubicacion(0.0,0.0)));
		}
		vehiculos.put("Drones",drones);
		List<Vehiculo> bicis = new ArrayList<>();
		for (int i = 0; i< numBicis;i++) {
			String id = "B"+i;
			bicis.add(new Bicicleta(id, new Ubicacion(0.0,0.0)));
		}	
		vehiculos.put("Bicis",bicis);
		
		return vehiculos;
	}
    
    /**
     * Función auxiliar que devuelve una lista de envios (Sustituye la Tarea 1)
     * @return lista de envios 
     */
    public static LinkedList<Envio> leerEnviosAux() {	
		LinkedList<Envio> envios = new LinkedList<>();
		envios.add(new Documento("DOC004", new Ubicacion(-33.9, 151.2), "02/07/2024", 12.0, 9.0));
        envios.add(new Paquete("PKG011", new Ubicacion(19.4, 99.1), "15/07/2024", 14.2));
        envios.add(new Documento("DOC015", new Ubicacion(37.8, -122.3), "24/07/2024", 9.0, 12.5));
        envios.add(new Paquete("PKG006", new Ubicacion(-23.5, -46.6), "05/07/2024", 3.1));
        envios.add(new Documento("DOC010", new Ubicacion(55.8, 37.6), "14/07/2024", 8.5, 11.0));
        envios.add(new Paquete("PKG001", new Ubicacion(34.0, -118.0), "25/06/2024", 12.5));
        envios.add(new Documento("DOC002", new Ubicacion(48.8, 2.3), "28/06/2024", 9.0, 12.0));
        envios.add(new Paquete("PKG003", new Ubicacion(35.7, 139.7), "29/06/2024", 20.0));
        envios.add(new Documento("DOC013", new Ubicacion(40.4, 49.6), "20/07/2024", 10.0, 13.0));
        envios.add(new Paquete("PKG002", new Ubicacion(51.5, -0.1), "27/06/2024", 5.75));
        envios.add(new Documento("DOC009", new Ubicacion(39.9, 116.4), "12/07/2024", 13.0, 9.5));
        envios.add(new Paquete("PKG008", new Ubicacion(41.9, 12.5), "09/07/2024", 9.5));
        envios.add(new Documento("DOC012", new Ubicacion(25.0, 121.5), "18/07/2024", 12.5, 9.5));
        envios.add(new Paquete("PKG009", new Ubicacion(28.6, 77.2), "11/07/2024", 16.4));
        envios.add(new Documento("DOC006", new Ubicacion(51.1, 10.4), "06/07/2024", 8.0, 11.5));
        envios.add(new Paquete("PKG014", new Ubicacion(31.6, -8.0), "21/07/2024", 5.9));
        envios.add(new Documento("DOC005", new Ubicacion(35.6, 139.6), "04/07/2024", 14.0, 10.0));
        envios.add(new Paquete("PKG012", new Ubicacion(-37.8, 144.9), "17/07/2024", 11.7));
        envios.add(new Documento("DOC007", new Ubicacion(34.0, -118.2), "08/07/2024", 11.0, 14.0));
        envios.add(new Paquete("PKG004", new Ubicacion(37.8, -122.4), "01/07/2024", 7.8));
        envios.add(new Documento("DOC003", new Ubicacion(55.7, 37.6), "30/06/2024", 10.0, 15.0));
        envios.add(new Paquete("PKG013", new Ubicacion(50.1, 8.7), "19/07/2024", 8.3));
        envios.add(new Documento("DOC008", new Ubicacion(-34.6, -58.4), "10/07/2024", 10.5, 13.5));
        envios.add(new Paquete("PKG010", new Ubicacion(-22.9, -43.2), "13/07/2024", 6.2));
        envios.add(new Documento("DOC001", new Ubicacion(40.7, -74.0), "26/06/2024", 8.5, 11.0));
        envios.add(new Paquete("PKG016", new Ubicacion(55.0, -1.6), "25/07/2024", 12.3));
        envios.add(new Documento("DOC011", new Ubicacion(34.7, 135.5), "16/07/2024", 9.0, 12.0));
        envios.add(new Paquete("PKG015", new Ubicacion(60.2, 24.7), "23/07/2024", 17.8));
        envios.add(new Documento("DOC014", new Ubicacion(23.7, 90.4), "22/07/2024", 11.5, 9.0));
        envios.add(new Paquete("PKG005", new Ubicacion(52.5, 13.4), "03/07/2024", 15.3));
        envios.add(new Documento("DOC010", new Ubicacion(55.8, 37.6), "14/07/2024", 8.5, 11.0));
        envios.add(new Paquete("PKG002", new Ubicacion(51.5, -0.1), "27/06/2024", 5.75));
        envios.add(new Documento("DOC015", new Ubicacion(37.8, -122.3), "24/07/2024", 9.0, 12.5));
        envios.add(new Paquete("PKG006", new Ubicacion(-23.5, -46.6), "05/07/2024", 3.1));
        envios.add(new Documento("DOC003", new Ubicacion(55.7, 37.6), "30/06/2024", 10.0, 15.0));
        envios.add(new Paquete("PKG009", new Ubicacion(28.6, 77.2), "11/07/2024", 16.4));
        envios.add(new Documento("DOC002", new Ubicacion(48.8, 2.3), "28/06/2024", 9.0, 12.0));
        envios.add(new Paquete("PKG011", new Ubicacion(19.4, 99.1), "15/07/2024", 14.2));
        envios.add(new Documento("DOC007", new Ubicacion(34.0, -118.2), "08/07/2024", 11.0, 14.0));
        envios.add(new Paquete("PKG008", new Ubicacion(41.9, 12.5), "09/07/2024", 9.5));
        envios.add(new Documento("DOC004", new Ubicacion(-33.9, 151.2), "02/07/2024", 12.0, 9.0));
        envios.add(new Paquete("PKG016", new Ubicacion(55.0, -1.6), "25/07/2024", 12.3));
        envios.add(new Documento("DOC012", new Ubicacion(25.0, 121.5), "18/07/2024", 12.5, 9.5));
        envios.add(new Paquete("PKG014", new Ubicacion(31.6, -8.0), "21/07/2024", 5.9));
        envios.add(new Documento("DOC001", new Ubicacion(40.7, -74.0), "26/06/2024", 8.5, 11.0));
        envios.add(new Paquete("PKG003", new Ubicacion(35.7, 139.7), "29/06/2024", 20.0));
        envios.add(new Documento("DOC013", new Ubicacion(40.4, 49.6), "20/07/2024", 10.0, 13.0));
        envios.add(new Paquete("PKG010", new Ubicacion(-22.9, -43.2), "13/07/2024", 6.2));
        envios.add(new Documento("DOC006", new Ubicacion(51.1, 10.4), "06/07/2024", 8.0, 11.5));
        envios.add(new Paquete("PKG012", new Ubicacion(-37.8, 144.9), "17/07/2024", 11.7));
        envios.add(new Documento("DOC005", new Ubicacion(35.6, 139.6), "04/07/2024", 14.0, 10.0));
        envios.add(new Paquete("PKG013", new Ubicacion(50.1, 8.7), "19/07/2024", 8.3));
        envios.add(new Documento("DOC014", new Ubicacion(23.7, 90.4), "22/07/2024", 11.5, 9.0));
        envios.add(new Paquete("PKG007", new Ubicacion(40.8, -73.9), "07/07/2024", 22.0));
        envios.add(new Documento("DOC008", new Ubicacion(-34.6, -58.4), "10/07/2024", 10.5, 13.5));
        envios.add(new Paquete("PKG015", new Ubicacion(60.2, 24.7), "23/07/2024", 17.8));
        envios.add(new Documento("DOC009", new Ubicacion(39.9, 116.4), "12/07/2024", 13.0, 9.5));
        envios.add(new Paquete("PKG005", new Ubicacion(52.5, 13.4), "03/07/2024", 15.3));
        
        return envios;
	}
    
    
    public static List<Orden> generarOrdenesAux(LinkedList<Envio> envios) {
    	int numCoches =4, numDrones=5, numBicis=8;
    	List<Orden> ordenes = new ArrayList<>();
    	List<Vehiculo> vehiculos = new ArrayList<>();
		for (int i = 0; i< numCoches;i++) {
			String id = "C"+i;
			vehiculos.add(new Coche(id, new Ubicacion(0.0,0.0)));
		}
		
		for (int i = 0; i< numDrones;i++) {
			String id = "D"+i;
			vehiculos.add(new Dron(id, new Ubicacion(0.0,0.0)));
		}
		for (int i = 0; i< numBicis;i++) {
			String id = "B"+i;
			vehiculos.add(new Bicicleta(id, new Ubicacion(0.0,0.0)));
		}
		for(Envio envio: envios) {
			String id = ""+alt(100000);
			ordenes.add(new Orden(id,envio.getDestino(),envio,vehiculos.get(alt(vehiculos.size())).getUbicacionActual(),vehiculos.get(alt(vehiculos.size()))));
		}
		return ordenes;
    }
    private static int alt(int max) {
    	long seed = System.currentTimeMillis();
    	long a = 1664525;    // Multiplicador
        long c = 1013904223; // Incremento
        long m = (long) Math.pow(2, 32);
        seed = (a * seed + c) % m;
        int nxi = (int) (seed & 0x7FFFFFFF);
        return   0 + (nxi % (max - 0 + 1 -1));
    }
}

