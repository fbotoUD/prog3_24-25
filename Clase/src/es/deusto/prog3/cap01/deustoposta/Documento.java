package es.deusto.prog3.cap01.deustoposta;


public class Documento extends Envio {
	
	double largo;
	double ancho;
	
	public Documento(String identificador, Ubicacion destino, String fechaEntrega, double largo, double ancho) {
		super(identificador, destino, fechaEntrega);
		this.largo = largo;
		this.ancho = ancho;		
	}

	@Override
	public double getPeso() {
		return largo*ancho*0.5;
	}

	@Override
	public String toString() {
		return "DOC: "+getIdentificador()+" L: "+largo+" W: "+ancho;
	}

}
