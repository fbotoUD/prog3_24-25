package es.deusto.prog3.cap01.deustoposta;


public class Bicicleta extends Vehiculo {
    public Bicicleta(String id, Ubicacion ubicacionActual) {
        super(id, ubicacionActual);
    }

	@Override
	public int estimarTiempo(Ubicacion nuevaUbicacion) {
		double dist = Utilidades.calcularDistancia(getUbicacionActual(), nuevaUbicacion);
		return (int) (dist/15.0);
	}

	@Override
	public boolean asignarOrden(Orden orden) {
		if(orden.getCarga().getPeso()<getPesoMaximoCarga()) {
			orden.setVehiculo(this);
			return true;
		}
		return false;
	}

	@Override
	public double getPesoMaximoCarga() {
		return 20;
	}
	
	@Override
	public String toString() {
		return "Bici: "+super.toString();
	}
}
