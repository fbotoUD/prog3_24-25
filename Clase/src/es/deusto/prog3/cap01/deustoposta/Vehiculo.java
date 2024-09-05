package es.deusto.prog3.cap01.deustoposta;


public abstract class Vehiculo implements Disponible {
    private String id;
    private Ubicacion ubicacionActual;

    public Vehiculo(String id, Ubicacion ubicacionActual) {
        this.id = id;
        this.ubicacionActual = ubicacionActual;
    }

    public String getId() {
        return id;
    }

    public Ubicacion getUbicacionActual() {
        return ubicacionActual;
    }

    public void setUbicacionActual(Ubicacion ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }
    
    @Override
    public boolean equals(Object obj) {
    	return id.equals(((Vehiculo)obj).getId());
    }
    
    @Override
    public String toString() {
    	return id;
    }
}
