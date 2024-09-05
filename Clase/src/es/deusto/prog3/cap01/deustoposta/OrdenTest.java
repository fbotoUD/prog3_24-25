package es.deusto.prog3.cap01.deustoposta;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class OrdenTest {

	@Test
	void testOrden() {
		Ubicacion destino = new Ubicacion(-33.9, 151.2);
		Envio envio = new Documento("DOC004",destino , "02/07/2024", 12.0, 9.0);
		Orden orden1 = new Orden("O1",envio.getDestino(),envio);
		assertNotNull(orden1, "Se crea un objeto vacío");
		assertEquals(orden1.getId(), "O1");
		assertEquals(orden1.getDestino(), destino);
	}
	
	@Test
	void testEquals() {
		Ubicacion destino = new Ubicacion(-33.9, 151.2);
		Envio envio1 = new Documento("DOC004",destino , "02/07/2024", 12.0, 9.0);
		Envio envio2 = new Paquete("PKG011", new Ubicacion(19.4, 99.1), "15/07/2024", 14.2);
		Orden orden1 = new Orden("O1",envio1.getDestino(),envio1);
		Orden orden2 = new Orden("O2",envio2.getDestino(),envio2);
		Orden orden3 = new Orden("O1",envio1.getDestino(),envio1);
		assertNotEquals(orden1, orden2);
		assertEquals(orden1, orden3);
	}
	
	@Test
	void testGenerar() {
		
		List<Orden> ordenes = Utilidades.generarOrdenesAux(Utilidades.leerEnviosAux());
		System.out.println(ordenes.size());
		if(ordenes.size()!=58) fail();
	}
	
	

}
