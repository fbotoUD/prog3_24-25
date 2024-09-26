package es.deusto.prog3.cap01.ecosistemas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Ecosistema> ecosistemas = new ArrayList<Ecosistema>();
		ArrayList<Organismo> organismos = new ArrayList<Organismo>();
		
		// TAREA 1
		cargarOrganismosCSV(organismos);	
		System.out.println(organismos);
		
		//TAREA 2
//		ecosistemas = generarEcosistemas(organismos);
		//Extra
		ecosistemas = generarEcosistemasViables(organismos);
		System.out.println(ecosistemas.get(0));
		
		//Tarea3
		System.out.println("################\nEdades medias ecosistema 0: "+ecosistemas.get(0).calcularEdadesMaxMedias());

		
		//Tarea 4
		System.out.println("##############\nAgrupación de ecosistemas por clima");
		HashMap<Clima,HashSet<Ecosistema>> gruposClima = agrupaPorClima(ecosistemas);
		for (Clima clima: gruposClima.keySet()) {
			System.out.println("En clima "+clima+" hay "+gruposClima.get(clima).size()+" ecosistemas");
		}
		
		//Tarea5
		System.out.println("##############\nOdenación climas por edad media organismos");
		ecosistemas.sort(new Comparator<Ecosistema>() {
			@Override
			public int compare(Ecosistema o1, Ecosistema o2) {
				return 	Double.compare(o1.calcularEdadMaxMedia(), o2.calcularEdadMaxMedia());	
			}
			
		});
		
		System.out.println("Ecosistema con edad Max Media menor: "+ecosistemas.get(0).calcularEdadMaxMedia()+" "+ecosistemas.get(0));
		System.out.println("Ecosistema con edad Max Media mayor: "+ecosistemas.get(ecosistemas.size()-1).calcularEdadMaxMedia()+" "+ecosistemas.get(0));
		
		
		//Tarea 7
		for(Ecosistema ecosistema: ecosistemas) {
			ecosistema.simularAnyo();
		}		
		
		//Tarea 8
		Ecosistema longevo = ecosistemaMasLongevo(ecosistemas);
		System.out.println("El ecossitema más longevo es: "+longevo);
		
		//Tarea 9
		guardarEcosistemas(ecosistemas,"ecosistemas.dat");
		
		//Tarea 10
		longevo.guardarCSV();
		
		
	}

	private static void guardarEcosistemas(ArrayList<Ecosistema> ecosistemas, String nomFichero) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(nomFichero);
		} catch (FileNotFoundException e) {
			System.out.println("La ruta no existe");
			return;
		}
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ecosistemas);
		} catch (IOException e) {
			System.out.println(e);
			try {
				fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		try {
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static Ecosistema ecosistemaMasLongevo(ArrayList<Ecosistema> ecosistemas) {
		//Programa un método ecosistemaMasLongevo en la clase Principal que devuelva el ecosistema de
		//la lista que más años pueda mantener Organismos en su simulación.
		Ecosistema masLongevo = ecosistemas.get(0);
		int anyos = 0;
		for(Ecosistema ecosistema: ecosistemas) {
			int cont =0;
			do {
				ecosistema.simularAnyo();
				cont++;
			}while(ecosistema.calcularEdadMaxMedia()>0);
			if(cont>anyos) {
				anyos = cont;
				masLongevo = ecosistema;
			}
		}
		return masLongevo;
	}

	private static HashMap<Clima,HashSet<Ecosistema>> agrupaPorClima(ArrayList<Ecosistema> ecosistemas) {
		HashMap<Clima,HashSet<Ecosistema>> agrupacionClima = new HashMap<>();
		for(Ecosistema ecosistema: ecosistemas) {
			agrupacionClima.putIfAbsent(ecosistema.clima, new HashSet<Ecosistema>());
			agrupacionClima.get(ecosistema.clima).add(ecosistema);
		}
		
		return agrupacionClima;
	}
	
//	private static boolean puedeVivir(Organismo organismo, Clima clima,
//			HashMap<TipoOrganismo, ArrayList<Organismo>> orgs) {
//		boolean puede = false;
//		
//		// Si el clima es compatible...
//		if (organismo.getClimas().contains(clima)) {
//			if (organismo instanceof Planta) {
//				// Todas las plantas del clima apropiado son viables
//				puede = true;
//			} else if (organismo instanceof Herbivoro) {
//				// Un herbívoro solo es viable si existe alguna planta que pueda comer
//				Herbivoro herbivoro = (Herbivoro) organismo;
//				ArrayList<Organismo> plantas = orgs.get(TipoOrganismo.PLANTA);
//				if (plantas != null) {
//					for (Organismo planta : herbivoro.getAlimentacion()) {
//						if (plantas.contains(planta)) {
//							puede = true;
//							break;
//						}
//					}
//				}
//			} else if (organismo instanceof Carnivoro) {
//				// Un carnívoro solo es viable si existe algún animal que pueda comer
//				Carnivoro carnivoro = (Carnivoro) organismo;
//				// getOrDefault nos da la lista que pedimos o, si no está, una lista vacía
//				ArrayList<Organismo> herbivoros = orgs.getOrDefault(TipoOrganismo.HERBIVORO, new ArrayList<Organismo>());
//				ArrayList<Organismo> animales = orgs.getOrDefault(TipoOrganismo.CARNIVORO, new ArrayList<Organismo>());
//				animales.addAll(herbivoros); // concatenamos las dos listas					
//				for (Organismo animal : carnivoro.getAlimentacion()) {
//					if (animales.contains(animal)) {
//						puede = true;
//						break;
//					}
//				}
//			}
//		}
//		return puede;
//	}
	private static boolean puedeVivir(Organismo organismo, Clima clima) {
		boolean puede = false;
		
		// Si el clima es compatible...
		if (organismo.getClimas().contains(clima)) {
			puede = true;
		}
		return puede;
	}

	private static ArrayList<Ecosistema> generarEcosistemasViables(ArrayList<Organismo> organismos) {
		ArrayList<Ecosistema> ecosistemas = new ArrayList<Ecosistema>();
		
		for (int i = 0; i < 100; i++) {
			// agua aleatoria de 10000 a 20000 m3
			double agua = 10000 + Math.random() * 10000;
			// clima aleatorio entre todos los de Clima.values()
			int alea = (int) (Math.random() * Clima.values().length);
			Clima clima = Clima.values()[alea];
			// mapa de organismos
			HashMap<TipoOrganismo, ArrayList<Organismo>> orgs = new HashMap<>();
			
			for (int j = 0; j < 30; j++) {
				// Elegir un organismo aleatorio que sea viable en este ecosistema
				Organismo organismo;
				int aleat = 0;
				do {
					aleat = (int) (Math.random() * organismos.size());
					organismo = organismos.get(aleat);
				} while (!puedeVivir(organismo, clima));
				
				// Añadir el organismo al mapa orgs
				TipoOrganismo tipo;
				
				if (organismo instanceof Planta) {
					tipo = TipoOrganismo.PLANTA;
					organismo = new Planta((Planta) organismos.get(aleat));
				} else if (organismo instanceof Herbivoro) {
					tipo = TipoOrganismo.HERBIVORO;
					organismo = new Herbivoro((Herbivoro) organismos.get(aleat));
				} else {
					tipo = TipoOrganismo.CARNIVORO;
					organismo = new Carnivoro((Carnivoro) organismos.get(aleat));
				}
				
				if (orgs.containsKey(tipo)) {
					// Añadir el organismo a la lista orgs.get(tipo)
					orgs.get(tipo).add(organismo);
				} else {
					// Crear la lista y añadir
					orgs.put(tipo, new ArrayList<Organismo>());
					orgs.get(tipo).add(organismo);
				}
				
			}
			
			Ecosistema ecosistema = new Ecosistema(agua, clima, orgs);
			
			ecosistemas.add(ecosistema);
		}
		
		return ecosistemas;
	}

	private static ArrayList<Ecosistema> generarEcosistemas(ArrayList<Organismo> organismos) {
		ArrayList<Ecosistema> ecosistemas = new ArrayList<Ecosistema>();
		
		for (int i = 0; i < 100; i++) {
			// agua aleatoria de 10000 a 20000 m3
			double agua = 10000 + Math.random() * 10000;
			// clima aleatorio entre todos los de Clima.values()
			int alea = (int) (Math.random() * Clima.values().length);
			Clima clima = Clima.values()[alea];
			// mapa de organismos
			HashMap<TipoOrganismo, ArrayList<Organismo>> orgs = new HashMap<>();
			
			for (int j = 0; j < 30; j++) {
				// Elegir un organismo aleatorio
				int aleat = (int) (Math.random() * organismos.size());
				Organismo organismo = organismos.get(aleat);
				
				// Añadir el organismo al mapa orgs
				TipoOrganismo tipo;
				
				if (organismo instanceof Planta) {
					tipo = TipoOrganismo.PLANTA;
					organismo = new Planta((Planta) organismos.get(aleat));
				} else if (organismo instanceof Herbivoro) {
					tipo = TipoOrganismo.HERBIVORO;
					organismo = new Herbivoro((Herbivoro) organismos.get(aleat));
				} else {
					tipo = TipoOrganismo.CARNIVORO;
					organismo = new Carnivoro((Carnivoro) organismos.get(aleat));
				}
				
				if (orgs.containsKey(tipo)) {
					// Añadir el organismo a la lista orgs.get(tipo)
					orgs.get(tipo).add(organismo);
				} else {
					// Crear la lista y añadir
					orgs.put(tipo, new ArrayList<Organismo>());
					orgs.get(tipo).add(organismo);
				}
				
			}
			
			Ecosistema ecosistema = new Ecosistema(agua, clima, orgs);
			
			ecosistemas.add(ecosistema);
		}
		
		return ecosistemas;
	}

	private static void cargarOrganismosCSV(ArrayList<Organismo> organismos) {
		File f = new File("src/es/deusto/prog3/cap01/ecosistemas/organismos.csv");
		try {
			Scanner sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				String tipo = campos[0];
				String especie = campos[1];
				//double edad = Double.parseDouble(campos[2]);
				double edadMin = Double.parseDouble(campos[3]);
				double edadMax = Double.parseDouble(campos[4]);
				int reproduccion = Integer.parseInt(campos[5]);
				String climas = campos[6];
				String alimentacion = campos[7];
				
				Organismo nuevo;
				
				// Preparamos la lista de climas a partir del String climas...
				ArrayList<Clima> listaClimas = new ArrayList<Clima>();
				
				for (String clima : climas.split(",")) {
					listaClimas.add(Clima.valueOf(clima));
				}
				
				// Creamos el organismo en función de su tipo
				if (tipo.equals("Planta")) {
					// Planta
					nuevo = new Planta(especie, listaClimas, edadMin, edadMax, reproduccion, Double.parseDouble(alimentacion));
				} else if (tipo.equals("Herbivoro")) {
					// Herbivoro
					// Falta añadir las plantas a la alimentación de este herbívoro
					String[] plantas = alimentacion.split(",");
					ArrayList<Planta> alim = new ArrayList<Planta>();
					for (String planta : plantas) {
						for (Organismo organismo : organismos) {
							if (organismo.getEspecie().equals(planta)) {
								alim.add((Planta) organismo);
							}
						}
					}
					nuevo = new Herbivoro(especie, listaClimas, edadMin, edadMax, reproduccion, alim);
				} else {
					// Carnivoro
					// Falta añadir los animales a la alimentación de este herbívoro
					String[] animales = alimentacion.split(",");
					ArrayList<Animal> alim = new ArrayList<Animal>();
					for (String animal : animales) {
						for (Organismo organismo : organismos) {
							if (organismo.getEspecie().equals(animal)) {
								alim.add((Animal) organismo);
							}
						}
					}
					nuevo = new Carnivoro(especie, listaClimas, edadMin, edadMax, reproduccion, alim);
					
				}
				
				organismos.add(nuevo);
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static boolean comePlantas(String alimentacion, ArrayList<Organismo> organismos) {
		boolean hayPlantas = false;
		
		for (String nombre : alimentacion.split(",")) {
			for (Organismo organismo : organismos) {
				if (organismo.getEspecie().equals(nombre) && organismo instanceof Planta) {
					hayPlantas = true;
					break;
				}
			}
		}
		
		return hayPlantas;
	}

}
