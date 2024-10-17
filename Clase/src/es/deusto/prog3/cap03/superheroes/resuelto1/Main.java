package es.deusto.prog3.cap03.superheroes.resuelto1;

import java.util.Arrays;
import java.util.List;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {		
		//Se crean 11 personajes y 9 comics
		
		//START-CHATGPT-MODIFICADO 
		Personaje diana = new Personaje(1, "Diana of Themiscyra", "wonder.woman@gmail.com", Personaje.Editorial.DC);
		Personaje ororo = new Personaje(2, "Ororo Munroe", "storm@gmail.com", Personaje.Editorial.MARVEL);
		Personaje linda = new Personaje(3, "Linda Lee Danvers", "supergirl@gmail.com", Personaje.Editorial.DC);
		Personaje selina = new Personaje(4, "Selina Kyle", "catwoman@gmail.com", Personaje.Editorial.DC);
		Personaje bruceBanner = new Personaje(5, "Bruce Banner", "hulk@gmail.com", Personaje.Editorial.MARVEL);
		Personaje steveRogers = new Personaje(6, "Steve Rogers", "captain.america@gmail.com", Personaje.Editorial.MARVEL);
		Personaje clarkKent = new Personaje(7, "Clark Kent", "superman@gmail.com", Personaje.Editorial.DC);
		Personaje bruceWayne = new Personaje(8, "Bruce Wayne", "batman@gmail.com", Personaje.Editorial.DC);
		Personaje peterParker = new Personaje(9, "Peter Parker", "spiderman@gmail.com", Personaje.Editorial.MARVEL);
		Personaje jamesLogan = new Personaje(10, "James Logan", "wolverine@gmail.com", Personaje.Editorial.MARVEL);
		
        Comic comic1 = new Comic(1, Personaje.Editorial.DC, "Gods and Mortals");
        Comic comic2 = new Comic(2, Personaje.Editorial.DC, "The New Frontier");
        Comic comic3 = new Comic(3, Personaje.Editorial.DC, "Court of Owls");
        Comic comic4 = new Comic(4, Personaje.Editorial.DC, "The Supergirl From Krypton");
        Comic comic5 = new Comic(5, Personaje.Editorial.DC, "Batman & Catwoman 1");
        Comic comic6 = new Comic(6, Personaje.Editorial.MARVEL, "X-Men Gold");
        Comic comic7 = new Comic(7, Personaje.Editorial.MARVEL, "Civil War 1");
        Comic comic8 = new Comic(8, Personaje.Editorial.MARVEL, "The Coming of the Hulk");
        Comic comic9 = new Comic(9, Personaje.Editorial.MARVEL, "Amazing Fantasy");

        comic1.addPersonaje(diana);
        comic2.addPersonaje(diana);
        comic2.addPersonaje(bruceWayne);
        comic2.addPersonaje(clarkKent);
        comic3.addPersonaje(bruceWayne);
        comic4.addPersonaje(clarkKent);
        comic4.addPersonaje(linda);
        comic5.addPersonaje(selina);
        comic5.addPersonaje(bruceWayne);
        comic6.addPersonaje(jamesLogan);
        comic6.addPersonaje(ororo);
        comic7.addPersonaje(steveRogers);
        comic7.addPersonaje(peterParker);
        comic7.addPersonaje(jamesLogan);
        comic8.addPersonaje(bruceBanner);
        comic9.addPersonaje(peterParker);
		//END-CHATGPT
        
		//Se crea una lista de comics
		List<Comic> comics = Arrays.asList(comic1, comic2, comic3, 
										   comic4, comic5, comic6, 
										   comic7, comic8, comic9);		
				
		//Lambda expression para abrir la ventana Principal
		SwingUtilities.invokeLater(() -> new JFramePrincipal(comics));
	}	
}