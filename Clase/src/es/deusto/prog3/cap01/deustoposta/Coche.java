package es.deusto.prog3.cap01.deustoposta;


public class Coche extends Vehiculo {
    public Coche(String id, Ubicacion ubicacionActual) {
        super(id, ubicacionActual);
    }

	@Override
	public int estimarTiempo(Ubicacion nuevaUbicacion) {
		double dist = Utilidades.calcularDistancia(getUbicacionActual(), nuevaUbicacion);
		return (int) (dist/80.0);
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
		return 80.0;
	}
	
	@Override
	public String toString() {
		return "Coche: "+super.toString();
	}

    
}
