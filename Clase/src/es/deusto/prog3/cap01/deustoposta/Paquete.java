package es.deusto.prog3.cap01.deustoposta;


public class Paquete extends Envio {

    private double peso;

    public Paquete(String identificador, Ubicacion destino, String fechaEntrega, double peso) {
    	super(identificador, destino, fechaEntrega);
        this.peso = peso;
    }   

	@Override
	public double getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "PAQ: "+super.toString()+" Peso: "+peso;
	}
}

