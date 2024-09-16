package es.deusto.prog3.cap01.deustoposta;


public interface Disponible {
    public int estimarTiempo(Ubicacion nuevaUbicacion);
    public boolean asignarOrden(Orden orden);
    public double getPesoMaximoCarga();
}
