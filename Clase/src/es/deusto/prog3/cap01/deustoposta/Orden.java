package es.deusto.prog3.cap01.deustoposta;


public class Orden implements Comparable<Orden>{
    private String id;
    private Ubicacion origen;
    private Ubicacion destino;
    private Envio carga;
    private Vehiculo vehiculo;

    public Orden(String id, Ubicacion destino, Envio carga) {
        this.id = id;
        this.destino = destino;
        this.carga = carga;
    }
    
    public Orden(String id, Ubicacion destino, Envio carga,Ubicacion origen,Vehiculo vehiculo) {
        this.id = id;
        this.destino = destino;
        this.carga = carga;
        this.origen = origen;
        this.vehiculo = vehiculo;
    }

    public String getId() {
        return id;
    }

    public Ubicacion getOrigen() {
        return origen;
    }

    public Ubicacion getDestino() {
        return destino;
    }

    public Envio getCarga() {
        return carga;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
    
    public Vehiculo getVehiculo() {
		return vehiculo;
	}
    
    @Override
    public String toString() {
    	return "Orden ID: "+id+" "+carga+" asignado a: "+vehiculo;
    }
    
    @Override
    public boolean equals(Object obj) {
    	return id.equals(((Orden)obj).getId());
    }

	@Override
	public int compareTo(Orden o) {
		return carga.getFechaEntrega().compareTo(o.getCarga().getFechaEntrega());
	}
}

