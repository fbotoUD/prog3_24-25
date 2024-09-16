package es.deusto.prog3.cap01.deustoposta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DeustoPosta {
	
	public static List<Orden> generarOrdenes(LinkedList<Envio> envios) {
		Map<String, List<Vehiculo>> vehiculos = Utilidades.crearVehiculos();
		List<Orden> ordenes = new ArrayList<>();
		Random random = new Random();
		Envio envio;
		Orden orden;
		int numOrden = 0;
		while(!envios.isEmpty()) {
			envio = envios.removeFirst();
			String id = "O"+numOrden;
			orden = new Orden(id,envio.getDestino(),envio);
			Dron dron = (Dron) vehiculos.get("Drones").get(random.nextInt(vehiculos.get("Drones").size()));
			if(!dron.asignarOrden(orden)) {
				Bicicleta bici = (Bicicleta) vehiculos.get("Bicis").get(random.nextInt(vehiculos.get("Bicis").size()));
				if(!bici.asignarOrden(orden)) {
					Coche coche = (Coche) vehiculos.get("Coches").get(random.nextInt(vehiculos.get("Coches").size()));
					if(!coche.asignarOrden(orden)) {
						System.err.println("Orden "+orden+" no asignada");
					}
				}
			}
			ordenes.add(orden);
			numOrden++;
		}
		
		return ordenes;
	}
	
	public static List<Orden> generarOrdenes1(LinkedList<Envio> envios) {
		Map<String, List<Vehiculo>> vehiculos = Utilidades.crearVehiculos();
		List<Orden> ordenes = new ArrayList<>();
		Random random = new Random();
		Envio envio;
		Orden orden;
		int numOrden = 0;
		while(!envios.isEmpty()) {
			envio = envios.removeFirst();
			String id = "O"+numOrden;
			orden = new Orden(id,envio.getDestino(),envio);
			
			if(orden.getCarga().getPeso() < 5) {
				Dron dron = (Dron) vehiculos.get("Drones").get(random.nextInt(vehiculos.get("Drones").size()));
				orden.setVehiculo(dron);
			}else if(orden.getCarga().getPeso() < 20) {
					Bicicleta bici = (Bicicleta) vehiculos.get("Bicis").get(random.nextInt(vehiculos.get("Bicis").size()));
					orden.setVehiculo(bici);
			}else if(orden.getCarga().getPeso() < 80) {
					Coche coche = (Coche) vehiculos.get("Coches").get(random.nextInt(vehiculos.get("Coches").size()));
					orden.setVehiculo(coche);
					
			}else System.err.println("Orden "+orden+" no asignada");
		
			ordenes.add(orden);
			numOrden++;
		}
		
		return ordenes;
	}
	
	public static void ordenesPorVehiculo(List<Orden> ordenes){
		Map<Vehiculo,List<Orden>> ordenesVehic = new HashMap<>();
		
		for (Orden orden: ordenes) {
			ordenesVehic.putIfAbsent(orden.getVehiculo(), new ArrayList<Orden>());
			ordenesVehic.get(orden.getVehiculo()).add(orden);
		}
		
		System.out.println("\n ordenes por vehículo");
		for (Vehiculo vehiculo: ordenesVehic.keySet()) {
			System.out.println("El vehiculo "+vehiculo+ " tiene "+ordenesVehic.get(vehiculo).size()+ " ordenes");
		}
	}
	
	public static double calcularTiempo(List<Orden> ordenes) {
		double tiempoTotal = 0.0;
		for(Orden orden: ordenes) {
			tiempoTotal+=orden.getVehiculo().estimarTiempo(orden.getDestino());
		}
		
		return tiempoTotal;
	}
	
	public static double calcularTiempo1(List<Orden> ordenes) {
		double tiempoTotal = 0.0;
		for(Orden orden: ordenes) {
			Vehiculo vehiculo = orden.getVehiculo();
			if (vehiculo instanceof Coche) {
				tiempoTotal+=(Utilidades.calcularDistancia(orden.getOrigen(), orden.getDestino())*10.0);
			}else if(vehiculo instanceof Bicicleta) {
				tiempoTotal+=(Utilidades.calcularDistancia(orden.getOrigen(), orden.getDestino())*1.8);
			}else if(vehiculo instanceof Dron) {
				tiempoTotal+=(Utilidades.calcularDistancia(orden.getOrigen(), orden.getDestino())*5.0);
			}
		}
		
		return tiempoTotal;
	}
	
	public static void main(String[] args) {
		LinkedList<Envio> envios = GestionDatos.leerEnvios();
//		LinkedList<Envio> envios = Utilidades.leerEnviosAux();
		System.out.println(envios);
//		List<Orden> ordenes = generarOrdenes(envios);
		List<Orden> ordenes = Utilidades.generarOrdenesAux(envios);
		
		System.out.println("El tiempo total en minutos es: "+calcularTiempo(ordenes));
		
		
      
//	      System.out.println(ordenes.size());
//	      for(Orden oden: ordenes) {
//	      	System.out.println(oden);
//	      }
//	      
//	      System.out.println("\nOrdenes ordenadas");
//	//      sortOrdenes(ordenes);
//	      for(Orden oden: ordenes) {
//	      	System.out.println(oden);
//	      }
      
//      ordenesPorVehiculo(ordenes);
	}

}
